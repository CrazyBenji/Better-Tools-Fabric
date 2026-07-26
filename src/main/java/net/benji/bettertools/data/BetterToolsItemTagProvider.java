package net.benji.bettertools.data;

import net.benji.bettertools.item.BetterToolsItems;
import net.benji.bettertools.util.BetterToolsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class BetterToolsItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public BetterToolsItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(BetterToolsTags.Items.HAMMERS)
                .add(BetterToolsItems.IRON_HAMMER)
                .add(BetterToolsItems.GOLDEN_HAMMER)
                .add(BetterToolsItems.DIAMOND_HAMMER)
                .add(BetterToolsItems.NETHERITE_HAMMER)
                .add(BetterToolsItems.COPPER_HAMMER)
                .add(BetterToolsItems.AMETHYST_HAMMER);

        getOrCreateTagBuilder(BetterToolsTags.Items.PAXELS)
                .add(BetterToolsItems.IRON_PAXEL)
                .add(BetterToolsItems.GOLDEN_PAXEL)
                .add(BetterToolsItems.DIAMOND_PAXEL)
                .add(BetterToolsItems.NETHERITE_PAXEL)
                .add(BetterToolsItems.COPPER_PAXEL)
                .add(BetterToolsItems.AMETHYST_PAXEL);

        getOrCreateTagBuilder(BetterToolsTags.Items.SCYTHES)
                .add(BetterToolsItems.IRON_SCYTHE)
                .add(BetterToolsItems.GOLDEN_SCYTHE)
                .add(BetterToolsItems.DIAMOND_SCYTHE)
                .add(BetterToolsItems.NETHERITE_SCYTHE)
                .add(BetterToolsItems.COPPER_SCYTHE)
                .add(BetterToolsItems.AMETHYST_SCYTHE);

        getOrCreateTagBuilder(BetterToolsTags.Items.GLASS_CHIPPERS)
                .add(BetterToolsItems.GLASS_CHIPPER);

        getOrCreateTagBuilder(BetterToolsTags.Items.LUMBER_AXES)
                .add(BetterToolsItems.IRON_LUMBER_AXE)
                .add(BetterToolsItems.GOLDEN_LUMBER_AXE)
                .add(BetterToolsItems.DIAMOND_LUMBER_AXE)
                .add(BetterToolsItems.NETHERITE_LUMBER_AXE)
                .add(BetterToolsItems.COPPER_LUMBER_AXE)
                .add(BetterToolsItems.AMETHYST_LUMBER_AXE);

        getOrCreateTagBuilder(BetterToolsTags.Items.MACHETES)
                .add(BetterToolsItems.IRON_MACHETE)
                .add(BetterToolsItems.GOLDEN_MACHETE)
                .add(BetterToolsItems.DIAMOND_MACHETE)
                .add(BetterToolsItems.NETHERITE_MACHETE)
                .add(BetterToolsItems.COPPER_MACHETE)
                .add(BetterToolsItems.AMETHYST_MACHETE);

        getOrCreateTagBuilder(BetterToolsTags.Items.PROSPECTING_PICKS)
                .add(BetterToolsItems.IRON_PROSPECTING_PICK)
                .add(BetterToolsItems.GOLDEN_PROSPECTING_PICK)
                .add(BetterToolsItems.DIAMOND_PROSPECTING_PICK)
                .add(BetterToolsItems.NETHERITE_PROSPECTING_PICK)
                .add(BetterToolsItems.COPPER_PROSPECTING_PICK)
                .add(BetterToolsItems.AMETHYST_PROSPECTING_PICK);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.GLASS_CHIPPERS)
                .addTag(BetterToolsTags.Items.MACHETES)
                .addTag(BetterToolsTags.Items.PROSPECTING_PICKS);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.MACHETES)
                .addTag(BetterToolsTags.Items.PROSPECTING_PICKS);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.GLASS_CHIPPERS)
                .add(BetterToolsItems.BEDROCK_SMASHER)
                .addTag(BetterToolsTags.Items.MACHETES)
                .addTag(BetterToolsTags.Items.PROSPECTING_PICKS);

        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.LUMBER_AXES);

        getOrCreateTagBuilder(BetterToolsTags.Items.AMETHYST_TOOL_MATERIALS)
                .add(Items.AMETHYST_SHARD);

        getOrCreateTagBuilder(BetterToolsTags.Items.COPPER_TOOL_MATERIALS)
                .add(Items.COPPER_INGOT);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(BetterToolsItems.COPPER_SWORD)
                .add(BetterToolsItems.AMETHYST_SWORD);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(BetterToolsItems.COPPER_SHOVEL)
                .add(BetterToolsItems.AMETHYST_SHOVEL);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(BetterToolsItems.COPPER_PICKAXE)
                .add(BetterToolsItems.AMETHYST_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(BetterToolsItems.COPPER_AXE)
                .add(BetterToolsItems.AMETHYST_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(BetterToolsItems.COPPER_HOE)
                .add(BetterToolsItems.AMETHYST_HOE);

        getOrCreateTagBuilder(BetterToolsTags.Items.COPPER_TOOLS)
                .add(BetterToolsItems.COPPER_SWORD)
                .add(BetterToolsItems.COPPER_SHOVEL)
                .add(BetterToolsItems.COPPER_PICKAXE)
                .add(BetterToolsItems.COPPER_AXE)
                .add(BetterToolsItems.COPPER_HOE)
                .add(BetterToolsItems.COPPER_HAMMER)
                .add(BetterToolsItems.COPPER_PAXEL)
                .add(BetterToolsItems.COPPER_SCYTHE)
                .add(BetterToolsItems.COPPER_LUMBER_AXE)
                .add(BetterToolsItems.COPPER_MACHETE)
                .add(BetterToolsItems.COPPER_PROSPECTING_PICK);

        getOrCreateTagBuilder(BetterToolsTags.Items.AMETHYST_TOOLS)
                .add(BetterToolsItems.AMETHYST_SWORD)
                .add(BetterToolsItems.AMETHYST_SHOVEL)
                .add(BetterToolsItems.AMETHYST_PICKAXE)
                .add(BetterToolsItems.AMETHYST_AXE)
                .add(BetterToolsItems.AMETHYST_HOE)
                .add(BetterToolsItems.AMETHYST_HAMMER)
                .add(BetterToolsItems.AMETHYST_PAXEL)
                .add(BetterToolsItems.AMETHYST_SCYTHE)
                .add(BetterToolsItems.AMETHYST_LUMBER_AXE)
                .add(BetterToolsItems.AMETHYST_MACHETE)
                .add(BetterToolsItems.AMETHYST_PROSPECTING_PICK);
    }
}
