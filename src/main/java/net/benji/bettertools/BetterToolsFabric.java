package net.benji.bettertools;

import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.enchantment.BetterToolsEnchantments;
import net.benji.bettertools.item.BetterToolsItemGroups;
import net.benji.bettertools.item.BetterToolsItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterToolsFabric implements ModInitializer {
	public static final String MOD_ID = "bettertools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        BetterToolsItems.registerModItems();
        BetterToolsItemGroups.registerItemGroups();
        BetterToolsBlocks.registerModBlocks();
        BetterToolsEnchantments.registerModEnchantments();
	}
}