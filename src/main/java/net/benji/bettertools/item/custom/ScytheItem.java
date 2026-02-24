package net.benji.bettertools.item.custom;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ScytheItem extends HoeItem {

    public ScytheItem(Tier material, int attackDamageModifier, float attackSpeedModifier, Properties settings) {
        super(material, attackDamageModifier, attackSpeedModifier, settings);
    }

    public ScytheItem(Tier material, Properties settings) {
        this(material, 3, -3.2F, settings);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        ItemStack itemStack = useOnContext.getItemInHand();

        if (level instanceof ServerLevel) {
            // Get all positions in 3x3 area around the clicked position
            List<BlockPos> positionsToHoe = get3x3Positions(blockPos);

            boolean anyBlockHoed = false;

            for (BlockPos targetPos : positionsToHoe) {
                UseOnContext context = new UseOnContext(level, player, useOnContext.getHand(), itemStack,
                        new BlockHitResult(useOnContext.getClickLocation(), useOnContext.getClickedFace(), targetPos, useOnContext.isInside()));
                Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = TILLABLES.get(
                        level.getBlockState(targetPos).getBlock()
                );
                if (pair != null) {
                    Predicate<UseOnContext> predicate = pair.getFirst();
                    Consumer<UseOnContext> consumer = pair.getSecond();
                    if (predicate.test(context)) {
                        level.playSound(player, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        consumer.accept(context);
                        anyBlockHoed = true;
                    }
                }
            }

            if (anyBlockHoed) {
                // Damage the tool once for the original block
                if (player != null) {
                    itemStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(useOnContext.getHand()));
                }
                return InteractionResult.SUCCESS;
            }
        }

        // Fall back to default hoe behavior if no custom hoeing happened
        return super.useOn(useOnContext);
    }

    private List<BlockPos> get3x3Positions(BlockPos center) {
        List<BlockPos> positions = new ArrayList<>();

        // Create 3x3 area on the same Y level (horizontal plane)
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                positions.add(center.offset(x, 0, z));
            }
        }

        return positions;
    }
}
