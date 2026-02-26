package net.benji.bettertools.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LumberAxeItem extends AxeItem {
    private final int maxLogs;
    private final Set<BlockPos> toBreak;

    private static final Component DESC = Component.translatable("desc.bettertools.lumber_axe").withStyle(ChatFormatting.BLUE);

    public LumberAxeItem(Tier tier, Properties properties, int maxLogs) {
        super(tier, 6.0F, -3.2F, properties);
        this.maxLogs = maxLogs;
        this.toBreak = new HashSet<>();
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity player) {
        if (level instanceof ServerLevel serverLevel && state.is(BlockTags.LOGS)) {
            breakConnectedLogs(serverLevel, pos);
            for (BlockPos breakPos : toBreak) {
                level.destroyBlock(breakPos, true);
                stack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(player.getUsedItemHand()));
            }
            this.toBreak.clear();
        }

        return true;
    }

    private void breakConnectedLogs(ServerLevel level, BlockPos startPos) {
        if (this.toBreak.size() >= this.maxLogs) {
            return;
        }
        Set<BlockPos> toCheck = populateSet(startPos);

        for (BlockPos pos : toCheck) {
            if (this.toBreak.size() >= this.maxLogs) {
                return;
            }
            if (!this.toBreak.contains(pos) && level.getBlockState(pos).is(BlockTags.LOGS)) {
                this.toBreak.add(pos);
                this.breakConnectedLogs(level, pos);
            }
        }
    }

    @SuppressWarnings("all")
    private Set<BlockPos> populateSet(BlockPos pos) {
        Set<BlockPos> set = new HashSet<>();
        set.add(pos.east());
        set.add(pos.east().north());
        set.add(pos.west());
        set.add(pos.west().south());
        set.add(pos.north());
        set.add(pos.north().west());
        set.add(pos.south());
        set.add(pos.south().east());

        set.add(pos.above());
        set.add(pos.east().above());
        set.add(pos.east().north().above());
        set.add(pos.west().above());
        set.add(pos.west().south().above());
        set.add(pos.north().above());
        set.add(pos.north().west().above());
        set.add(pos.south().above());
        set.add(pos.south().east().above());

        return set;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, tooltipComponents, tooltipFlag);

        if (tooltipFlag.isAdvanced()) {
            tooltipComponents.add(CommonComponents.EMPTY);
            tooltipComponents.add(DESC);
        }
    }
}
