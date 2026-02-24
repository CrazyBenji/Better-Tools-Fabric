package net.benji.bettertools.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MacheteItem extends DiggerItem {
    protected final int maxFoliage;

    public MacheteItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties, int maxFoliage) {
        super(attackDamageModifier, attackSpeedModifier, tier, null, properties); // Make tag
        this.maxFoliage = maxFoliage;
    }

    public MacheteItem(Tier tier, Properties properties, int maxFoliage) {
        this(tier, 2.0F, -2.8F, properties, maxFoliage);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext useOnContext) {
        BlockPos blockPos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        Level level = useOnContext.getLevel();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();
        assert player != null;
        ItemStack itemStack = player.getUseItem();

        if (level instanceof ServerLevel serverLevel) {
            if (block instanceof CropBlock) {
                LootParams.Builder lootBuilder = new LootParams.Builder(serverLevel)
                        .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(blockPos))
                        .withParameter(LootContextParams.TOOL, itemStack)
                        .withOptionalParameter(LootContextParams.THIS_ENTITY, player)
                        .withParameter(LootContextParams.BLOCK_STATE, blockState);
                List<ItemStack> drops = blockState.getDrops(lootBuilder);

                level.setBlock(blockPos, block.defaultBlockState(), 0);

                for (ItemStack drop : drops) {
                    Block.popResource(level, blockPos, drop);
                }
            }
        }

        return super.useOn(useOnContext);
    }
}
