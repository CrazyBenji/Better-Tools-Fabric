package net.benji.bettertools.item.custom;

import net.benji.bettertools.util.BetterToolsTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;

public class GlassChipperItem extends DiggerItem {
    public GlassChipperItem(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(attackDamageModifier, attackSpeedModifier, tier, BetterToolsTags.Blocks.GLASS_CHIPPER_MINEABLE, properties);
    }

    public GlassChipperItem(Tier tier, Properties properties) {
        this(tier, 0F, -3.2F, properties);
    }
}