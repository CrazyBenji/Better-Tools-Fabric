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
            properties -> new HammerItem(ToolMaterial.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_HAMMER = registerItem(
            "golden_hammer",
            properties -> new HammerItem(ToolMaterial.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_HAMMER = registerItem(
            "diamond_hammer",
            properties -> new HammerItem(ToolMaterial.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_HAMMER = registerItem(
            "netherite_hammer",
            properties -> new HammerItem(ToolMaterial.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_HAMMER = registerItem(
            "copper_hammer",
            properties -> new HammerItem(BetterToolsToolMaterials.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_HAMMER = registerItem(
            "amethyst_hammer",
            properties -> new HammerItem(BetterToolsToolMaterials.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item IRON_PAXEL = registerItem(
            "iron_paxel",
            properties -> new PaxelItem(ToolMaterial.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_PAXEL = registerItem(
            "golden_paxel",
            properties -> new PaxelItem(ToolMaterial.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_PAXEL = registerItem(
            "diamond_paxel",
            properties -> new PaxelItem(ToolMaterial.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_PAXEL = registerItem(
            "netherite_paxel",
            properties -> new PaxelItem(ToolMaterial.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_PAXEL = registerItem(
            "copper_paxel",
            properties -> new PaxelItem(BetterToolsToolMaterials.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_PAXEL = registerItem(
            "amethyst_paxel",
            properties -> new PaxelItem(BetterToolsToolMaterials.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item IRON_SCYTHE = registerItem(
            "iron_scythe",
            properties -> new ScytheItem(ToolMaterial.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_SCYTHE = registerItem(
            "golden_scythe",
            properties -> new ScytheItem(ToolMaterial.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_SCYTHE = registerItem(
            "diamond_scythe",
            properties -> new ScytheItem(ToolMaterial.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_SCYTHE = registerItem(
            "netherite_scythe",
            properties -> new ScytheItem(ToolMaterial.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_SCYTHE = registerItem(
            "copper_scythe",
            properties -> new ScytheItem(BetterToolsToolMaterials.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_SCYTHE = registerItem(
            "amethyst_scythe",
            properties -> new ScytheItem(BetterToolsToolMaterials.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item GLASS_CHIPPER = registerItem(
            "glass_chipper",
            properties -> new GlassChipperItem(ToolMaterial.IRON, properties),
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
            properties -> new LumberAxeItem(ToolMaterial.IRON, properties, 32),
            new Item.Properties()
    );
    public static final Item GOLDEN_LUMBER_AXE = registerItem(
            "golden_lumber_axe",
            properties -> new LumberAxeItem(ToolMaterial.GOLD, properties, 64),
            new Item.Properties()
    );
    public static final Item DIAMOND_LUMBER_AXE = registerItem(
            "diamond_lumber_axe",
            properties -> new LumberAxeItem(ToolMaterial.DIAMOND, properties, 96),
            new Item.Properties()
    );
    public static final Item NETHERITE_LUMBER_AXE = registerItem(
            "netherite_lumber_axe",
            properties -> new LumberAxeItem(ToolMaterial.NETHERITE, properties, 128),
            new Item.Properties()
    );
    public static final Item COPPER_LUMBER_AXE = registerItem(
            "copper_lumber_axe",
            properties -> new LumberAxeItem(BetterToolsToolMaterials.COPPER, properties, 32),
            new Item.Properties()
    );
    public static final Item AMETHYST_LUMBER_AXE = registerItem(
            "amethyst_lumber_axe",
            properties -> new LumberAxeItem(BetterToolsToolMaterials.AMETHYST, properties, 64),
            new Item.Properties()
    );

    public static final Item IRON_MACHETE = registerItem(
            "iron_machete",
            properties -> new MacheteItem(ToolMaterial.IRON, properties, 16),
            new Item.Properties()
    );
    public static final Item GOLDEN_MACHETE = registerItem(
            "golden_machete",
            properties -> new MacheteItem(ToolMaterial.GOLD, properties, 32),
            new Item.Properties()
    );
    public static final Item DIAMOND_MACHETE = registerItem(
            "diamond_machete",
            properties -> new MacheteItem(ToolMaterial.DIAMOND, properties, 48),
            new Item.Properties()
    );
    public static final Item NETHERITE_MACHETE = registerItem(
            "netherite_machete",
            properties -> new MacheteItem(ToolMaterial.NETHERITE, properties, 64),
            new Item.Properties()
    );
    public static final Item COPPER_MACHETE = registerItem(
            "copper_machete",
            properties -> new MacheteItem(BetterToolsToolMaterials.COPPER, properties, 16),
            new Item.Properties()
    );
    public static final Item AMETHYST_MACHETE = registerItem(
            "amethyst_machete",
            properties -> new MacheteItem(BetterToolsToolMaterials.AMETHYST, properties, 32),
            new Item.Properties()
    );

    public static final Item COPPER_SWORD = registerItem(
            "copper_sword",
            properties -> new SwordItem(BetterToolsToolMaterials.COPPER, 3.0F, -2.4F, properties),
            new Item.Properties()
    );
    public static final Item COPPER_SHOVEL = registerItem(
            "copper_shovel",
            properties -> new ShovelItem(BetterToolsToolMaterials.COPPER, 1.5F, -3.0F, properties),
            new Item.Properties()
    );
    public static final Item COPPER_PICKAXE = registerItem(
            "copper_pickaxe",
            properties -> new PickaxeItem(BetterToolsToolMaterials.COPPER, 1.0F, -2.8F, properties),
            new Item.Properties()
    );
    public static final Item COPPER_AXE = registerItem(
            "copper_axe",
            properties -> new AxeItem(BetterToolsToolMaterials.COPPER, 7.0F, -3.2F, properties),
            new Item.Properties()
    );
    public static final Item COPPER_HOE = registerItem(
            "copper_hoe",
            properties -> new HoeItem(BetterToolsToolMaterials.COPPER, -1.0F, -2.0F, properties),
            new Item.Properties()
    );

    public static final Item AMETHYST_SWORD = registerItem(
            "amethyst_sword",
            properties -> new SwordItem(BetterToolsToolMaterials.AMETHYST, 3, -2.4F, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_SHOVEL = registerItem(
            "amethyst_shovel",
            properties -> new ShovelItem(BetterToolsToolMaterials.AMETHYST, 1.5F, -3.0F, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_PICKAXE = registerItem(
            "amethyst_pickaxe",
            properties -> new PickaxeItem(BetterToolsToolMaterials.AMETHYST, 1.0F, -2.8F, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_AXE = registerItem(
            "amethyst_axe",
            properties -> new AxeItem(BetterToolsToolMaterials.AMETHYST, 7.0F, -3.2F, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_HOE = registerItem(
            "amethyst_hoe",
            properties -> new HoeItem(BetterToolsToolMaterials.AMETHYST, -1.0F, -2.0F, properties),
            new Item.Properties()
    );

    public static void registerItems() {
        BetterToolsFabric.LOGGER.info("Registering Mod Items for " + BetterToolsFabric.MOD_ID);
    }

    public static Item registerItem(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, name));
        Item item = itemFactory.apply(properties.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
}
