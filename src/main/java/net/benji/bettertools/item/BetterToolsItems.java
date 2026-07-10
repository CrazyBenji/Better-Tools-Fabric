package net.benji.bettertools.item;

import net.benji.bettertools.BetterToolsFabric;
import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.item.custom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Function;

public class BetterToolsItems {
    public static final Item IRON_HAMMER = registerItem(
            BetterToolsItemIds.IRON_HAMMER,
            properties -> new HammerItem(ToolMaterial.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_HAMMER = registerItem(
            BetterToolsItemIds.GOLDEN_HAMMER,
            properties -> new HammerItem(ToolMaterial.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_HAMMER = registerItem(
            BetterToolsItemIds.DIAMOND_HAMMER,
            properties -> new HammerItem(ToolMaterial.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_HAMMER = registerItem(
            BetterToolsItemIds.NETHERITE_HAMMER,
            properties -> new HammerItem(ToolMaterial.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_HAMMER = registerItem(
            BetterToolsItemIds.COPPER_HAMMER,
            properties -> new HammerItem(ToolMaterial.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_HAMMER = registerItem(
            BetterToolsItemIds.AMETHYST_HAMMER,
            properties -> new HammerItem(BetterToolsToolMaterials.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item IRON_PAXEL = registerItem(
            BetterToolsItemIds.IRON_PAXEL,
            properties -> new PaxelItem(ToolMaterial.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_PAXEL = registerItem(
            BetterToolsItemIds.GOLDEN_PAXEL,
            properties -> new PaxelItem(ToolMaterial.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_PAXEL = registerItem(
            BetterToolsItemIds.DIAMOND_PAXEL,
            properties -> new PaxelItem(ToolMaterial.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_PAXEL = registerItem(
            BetterToolsItemIds.NETHERITE_PAXEL,
            properties -> new PaxelItem(ToolMaterial.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_PAXEL = registerItem(
            BetterToolsItemIds.COPPER_PAXEL,
            properties -> new PaxelItem(ToolMaterial.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_PAXEL = registerItem(
            BetterToolsItemIds.AMETHYST_PAXEL,
            properties -> new PaxelItem(BetterToolsToolMaterials.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item IRON_SCYTHE = registerItem(
            BetterToolsItemIds.IRON_SCYTHE,
            properties -> new ScytheItem(ToolMaterial.IRON, properties),
            new Item.Properties()
    );
    public static final Item GOLDEN_SCYTHE = registerItem(
            BetterToolsItemIds.GOLDEN_SCYTHE,
            properties -> new ScytheItem(ToolMaterial.GOLD, properties),
            new Item.Properties()
    );
    public static final Item DIAMOND_SCYTHE = registerItem(
            BetterToolsItemIds.DIAMOND_SCYTHE,
            properties -> new ScytheItem(ToolMaterial.DIAMOND, properties),
            new Item.Properties()
    );
    public static final Item NETHERITE_SCYTHE = registerItem(
            BetterToolsItemIds.NETHERITE_SCYTHE,
            properties -> new ScytheItem(ToolMaterial.NETHERITE, properties),
            new Item.Properties()
    );
    public static final Item COPPER_SCYTHE = registerItem(
            BetterToolsItemIds.COPPER_SCYTHE,
            properties -> new ScytheItem(ToolMaterial.COPPER, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_SCYTHE = registerItem(
            BetterToolsItemIds.AMETHYST_SCYTHE,
            properties -> new ScytheItem(BetterToolsToolMaterials.AMETHYST, properties),
            new Item.Properties()
    );

    public static final Item GLASS_CHIPPER = registerItem(
            BetterToolsItemIds.GLASS_CHIPPER,
            properties -> new GlassChipperItem(ToolMaterial.IRON, properties),
            new Item.Properties()
    );

    public static final Item BEDROCK_SMASHER = registerItem(
            BetterToolsItemIds.BEDROCK_SMASHER,
            properties -> new BlockSmasherItem(() -> Blocks.BEDROCK, () -> BetterToolsBlocks.SMASHED_BEDROCK, properties),
            new Item.Properties().durability(16)
    );

    public static final Item WOOD_CHISEL = registerItem(
            BetterToolsItemIds.WOOD_CHISEL,
            properties -> new CraftingToolItem(properties, "desc.bettertools.wood_chisel"),
            new Item.Properties().durability(256)
    );

    public static final Item IRON_LUMBER_AXE = registerItem(
            BetterToolsItemIds.IRON_LUMBER_AXE,
            properties -> new LumberAxeItem(ToolMaterial.IRON, properties, 32),
            new Item.Properties()
    );
    public static final Item GOLDEN_LUMBER_AXE = registerItem(
            BetterToolsItemIds.GOLDEN_LUMBER_AXE,
            properties -> new LumberAxeItem(ToolMaterial.GOLD, properties, 64),
            new Item.Properties()
    );
    public static final Item DIAMOND_LUMBER_AXE = registerItem(
            BetterToolsItemIds.DIAMOND_LUMBER_AXE,
            properties -> new LumberAxeItem(ToolMaterial.DIAMOND, properties, 96),
            new Item.Properties()
    );
    public static final Item NETHERITE_LUMBER_AXE = registerItem(
            BetterToolsItemIds.NETHERITE_LUMBER_AXE,
            properties -> new LumberAxeItem(ToolMaterial.NETHERITE, properties, 128),
            new Item.Properties()
    );
    public static final Item COPPER_LUMBER_AXE = registerItem(
            BetterToolsItemIds.COPPER_LUMBER_AXE,
            properties -> new LumberAxeItem(ToolMaterial.COPPER, properties, 32),
            new Item.Properties()
    );
    public static final Item AMETHYST_LUMBER_AXE = registerItem(
            BetterToolsItemIds.AMETHYST_LUMBER_AXE,
            properties -> new LumberAxeItem(BetterToolsToolMaterials.AMETHYST, properties, 64),
            new Item.Properties()
    );

    public static final Item IRON_MACHETE = registerItem(
            BetterToolsItemIds.IRON_MACHETE,
            properties -> new MacheteItem(ToolMaterial.IRON, properties, 16),
            new Item.Properties()
    );
    public static final Item GOLDEN_MACHETE = registerItem(
            BetterToolsItemIds.GOLDEN_MACHETE,
            properties -> new MacheteItem(ToolMaterial.GOLD, properties, 32),
            new Item.Properties()
    );
    public static final Item DIAMOND_MACHETE = registerItem(
            BetterToolsItemIds.DIAMOND_MACHETE,
            properties -> new MacheteItem(ToolMaterial.DIAMOND, properties, 48),
            new Item.Properties()
    );
    public static final Item NETHERITE_MACHETE = registerItem(
            BetterToolsItemIds.NETHERITE_MACHETE,
            properties -> new MacheteItem(ToolMaterial.NETHERITE, properties, 64),
            new Item.Properties()
    );
    public static final Item COPPER_MACHETE = registerItem(
            BetterToolsItemIds.COPPER_MACHETE,
            properties -> new MacheteItem(ToolMaterial.COPPER, properties, 16),
            new Item.Properties()
    );
    public static final Item AMETHYST_MACHETE = registerItem(
            BetterToolsItemIds.AMETHYST_MACHETE,
            properties -> new MacheteItem(BetterToolsToolMaterials.AMETHYST, properties, 32),
            new Item.Properties()
    );

    public static final Item AMETHYST_SWORD = registerItem(
            BetterToolsItemIds.AMETHYST_SWORD,
            Item::new,
            new Item.Properties().sword(BetterToolsToolMaterials.AMETHYST, 3, -2.4F)
    );
    public static final Item AMETHYST_SHOVEL = registerItem(
            BetterToolsItemIds.AMETHYST_SHOVEL,
            properties -> new ShovelItem(BetterToolsToolMaterials.AMETHYST, 1.5F, -3.0F, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_PICKAXE = registerItem(
            BetterToolsItemIds.AMETHYST_PICKAXE,
            Item::new,
            new Item.Properties().pickaxe(BetterToolsToolMaterials.AMETHYST, 1.0F, -2.8F)
    );
    public static final Item AMETHYST_AXE = registerItem(
            BetterToolsItemIds.AMETHYST_AXE,
            properties -> new AxeItem(BetterToolsToolMaterials.AMETHYST, 7.0F, -3.2F, properties),
            new Item.Properties()
    );
    public static final Item AMETHYST_HOE = registerItem(
            BetterToolsItemIds.AMETHYST_HOE,
            properties -> new HoeItem(BetterToolsToolMaterials.AMETHYST, -1.0F, -2.0F, properties),
            new Item.Properties()
    );

    public static void registerItems() {
        BetterToolsFabric.LOGGER.info("Registering Mod Items for " + BetterToolsFabric.MOD_ID);
    }

    public static Item registerItem(ResourceKey<Item> key, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(key));
        Registry.register(BuiltInRegistries.ITEM, key, item);

        return item;
    }
}
