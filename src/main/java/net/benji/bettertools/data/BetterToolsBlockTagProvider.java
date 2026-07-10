package net.benji.bettertools.data;

import net.benji.bettertools.block.BetterToolsBlockItemIds;
import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.util.BetterToolsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;
import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class BetterToolsBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public BetterToolsBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider arg) {
        this.tag(BetterToolsTags.Blocks.PAXEL_MINEABLE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_AXE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BetterToolsTags.Blocks.GLASS_CHIPPER_MINEABLE)
                .addOptionalTag(ConventionalBlockTags.GLASS_BLOCKS)
                .addOptionalTag(ConventionalBlockTags.GLASS_PANES)
                .add(BlockItemIds.TINTED_GLASS.block())
                .add(BlockItemIds.SEA_LANTERN.block())
                .add(BlockItemIds.GLOWSTONE.block())
                .add(BlockItemIds.REDSTONE_LAMP.block());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BetterToolsBlockItemIds.SMASHED_BEDROCK.block());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BetterToolsBlockItemIds.SMASHED_BEDROCK.block());

        this.tag(BetterToolsTags.Blocks.MACHETE_MINEABLE)
                .addOptionalTag(BlockTags.LEAVES)
                .addOptionalTag(BlockTags.FLOWERS)
                .add(BlockItemIds.SHORT_GRASS.block())
                .add(BlockItemIds.FERN.block())
                .add(BlockItemIds.TALL_GRASS.block())
                .add(BlockItemIds.LARGE_FERN.block())
                .add(BlockItemIds.BAMBOO.block())
                .add(BlockItemIds.NETHER_WART_BLOCK.block())
                .add(BlockItemIds.WARPED_WART_BLOCK.block())
                .add(BlockItemIds.CRIMSON_ROOTS.block())
                .add(BlockItemIds.WARPED_ROOTS.block());

        this.tag(BetterToolsTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL)
                .addOptionalTag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BetterToolsTags.Blocks.MACHETE_VEIN_MINES)
                .addOptionalTag(BetterToolsTags.Blocks.MACHETE_MINEABLE);

        this.tag(BetterToolsTags.Blocks.LUMBER_AXE_VEIN_MINES)
                .addOptionalTag(BlockTags.LOGS);
    }
}
