package net.benji.bettertools.item;

import net.benji.bettertools.BetterToolsFabric;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class BetterToolsItemIds {
    public static final ResourceKey<Item> IRON_HAMMER = create("iron_hammer");
    public static final ResourceKey<Item> GOLDEN_HAMMER = create("golden_hammer");
    public static final ResourceKey<Item> DIAMOND_HAMMER = create("diamond_hammer");
    public static final ResourceKey<Item> NETHERITE_HAMMER = create("netherite_hammer");
    public static final ResourceKey<Item> COPPER_HAMMER = create("copper_hammer");
    public static final ResourceKey<Item> AMETHYST_HAMMER = create("amethyst_hammer");

    public static final ResourceKey<Item> IRON_PAXEL = create("iron_paxel");
    public static final ResourceKey<Item> GOLDEN_PAXEL = create("golden_paxel");
    public static final ResourceKey<Item> DIAMOND_PAXEL = create("diamond_paxel");
    public static final ResourceKey<Item> NETHERITE_PAXEL = create("netherite_paxel");
    public static final ResourceKey<Item> COPPER_PAXEL = create("copper_paxel");
    public static final ResourceKey<Item> AMETHYST_PAXEL = create("amethyst_paxel");

    public static final ResourceKey<Item> IRON_SCYTHE = create("iron_scythe");
    public static final ResourceKey<Item> GOLDEN_SCYTHE = create("golden_scythe");
    public static final ResourceKey<Item> DIAMOND_SCYTHE = create("diamond_scythe");
    public static final ResourceKey<Item> NETHERITE_SCYTHE = create("netherite_scythe");
    public static final ResourceKey<Item> COPPER_SCYTHE = create("copper_scythe");
    public static final ResourceKey<Item> AMETHYST_SCYTHE = create("amethyst_scythe");

    public static final ResourceKey<Item> IRON_LUMBER_AXE = create("iron_lumber_axe");
    public static final ResourceKey<Item> GOLDEN_LUMBER_AXE = create("golden_lumber_axe");
    public static final ResourceKey<Item> DIAMOND_LUMBER_AXE = create("diamond_lumber_axe");
    public static final ResourceKey<Item> NETHERITE_LUMBER_AXE = create("netherite_lumber_axe");
    public static final ResourceKey<Item> COPPER_LUMBER_AXE = create("copper_lumber_axe");
    public static final ResourceKey<Item> AMETHYST_LUMBER_AXE = create("amethyst_lumber_axe");

    public static final ResourceKey<Item> IRON_MACHETE = create("iron_machete");
    public static final ResourceKey<Item> GOLDEN_MACHETE = create("golden_machete");
    public static final ResourceKey<Item> DIAMOND_MACHETE = create("diamond_machete");
    public static final ResourceKey<Item> NETHERITE_MACHETE = create("netherite_machete");
    public static final ResourceKey<Item> COPPER_MACHETE = create("copper_machete");
    public static final ResourceKey<Item> AMETHYST_MACHETE = create("amethyst_machete");

    public static final ResourceKey<Item> AMETHYST_SWORD = create("amethyst_sword");
    public static final ResourceKey<Item> AMETHYST_SHOVEL = create("amethyst_shovel");
    public static final ResourceKey<Item> AMETHYST_PICKAXE = create("amethyst_pickaxe");
    public static final ResourceKey<Item> AMETHYST_AXE = create("amethyst_axe");
    public static final ResourceKey<Item> AMETHYST_HOE = create("amethyst_hoe");

    public static final ResourceKey<Item> GLASS_CHIPPER = create("glass_chipper");
    public static final ResourceKey<Item> BEDROCK_SMASHER = create("bedrock_smasher");
    public static final ResourceKey<Item> WOOD_CHISEL = create("wood_chisel");

    private static ResourceKey<Item> create(final String key) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, key));
    }
}
