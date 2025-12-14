package net.benji.bettertools.item.custom;

import net.benji.bettertools.util.BetterToolsTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class GlassChipperItem extends Item {
    public GlassChipperItem(ToolMaterial tier, float attackDamage, float attackSpeed, Properties properties) {
        super(properties.tool(tier, BetterToolsTags.Blocks.GLASS_CHIPPER_MINEABLE, attackDamage, attackSpeed, 0));
    }
}