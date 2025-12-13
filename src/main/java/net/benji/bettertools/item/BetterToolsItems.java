package net.benji.bettertools.item;

import net.benji.bettertools.BetterToolsFabric;
import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.item.custom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Function;

public class BetterToolsItems {
    public static final Item IRON_HAMMER = registerItem(
            "iron_hammer",
            properties -> new HammerItem(ToolMaterial.IRON, 1.0f, -2.8f, properties),
            new Item.Properties());
    public static final Item GOLDEN_HAMMER = registerItem(
            "golden_hammer",
            properties -> new HammerItem(ToolMaterial.GOLD, 1.0f, -2.8f, properties),
            new Item.Properties());
    public static final Item DIAMOND_HAMMER = registerItem(
            "diamond_hammer",
            properties -> new HammerItem(ToolMaterial.DIAMOND, 1.0f, -2.8f, properties),
            new Item.Properties());
    public static final Item NETHERITE_HAMMER = registerItem(
            "netherite_hammer",
            properties -> new HammerItem(ToolMaterial.NETHERITE, 1.0f, -2.8f, properties),
            new Item.Properties());

    public static final Item IRON_PAXEL = registerItem(
            "iron_paxel",
            properties -> new PaxelItem(ToolMaterial.IRON, 3.0f, -2.8f, properties),
            new Item.Properties());
    public static final Item GOLDEN_PAXEL = registerItem(
            "golden_paxel",
            properties -> new PaxelItem(ToolMaterial.GOLD, 3.0f, -2.8f, properties),
            new Item.Properties());
    public static final Item DIAMOND_PAXEL = registerItem(
            "diamond_paxel",
            properties -> new PaxelItem(ToolMaterial.DIAMOND, 3.0f, -2.8f, properties),
            new Item.Properties());
    public static final Item NETHERITE_PAXEL = registerItem(
            "netherite_paxel",
            properties -> new PaxelItem(ToolMaterial.NETHERITE, 3.0f, -2.8f, properties),
            new Item.Properties());

    public static final Item IRON_SCYTHE = registerItem(
            "iron_scythe",
            properties -> new ScytheItem(ToolMaterial.IRON, 3.0f, -3.2f, properties),
            new Item.Properties());
    public static final Item GOLDEN_SCYTHE = registerItem(
            "golden_scythe",
            properties -> new ScytheItem(ToolMaterial.GOLD, 3.0f, -3.2f, properties),
            new Item.Properties());
    public static final Item DIAMOND_SCYTHE = registerItem(
            "diamond_scythe",
            properties -> new ScytheItem(ToolMaterial.DIAMOND, 3.0f, -3.2f, properties),
            new Item.Properties());
    public static final Item NETHERITE_SCYTHE = registerItem(
            "netherite_scythe",
            properties -> new ScytheItem(ToolMaterial.NETHERITE, 3.0f, -3.2f, properties),
            new Item.Properties());

    public static final Item GLASS_CHIPPER = registerItem(
            "glass_chipper",
            properties -> new GlassChipperItem(ToolMaterial.IRON, 0.0f, -3.2f, properties),
            new Item.Properties());

    public static final Item BEDROCK_SMASHER = registerItem(
            "bedrock_smasher",
            properties -> new BlockSmasherItem(() -> Blocks.BEDROCK, () -> BetterToolsBlocks.SMASHED_BEDROCK, properties),
            new Item.Properties().durability(16));

    public static final Item IRON_LUMBER_AXE = registerItem("iron_lumber_axe",
            properties -> new LumberAxeItem(ToolMaterial.IRON, 6.0f, -3.1f, properties, 32),
            new Item.Properties());
    public static final Item GOLDEN_LUMBER_AXE = registerItem("golden_lumber_axe",
            properties -> new LumberAxeItem(ToolMaterial.GOLD, 6.0f, -3.1f, properties, 64),
            new Item.Properties());
    public static final Item DIAMOND_LUMBER_AXE = registerItem("diamond_lumber_axe",
            properties -> new LumberAxeItem(ToolMaterial.DIAMOND, 6.0f, -3.1f, properties, 96),
            new Item.Properties());
    public static final Item NETHERITE_LUMBER_AXE = registerItem("netherite_lumber_axe",
            properties -> new LumberAxeItem(ToolMaterial.NETHERITE, 6.0f, -3.1f, properties, 128),
            new Item.Properties());

    public static void registerModItems() {
        BetterToolsFabric.LOGGER.info("Registering Mod Items for " + BetterToolsFabric.MOD_ID);
    }

    public static Item registerItem(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, name));
        Item item = itemFactory.apply(properties.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
}
