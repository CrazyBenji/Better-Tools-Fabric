package net.benji.bettertools.data;

import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.util.BetterToolsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class BetterToolsBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BetterToolsBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider arg) {
        this.valueLookupBuilder(BetterToolsTags.Blocks.PAXEL_MINEABLE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_AXE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.valueLookupBuilder(BetterToolsTags.Blocks.GLASS_CHIPPER_MINEABLE)
                .addOptionalTag(ConventionalBlockTags.GLASS_BLOCKS)
                .addOptionalTag(ConventionalBlockTags.GLASS_PANES)
                .add(Blocks.TINTED_GLASS)
                .add(Blocks.SEA_LANTERN)
                .add(Blocks.GLOWSTONE)
                .add(Blocks.REDSTONE_LAMP);

        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BetterToolsBlocks.SMASHED_BEDROCK);

        this.valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BetterToolsBlocks.SMASHED_BEDROCK);

        this.valueLookupBuilder(BetterToolsTags.Blocks.MACHETE_MINEABLE)
                .addOptionalTag(BlockTags.LEAVES)
                .addOptionalTag(BlockTags.FLOWERS)
                .add(Blocks.SHORT_GRASS)
                .add(Blocks.FERN)
                .add(Blocks.TALL_GRASS)
                .add(Blocks.LARGE_FERN)
                .add(Blocks.BAMBOO)
                .add(Blocks.NETHER_WART_BLOCK)
                .add(Blocks.WARPED_WART_BLOCK)
                .add(Blocks.CRIMSON_ROOTS)
                .add(Blocks.WARPED_ROOTS);

        this.valueLookupBuilder(BetterToolsTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL)
                .addOptionalTag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.valueLookupBuilder(BetterToolsTags.Blocks.MACHETE_VEIN_MINES)
                .addOptionalTag(BetterToolsTags.Blocks.MACHETE_MINEABLE);

        this.valueLookupBuilder(BetterToolsTags.Blocks.LUMBER_AXE_VEIN_MINES)
                .addOptionalTag(BlockTags.LOGS);
    }
}
