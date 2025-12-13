package net.benji.bettertools.data;

import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.item.BetterToolsItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

public class BetterToolsModelProvider extends FabricModelProvider {
    public BetterToolsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialBlock(BetterToolsBlocks.SMASHED_BEDROCK, TexturedModel.CUBE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(BetterToolsItems.IRON_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.GOLDEN_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.DIAMOND_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.NETHERITE_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(BetterToolsItems.IRON_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.GOLDEN_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.DIAMOND_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.NETHERITE_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(BetterToolsItems.IRON_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.GOLDEN_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.DIAMOND_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.NETHERITE_SCYTHE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(BetterToolsItems.GLASS_CHIPPER, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(BetterToolsItems.BEDROCK_SMASHER, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(BetterToolsItems.IRON_LUMBER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.GOLDEN_LUMBER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.DIAMOND_LUMBER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BetterToolsItems.NETHERITE_LUMBER_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
