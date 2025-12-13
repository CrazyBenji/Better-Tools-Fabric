package net.benji.bettertools.item.custom;

import net.benji.bettertools.util.BetterToolsTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ToolMaterial;

public class GlassChipperItem extends DiggerItem {
    public GlassChipperItem(ToolMaterial tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, BetterToolsTags.Blocks.GLASS_CHIPPER_MINEABLE, attackDamage, attackSpeed, properties);
    }
}