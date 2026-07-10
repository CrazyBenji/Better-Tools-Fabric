package net.benji.bettertools.block;

import net.benji.bettertools.BetterToolsFabric;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class BetterToolsBlocks {
    public static final Block SMASHED_BEDROCK = registerBlock(
            BetterToolsBlockItemIds.SMASHED_BEDROCK,
            Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN),
            true);

    private static Block registerBlock(BlockItemId blockItemId, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = blockItemId.block();
        Block block = blockFactory.apply(settings.setId(blockKey));
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = blockItemId.item();
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    public static void registerBlocks() {
        BetterToolsFabric.LOGGER.info("Registering Mod Blocks for " + BetterToolsFabric.MOD_ID);
    }

}
