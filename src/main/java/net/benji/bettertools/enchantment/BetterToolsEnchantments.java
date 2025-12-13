package net.benji.bettertools.enchantment;

import net.benji.bettertools.BetterToolsFabric;
import net.benji.bettertools.enchantment.custom.ReapingEnchantment;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class BetterToolsEnchantments {
    public static final Enchantment REAPING = register("reaping", new ReapingEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));


    protected static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT, new ResourceLocation(BetterToolsFabric.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        BetterToolsFabric.LOGGER.info("Registering Enchantments for " + BetterToolsFabric.MOD_ID);
    }

}
