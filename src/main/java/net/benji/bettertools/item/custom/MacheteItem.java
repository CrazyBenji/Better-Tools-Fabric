package net.benji.bettertools.item.custom;

import net.benji.bettertools.util.BetterToolsTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MacheteItem extends DiggerItem {
    protected final int maxFoliage;
    protected final Set<BlockPos> toBreak;

    public MacheteItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties, int maxFoliage) {
        super(attackDamageModifier, attackSpeedModifier, tier, BetterToolsTags.Blocks.MACHETE_MINEABLE, properties); // Make tag
        this.maxFoliage = maxFoliage;
        this.toBreak = new HashSet<>();
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
                List<ItemStack> drops = generateLootTable(itemStack, serverLevel, blockState, blockPos, player);

                level.setBlock(blockPos, block.defaultBlockState(), 0);

                for (ItemStack drop : drops) {
                    Block.popResource(level, blockPos, drop);
                }
                player.swing(useOnContext.getHand());
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        if (level instanceof ServerLevel serverLevel && blockState.is(BetterToolsTags.Blocks.MACHETE_MINEABLE)) {
            breakConnectedFoliage(serverLevel, blockPos);
            for (BlockPos breakPos : toBreak) {
                BlockState breakState = level.getBlockState(breakPos);

                List<ItemStack> drops = generateLootTable(itemStack, serverLevel, breakState, breakPos, livingEntity);

                level.destroyBlock(breakPos, false);

                for (ItemStack drop : drops) {
                    Block.popResource(level, blockPos, drop);
                }
                itemStack.hurtAndBreak(1, livingEntity, (player1) -> player1.broadcastBreakEvent(livingEntity.getUsedItemHand()));
            }
            this.toBreak.clear();
        }

        return true;
    }

    private List<ItemStack> generateLootTable(ItemStack itemStack, ServerLevel serverLevel, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        LootParams.Builder lootBuilder = new LootParams.Builder(serverLevel)
                .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(blockPos))
                .withParameter(LootContextParams.TOOL, itemStack)
                .withOptionalParameter(LootContextParams.THIS_ENTITY, livingEntity)
                .withParameter(LootContextParams.BLOCK_STATE, blockState);

        return blockState.getDrops(lootBuilder);
    }

    public void breakConnectedFoliage(ServerLevel serverLevel, BlockPos startingPos) {
        if (this.toBreak.size() >= this.maxFoliage) {
            return;
        }

        Set<BlockPos> toCheck = populateSet(startingPos);

        for (BlockPos blockPos : toCheck) {
            if (this.toBreak.size() >= this.maxFoliage) {
                return;
            }
            if (!this.toBreak.contains(blockPos) && serverLevel.getBlockState(blockPos).is(BetterToolsTags.Blocks.MACHETE_MINEABLE)) {
                this.toBreak.add(blockPos);
                this.breakConnectedFoliage(serverLevel, blockPos);
            }
        }
    }

    @SuppressWarnings("all")
    private Set<BlockPos> populateSet(BlockPos blockPos) {
        Set<BlockPos> set = new HashSet<>();
        set.add(blockPos.east());
        set.add(blockPos.east().north());
        set.add(blockPos.west());
        set.add(blockPos.west().south());
        set.add(blockPos.north());
        set.add(blockPos.north().west());
        set.add(blockPos.south());
        set.add(blockPos.south().east());

        set.add(blockPos.above());
        set.add(blockPos.east().above());
        set.add(blockPos.east().north().above());
        set.add(blockPos.west().above());
        set.add(blockPos.west().south().above());
        set.add(blockPos.north().above());
        set.add(blockPos.north().west().above());
        set.add(blockPos.south().above());
        set.add(blockPos.south().east().above());

        set.add(blockPos.below());
        set.add(blockPos.east().below());
        set.add(blockPos.east().north().below());
        set.add(blockPos.west().below());
        set.add(blockPos.west().south().below());
        set.add(blockPos.north().below());
        set.add(blockPos.north().west().below());
        set.add(blockPos.south().below());
        set.add(blockPos.south().east().below());
        return set;
    }
}
