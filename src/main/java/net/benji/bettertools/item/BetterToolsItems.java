package net.benji.bettertools.item;

import net.benji.bettertools.BetterToolsFabric;
import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.item.custom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Function;

public class BetterToolsItems {
    public static final Item IRON_HAMMER = registerItem(
            "iron_hammer",
            properties -> new HammerItem(Tiers.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_HAMMER = registerItem(
            "golden_hammer",
            properties -> new HammerItem(Tiers.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_HAMMER = registerItem(
            "diamond_hammer",
            properties -> new HammerItem(Tiers.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_HAMMER = registerItem(
            "netherite_hammer",
            properties -> new HammerItem(Tiers.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_HAMMER = registerItem(
            "copper_hammer",
            properties -> new HammerItem(BetterToolsTiers.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_HAMMER = registerItem(
            "amethyst_hammer",
            properties -> new HammerItem(BetterToolsTiers.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item IRON_PAXEL = registerItem(
            "iron_paxel",
            properties -> new PaxelItem(Tiers.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_PAXEL = registerItem(
            "golden_paxel",
            properties -> new PaxelItem(Tiers.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_PAXEL = registerItem(
            "diamond_paxel",
            properties -> new PaxelItem(Tiers.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_PAXEL = registerItem(
            "netherite_paxel",
            properties -> new PaxelItem(Tiers.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_PAXEL = registerItem(
            "copper_paxel",
            properties -> new PaxelItem(BetterToolsTiers.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_PAXEL = registerItem(
            "amethyst_paxel",
            properties -> new PaxelItem(BetterToolsTiers.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item IRON_SCYTHE = registerItem(
            "iron_scythe",
            properties -> new ScytheItem(Tiers.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_SCYTHE = registerItem(
            "golden_scythe",
            properties -> new ScytheItem(Tiers.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_SCYTHE = registerItem(
            "diamond_scythe",
            properties -> new ScytheItem(Tiers.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_SCYTHE = registerItem(
            "netherite_scythe",
            properties -> new ScytheItem(Tiers.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_SCYTHE = registerItem(
            "copper_scythe",
            properties -> new ScytheItem(BetterToolsTiers.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_SCYTHE = registerItem(
            "amethyst_scythe",
            properties -> new ScytheItem(BetterToolsTiers.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item GLASS_CHIPPER = registerItem(
            "glass_chipper",
            properties -> new GlassChipperItem(Tiers.IRON, properties),
            new Item.Properties()
    );

    public static final Item BEDROCK_SMASHER = registerItem(
            "bedrock_smasher",
            properties -> new BlockSmasherItem(() -> Blocks.BEDROCK, () -> BetterToolsBlocks.SMASHED_BEDROCK, properties),
            new Item.Properties().durability(16)
    );

    public static final Item WOOD_CHISEL = registerItem(
            "wood_chisel",
            properties -> new CraftingToolItem(properties, "desc.bettertools.wood_chisel"),
            new Item.Properties().durability(256)
    );

    public static final Item IRON_LUMBER_AXE = registerItem(
            "iron_lumber_axe",
            properties -> new LumberAxeItem(Tiers.IRON, properties, 32),
            new Item.Properties()
    );
    public static final Item GOLDEN_LUMBER_AXE = registerItem(
            "golden_lumber_axe",
            properties -> new LumberAxeItem(Tiers.GOLD, properties, 64),
            new Item.Properties()
    );
    public static final Item DIAMOND_LUMBER_AXE = registerItem(
            "diamond_lumber_axe",
            properties -> new LumberAxeItem(Tiers.DIAMOND, properties, 96),
            new Item.Properties()
    );
    public static final Item NETHERITE_LUMBER_AXE = registerItem(
            "netherite_lumber_axe",
            properties -> new LumberAxeItem(Tiers.NETHERITE, properties, 128),
            new Item.Properties()
    );
    public static final Item COPPER_LUMBER_AXE = registerItem(
            "copper_lumber_axe",
            properties -> new LumberAxeItem(BetterToolsTiers.COPPER, properties, 32),
            new Item.Properties()
    );
    public static final Item AMETHYST_LUMBER_AXE = registerItem(
            "amethyst_lumber_axe",
            properties -> new LumberAxeItem(BetterToolsTiers.AMETHYST, properties, 64),
            new Item.Properties()
    );

    public static final Item IRON_MACHETE = registerItem(
            "iron_machete",
            properties -> new MacheteItem(Tiers.IRON, properties, 16),
            new Item.Properties()
    );
    public static final Item GOLDEN_MACHETE = registerItem(
            "golden_machete",
            properties -> new MacheteItem(Tiers.GOLD, properties, 32),
            new Item.Properties()
    );
    public static final Item DIAMOND_MACHETE = registerItem(
            "diamond_machete",
            properties -> new MacheteItem(Tiers.DIAMOND, properties, 48),
            new Item.Properties()
    );
    public static final Item NETHERITE_MACHETE = registerItem(
            "netherite_machete",
            properties -> new MacheteItem(Tiers.NETHERITE, properties, 64),
            new Item.Properties()
    );
    public static final Item COPPER_MACHETE = registerItem(
            "copper_machete",
            properties -> new MacheteItem(BetterToolsTiers.COPPER, properties, 16),
            new Item.Properties()
    );
    public static final Item AMETHYST_MACHETE = registerItem(
            "amethyst_machete",
            properties -> new MacheteItem(BetterToolsTiers.AMETHYST, properties, 32),
            new Item.Properties()
    );

    public static final Item IRON_PROSPECTING_PICK = registerItem(
            "iron_prospecting_pick",
            properties -> new ProspectingPickItem(Tiers.IRON, properties, 6),
            new Item.Properties()
    );
    public static final Item GOLDEN_PROSPECTING_PICK = registerItem(
            "golden_prospecting_pick",
            properties -> new ProspectingPickItem(Tiers.GOLD, properties, 7),
            new Item.Properties()
    );
    public static final Item DIAMOND_PROSPECTING_PICK = registerItem(
            "diamond_prospecting_pick",
            properties -> new ProspectingPickItem(Tiers.DIAMOND, properties, 12),
            new Item.Properties()
    );
    public static final Item NETHERITE_PROSPECTING_PICK = registerItem(
            "netherite_prospecting_pick",
            properties -> new ProspectingPickItem(Tiers.NETHERITE, properties, 16),
            new Item.Properties()
    );
    public static final Item COPPER_PROSPECTING_PICK = registerItem(
            "copper_prospecting_pick",
            properties -> new ProspectingPickItem(BetterToolsTiers.COPPER, properties, 3),
            new Item.Properties()
    );
    public static final Item AMETHYST_PROSPECTING_PICK = registerItem(
            "amethyst_prospecting_pick",
            properties -> new ProspectingPickItem(BetterToolsTiers.AMETHYST, properties, 9),
            new Item.Properties()
    );

    public static final Item COPPER_SWORD = registerItem(
            "copper_sword",
            properties -> new SwordItem(BetterToolsTiers.COPPER, properties.attributes(SwordItem.createAttributes(BetterToolsTiers.COPPER, 3, -2.4F))),
            new Item.Properties()
    );
    public static final Item COPPER_SHOVEL = registerItem(
            "copper_shovel",
            properties -> new ShovelItem(BetterToolsTiers.COPPER, properties.attributes(ShovelItem.createAttributes(BetterToolsTiers.COPPER, 1.5F, -3.0F))),
            new Item.Properties()
    );
    public static final Item COPPER_PICKAXE = registerItem(
            "copper_pickaxe",
            properties -> new PickaxeItem(BetterToolsTiers.COPPER, properties.attributes(PickaxeItem.createAttributes(BetterToolsTiers.COPPER, 1.0F, -2.8F))),
            new Item.Properties()
    );
    public static final Item COPPER_AXE = registerItem(
            "copper_axe",
            properties -> new AxeItem(BetterToolsTiers.COPPER, properties.attributes(AxeItem.createAttributes(BetterToolsTiers.COPPER, 7.0F, -3.2F))),
            new Item.Properties()
    );
    public static final Item COPPER_HOE = registerItem(
            "copper_hoe",
            properties -> new HoeItem(BetterToolsTiers.COPPER, properties.attributes(HoeItem.createAttributes(BetterToolsTiers.COPPER, -1.0F, -2.0F))),
            new Item.Properties()
    );

    public static final Item AMETHYST_SWORD = registerItem(
            "amethyst_sword",
            properties -> new SwordItem(BetterToolsTiers.AMETHYST, properties.attributes(SwordItem.createAttributes(BetterToolsTiers.AMETHYST, 3, -2.4F))),
            new Item.Properties()
    );
    public static final Item AMETHYST_SHOVEL = registerItem(
            "amethyst_shovel",
            properties -> new ShovelItem(BetterToolsTiers.AMETHYST, properties.attributes(ShovelItem.createAttributes(BetterToolsTiers.AMETHYST, 1.5F, -3.0F))),
            new Item.Properties()
    );
    public static final Item AMETHYST_PICKAXE = registerItem(
            "amethyst_pickaxe",
            properties -> new PickaxeItem(BetterToolsTiers.AMETHYST, properties.attributes(PickaxeItem.createAttributes(BetterToolsTiers.AMETHYST, 1.0F, -2.8F))),
            new Item.Properties()
    );
    public static final Item AMETHYST_AXE = registerItem(
            "amethyst_axe",
            properties -> new AxeItem(BetterToolsTiers.AMETHYST, properties.attributes(AxeItem.createAttributes(BetterToolsTiers.AMETHYST, 7.0F, -3.2F))),
            new Item.Properties()
    );
    public static final Item AMETHYST_HOE = registerItem(
            "amethyst_hoe",
            properties -> new HoeItem(BetterToolsTiers.AMETHYST, properties.attributes(HoeItem.createAttributes(BetterToolsTiers.AMETHYST, -1.0F, -2.0F))),
            new Item.Properties()
    );

    public static void registerItems() {
        BetterToolsFabric.LOGGER.info("Registering Mod Items for " + BetterToolsFabric.MOD_ID);
    }

    public static Item registerItem(String key, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, key), itemFactory.apply(properties));
    }
}
