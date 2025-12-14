package net.benji.bettertools.data;

import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.util.BetterToolsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BetterToolsBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BetterToolsBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        valueLookupBuilder(BetterToolsTags.Blocks.PAXEL_MINEABLE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_AXE)
                .addOptionalTag(BlockTags.MINEABLE_WITH_SHOVEL);

        valueLookupBuilder(BetterToolsTags.Blocks.GLASS_CHIPPER_MINEABLE)
                .addOptionalTag(ConventionalBlockTags.GLASS_BLOCKS)
                .addOptionalTag(ConventionalBlockTags.GLASS_PANES)
                .add(Blocks.TINTED_GLASS)
                .add(Blocks.SEA_LANTERN)
                .add(Blocks.GLOWSTONE)
                .add(Blocks.REDSTONE_LAMP);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BetterToolsBlocks.SMASHED_BEDROCK);
    }
}
