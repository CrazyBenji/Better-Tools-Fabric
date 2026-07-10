package net.benji.bettertools.data;

import net.benji.bettertools.item.BetterToolsItemIds;
import net.benji.bettertools.util.BetterToolsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class BetterToolsItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    public BetterToolsItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider arg) {
        this.tag(BetterToolsTags.Items.HAMMERS)
                .add(BetterToolsItemIds.IRON_HAMMER)
                .add(BetterToolsItemIds.GOLDEN_HAMMER)
                .add(BetterToolsItemIds.DIAMOND_HAMMER)
                .add(BetterToolsItemIds.NETHERITE_HAMMER)
                .add(BetterToolsItemIds.COPPER_HAMMER)
                .add(BetterToolsItemIds.AMETHYST_HAMMER);

        this.tag(BetterToolsTags.Items.PAXELS)
                .add(BetterToolsItemIds.IRON_PAXEL)
                .add(BetterToolsItemIds.GOLDEN_PAXEL)
                .add(BetterToolsItemIds.DIAMOND_PAXEL)
                .add(BetterToolsItemIds.NETHERITE_PAXEL)
                .add(BetterToolsItemIds.COPPER_PAXEL)
                .add(BetterToolsItemIds.AMETHYST_PAXEL);

        this.tag(BetterToolsTags.Items.SCYTHES)
                .add(BetterToolsItemIds.IRON_SCYTHE)
                .add(BetterToolsItemIds.GOLDEN_SCYTHE)
                .add(BetterToolsItemIds.DIAMOND_SCYTHE)
                .add(BetterToolsItemIds.NETHERITE_SCYTHE)
                .add(BetterToolsItemIds.COPPER_SCYTHE)
                .add(BetterToolsItemIds.AMETHYST_SCYTHE);

        this.tag(BetterToolsTags.Items.GLASS_CHIPPERS)
                .add(BetterToolsItemIds.GLASS_CHIPPER);

        this.tag(BetterToolsTags.Items.LUMBER_AXES)
                .add(BetterToolsItemIds.IRON_LUMBER_AXE)
                .add(BetterToolsItemIds.GOLDEN_LUMBER_AXE)
                .add(BetterToolsItemIds.DIAMOND_LUMBER_AXE)
                .add(BetterToolsItemIds.NETHERITE_LUMBER_AXE)
                .add(BetterToolsItemIds.COPPER_LUMBER_AXE)
                .add(BetterToolsItemIds.AMETHYST_LUMBER_AXE);

        this.tag(BetterToolsTags.Items.MACHETES)
                .add(BetterToolsItemIds.IRON_MACHETE)
                .add(BetterToolsItemIds.GOLDEN_MACHETE)
                .add(BetterToolsItemIds.DIAMOND_MACHETE)
                .add(BetterToolsItemIds.NETHERITE_MACHETE)
                .add(BetterToolsItemIds.COPPER_MACHETE)
                .add(BetterToolsItemIds.AMETHYST_MACHETE);

        this.tag(ItemTags.MINING_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.GLASS_CHIPPERS)
                .addTag(BetterToolsTags.Items.MACHETES);

        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.MACHETES);

        this.tag(ItemTags.DURABILITY_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.HAMMERS)
                .addTag(BetterToolsTags.Items.PAXELS)
                .addTag(BetterToolsTags.Items.SCYTHES)
                .addTag(BetterToolsTags.Items.LUMBER_AXES)
                .addTag(BetterToolsTags.Items.GLASS_CHIPPERS)
                .add(BetterToolsItemIds.BEDROCK_SMASHER)
                .addTag(BetterToolsTags.Items.MACHETES);

        this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .addTag(BetterToolsTags.Items.LUMBER_AXES);

        this.tag(BetterToolsTags.Items.AMETHYST_TOOL_MATERIALS)
                .add(ItemIds.AMETHYST_SHARD);

        this.tag(ItemTags.SWORDS)
                .add(BetterToolsItemIds.AMETHYST_SWORD);

        this.tag(ItemTags.SHOVELS)
                .add(BetterToolsItemIds.AMETHYST_SHOVEL);

        this.tag(ItemTags.PICKAXES)
                .add(BetterToolsItemIds.AMETHYST_PICKAXE);

        this.tag(ItemTags.AXES)
                .add(BetterToolsItemIds.AMETHYST_AXE);

        this.tag(ItemTags.HOES)
                .add(BetterToolsItemIds.AMETHYST_HOE);

        this.tag(BetterToolsTags.Items.COPPER_TOOLS)
                .add(ItemIds.COPPER_SWORD)
                .add(ItemIds.COPPER_SHOVEL)
                .add(ItemIds.COPPER_PICKAXE)
                .add(ItemIds.COPPER_AXE)
                .add(ItemIds.COPPER_HOE)
                .add(BetterToolsItemIds.COPPER_HAMMER)
                .add(BetterToolsItemIds.COPPER_PAXEL)
                .add(BetterToolsItemIds.COPPER_SCYTHE)
                .add(BetterToolsItemIds.COPPER_LUMBER_AXE)
                .add(BetterToolsItemIds.COPPER_MACHETE);

        this.tag(BetterToolsTags.Items.AMETHYST_TOOLS)
                .add(BetterToolsItemIds.AMETHYST_SWORD)
                .add(BetterToolsItemIds.AMETHYST_SHOVEL)
                .add(BetterToolsItemIds.AMETHYST_PICKAXE)
                .add(BetterToolsItemIds.AMETHYST_AXE)
                .add(BetterToolsItemIds.AMETHYST_HOE)
                .add(BetterToolsItemIds.AMETHYST_HAMMER)
                .add(BetterToolsItemIds.AMETHYST_PAXEL)
                .add(BetterToolsItemIds.AMETHYST_SCYTHE)
                .add(BetterToolsItemIds.AMETHYST_LUMBER_AXE)
                .add(BetterToolsItemIds.AMETHYST_MACHETE);
    }
}
