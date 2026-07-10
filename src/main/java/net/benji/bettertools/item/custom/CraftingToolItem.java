package net.benji.bettertools.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CraftingToolItem extends Item {
    protected final @Nullable Component desc;

    public CraftingToolItem(Properties properties, @Nullable String tooltipLocation) {
        super(properties);

        if (tooltipLocation != null) {
            desc = Component.translatable(tooltipLocation).withStyle(ChatFormatting.BLUE);
        }
        else {
            desc = null;
        }
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack remainder = stack.copy();

        int damage = remainder.getDamageValue() + 1;

        if (damage >= remainder.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        remainder.setDamageValue(damage);
        return remainder;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull TooltipDisplay tooltipDisplay, @NotNull Consumer<Component> tooltipAdder, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, tooltipFlag);

        if (this.desc != null) {
            if (tooltipFlag.isAdvanced()) {
                tooltipAdder.accept(CommonComponents.EMPTY);
                tooltipAdder.accept(this.desc);
            }
        }
    }
}
