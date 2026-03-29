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

    public static void registerItems() {
        BetterToolsFabric.LOGGER.info("Registering Mod Items for " + BetterToolsFabric.MOD_ID);
    }

    public static Item registerItem(String key, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, key), itemFactory.apply(properties));
    }
}
