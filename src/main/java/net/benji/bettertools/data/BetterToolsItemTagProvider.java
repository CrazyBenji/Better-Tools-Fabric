package net.benji.bettertools.data;

import net.benji.bettertools.item.BetterToolsItems;
import net.benji.bettertools.util.BetterToolsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class BetterToolsItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    public BetterToolsItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider arg) {
        this.valueLookupBuilder(BetterToolsTags.Items.HAMMERS)
                .add(BetterToolsItems.IRON_HAMMER)
                .add(BetterToolsItems.GOLDEN_HAMMER)
                .add(BetterToolsItems.DIAMOND_HAMMER)
                .add(BetterToolsItems.NETHERITE_HAMMER)
                .add(BetterToolsItems.COPPER_HAMMER)
                .add(BetterToolsItems.AMETHYST_HAMMER);

        this.valueLookupBuilder(BetterToolsTags.Items.PAXELS)
                .add(BetterToolsItems.IRON_PAXEL)
                .add(BetterToolsItems.GOLDEN_PAXEL)
                .add(BetterToolsItems.DIAMOND_PAXEL)
                .add(BetterToolsItems.NETHERITE_PAXEL)
                .add(BetterToolsItems.COPPER_PAXEL)
                .add(BetterToolsItems.AMETHYST_PAXEL);

        this.valueLookupBuilder(BetterToolsTags.Items.SCYTHES)
                .add(BetterToolsItems.IRON_SCYTHE)
                .add(BetterToolsItems.GOLDEN_SCYTHE)
                .add(BetterToolsItems.DIAMOND_SCYTHE)
                .add(BetterToolsItems.NETHERITE_SCYTHE)
                .add(BetterToolsItems.COPPER_SCYTHE)
                .add(BetterToolsItems.AMETHYST_SCYTHE);

        this.valueLookupBuilder(BetterToolsTags.Items.GLASS_CHIPPERS)
                .add(BetterToolsItems.GLASS_CHIPPER);

        this.valueLookupBuilder(BetterToolsTags.Items.LUMBER_AXES)
                .add(BetterToolsItems.IRON_LUMBER_AXE)
                .add(BetterToolsItems.GOLDEN_LUMBER_AXE)
                .add(BetterToolsItems.DIAMOND_LUMBER_AXE)
                .add(BetterToolsItems.NETHERITE_LUMBER_AXE)
                .add(BetterToolsItems.COPPER_LUMBER_AXE)
                .add(BetterToolsItems.AMETHYST_LUMBER_AXE);

        this.valueLookupBuilder(BetterToolsTags.Items.MACHETES)
                .add(BetterToolsItems.IRON_MACHETE)
                .add(BetterToolsItems.GOLDEN_MACHETE)
                .add(BetterToolsItems.DIAMOND_MACHETE)
                .add(BetterToolsItems.NETHERITE_MACHETE)
                .add(BetterToolsItems.COPPER_MACHETE)
                .add(BetterToolsItems.AMETHYST_MACHETE);

        this.valueLookupBuilder(ItemTags.MINING_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.GLASS_CHIPPERS)
                .addTag(BetterToolsTags.Items.MACHETES);

        this.valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.MACHETES);

        this.valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.GLASS_CHIPPERS)
                .add(BetterToolsItems.BEDROCK_SMASHER)
                .addTag(BetterToolsTags.Items.MACHETES);

        this.valueLookupBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.LUMBER_AXES);

        this.valueLookupBuilder(BetterToolsTags.Items.AMETHYST_TOOL_MATERIALS)
                .add(Items.AMETHYST_SHARD);

        this.valueLookupBuilder(ItemTags.SWORDS)
                .add(BetterToolsItems.AMETHYST_SWORD);

        this.valueLookupBuilder(ItemTags.SHOVELS)
                .add(BetterToolsItems.AMETHYST_SHOVEL);

        this.valueLookupBuilder(ItemTags.PICKAXES)
                .add(BetterToolsItems.AMETHYST_PICKAXE);

        this.valueLookupBuilder(ItemTags.AXES)
                .add(BetterToolsItems.AMETHYST_AXE);

        this.valueLookupBuilder(ItemTags.HOES)
                .add(BetterToolsItems.AMETHYST_HOE);

        this.valueLookupBuilder(BetterToolsTags.Items.COPPER_TOOLS)
                .add(Items.COPPER_SWORD)
                .add(Items.COPPER_SHOVEL)
                .add(Items.COPPER_PICKAXE)
                .add(Items.COPPER_AXE)
                .add(Items.COPPER_HOE)
                .add(BetterToolsItems.COPPER_HAMMER)
                .add(BetterToolsItems.COPPER_PAXEL)
                .add(BetterToolsItems.COPPER_SCYTHE)
                .add(BetterToolsItems.COPPER_LUMBER_AXE)
                .add(BetterToolsItems.COPPER_MACHETE);

        this.valueLookupBuilder(BetterToolsTags.Items.AMETHYST_TOOLS)
                .add(BetterToolsItems.AMETHYST_SWORD)
                .add(BetterToolsItems.AMETHYST_SHOVEL)
                .add(BetterToolsItems.AMETHYST_PICKAXE)
                .add(BetterToolsItems.AMETHYST_AXE)
                .add(BetterToolsItems.AMETHYST_HOE)
                .add(BetterToolsItems.AMETHYST_HAMMER)
                .add(BetterToolsItems.AMETHYST_PAXEL)
                .add(BetterToolsItems.AMETHYST_SCYTHE)
                .add(BetterToolsItems.AMETHYST_LUMBER_AXE)
                .add(BetterToolsItems.AMETHYST_MACHETE);
    }
}
