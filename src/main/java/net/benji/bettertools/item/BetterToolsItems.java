package net.benji.bettertools.item;

import net.benji.bettertools.BetterToolsFabric;
import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.item.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Blocks;

public class BetterToolsItems {
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(Tiers.IRON, new Item.Properties()));
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer",
            new HammerItem(Tiers.GOLD, new Item.Properties()));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(Tiers.DIAMOND, new Item.Properties()));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(Tiers.NETHERITE, new Item.Properties()));

    public static final Item IRON_PAXEL = registerItem("iron_paxel",
            new PaxelItem(Tiers.IRON, new Item.Properties()));
    public static final Item GOLDEN_PAXEL = registerItem("golden_paxel",
            new PaxelItem(Tiers.GOLD, new Item.Properties()));
    public static final Item DIAMOND_PAXEL = registerItem("diamond_paxel",
            new PaxelItem(Tiers.DIAMOND, new Item.Properties()));
    public static final Item NETHERITE_PAXEL = registerItem("netherite_paxel",
            new PaxelItem(Tiers.NETHERITE, new Item.Properties()));

    public static final Item IRON_SCYTHE = registerItem("iron_scythe",
            new ScytheItem(Tiers.IRON, new Item.Properties()));
    public static final Item GOLDEN_SCYTHE = registerItem("golden_scythe",
            new ScytheItem(Tiers.GOLD, new Item.Properties()));
    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe",
            new ScytheItem(Tiers.DIAMOND, new Item.Properties()));
    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe",
            new ScytheItem(Tiers.NETHERITE, new Item.Properties()));

    public static final Item GLASS_CHIPPER = registerItem("glass_chipper",
            new GlassChipperItem(Tiers.IRON, new Item.Properties()));

    public static final Item BEDROCK_SMASHER = registerItem("bedrock_smasher",
            new BlockSmasherItem(() -> Blocks.BEDROCK, () -> BetterToolsBlocks.SMASHED_BEDROCK, new Item.Properties().durability(16)));

    public static final Item IRON_LUMBER_AXE = registerItem("iron_lumber_axe",
            new LumberAxeItem(Tiers.IRON, new Item.Properties(), 32));
    public static final Item GOLDEN_LUMBER_AXE = registerItem("golden_lumber_axe",
            new LumberAxeItem(Tiers.GOLD, new Item.Properties(), 64));
    public static final Item DIAMOND_LUMBER_AXE = registerItem("diamond_lumber_axe",
            new LumberAxeItem(Tiers.DIAMOND, new Item.Properties(), 96));
    public static final Item NETHERITE_LUMBER_AXE = registerItem("netherite_lumber_axe",
            new LumberAxeItem(Tiers.NETHERITE, new Item.Properties(), 128));

    public static final Item IRON_MACHETE = registerItem("iron_machete",
            new MacheteItem(Tiers.IRON, new Item.Properties(), 16));
    public static final Item GOLDEN_MACHETE = registerItem("golden_machete",
            new MacheteItem(Tiers.GOLD, new Item.Properties(), 32));
    public static final Item DIAMOND_MACHETE = registerItem("diamond_machete",
            new MacheteItem(Tiers.IRON, new Item.Properties(), 48));
    public static final Item NETHERITE_MACHETE = registerItem("netherite_machete",
            new MacheteItem(Tiers.NETHERITE, new Item.Properties(), 64));

    public static void registerModItems() {
        BetterToolsFabric.LOGGER.info("Registering Mod Items for " + BetterToolsFabric.MOD_ID);
    }

    public static Item registerItem(String id, Item item) {
        return Items.registerItem(new ResourceLocation(BetterToolsFabric.MOD_ID, id), item);
    }
}
