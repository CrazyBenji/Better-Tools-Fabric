package net.benji.bettertools;

import net.benji.bettertools.data.*;
import net.benji.bettertools.enchantment.BetterToolsEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class BetterToolsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BetterToolsBlockTagProvider::new);
        pack.addProvider(BetterToolsItemTagProvider::new);
        pack.addProvider(BetterToolsModelProvider::new);
        pack.addProvider(BetterToolsRecipeProvider::new);
        pack.addProvider(BetterToolsAdvancementProvider::new);
        // pack.addProvider(BetterToolsLootTableProvider::new);
        pack.addProvider(BetterToolsRegistryDataGenerator::new);
	}

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.ENCHANTMENT, BetterToolsEnchantments::bootstrap);
    }
}
