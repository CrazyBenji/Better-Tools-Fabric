package net.benji.bettertools.item.custom;

import net.benji.bettertools.util.BetterToolsTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class MacheteItem extends Item implements VeinMiningTool {
    protected final int maxBlocks;

    public static Component DESC = Component.translatable("desc.bettertools.machete").withStyle(ChatFormatting.BLUE);

    public MacheteItem(ToolMaterial toolMaterial, float attackDamageModifier, float attackSpeedModifier, Properties properties, int maxBlocks) {
        super(properties.tool(toolMaterial, BetterToolsTags.Blocks.MACHETE_MINEABLE, attackDamageModifier, attackSpeedModifier, 0));
        this.maxBlocks = maxBlocks;
    }

    public MacheteItem(ToolMaterial toolMaterial, Properties properties, int maxBlocks) {
        this(toolMaterial, 2.0F, -2.8F, properties, maxBlocks);
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull BlockState blockState, @NotNull BlockPos blockPos, @NotNull LivingEntity livingEntity) {
        if (level instanceof ServerLevel serverLevel && blockState.is(BetterToolsTags.Blocks.MACHETE_VEIN_MINES)) {
            Set<BlockPos> toBreak = findConnectedBlocks(serverLevel, blockPos, this.maxBlocks, BetterToolsTags.Blocks.MACHETE_VEIN_MINES);
            for (BlockPos breakPos : toBreak) {
                BlockState breakState = level.getBlockState(breakPos);

                List<ItemStack> drops = generateLootTable(itemStack, serverLevel, breakState, breakPos, livingEntity);

                level.destroyBlock(breakPos, false);

                for (ItemStack drop : drops) {
                    Block.popResource(level, blockPos, drop);
                }
                EquipmentSlot equipmentSlot = itemStack.equals(livingEntity.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                itemStack.hurtAndBreak(1, livingEntity, equipmentSlot);
            }
            toBreak.clear();
        }

        return true;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull TooltipDisplay tooltipDisplay, @NotNull Consumer<Component> tooltipAdder, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, tooltipFlag);

        if (tooltipFlag.isAdvanced()) {
            tooltipAdder.accept(CommonComponents.EMPTY);
            tooltipAdder.accept(DESC);
        }
    }
}