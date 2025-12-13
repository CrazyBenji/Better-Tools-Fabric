package net.benji.bettertools.block;

import net.benji.bettertools.BetterToolsFabric;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BetterToolsBlocks {
    public static final Block SMASHED_BEDROCK = registerBlock("smashed_bedrock",
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(BetterToolsFabric.MOD_ID, name), block);

    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(BetterToolsFabric.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));
    }

    public static void registerModBlocks() {
        BetterToolsFabric.LOGGER.info("Registering Mod Blocks for " + BetterToolsFabric.MOD_ID);
    }

}
