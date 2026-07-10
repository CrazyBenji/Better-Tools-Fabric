package net.benji.bettertools.data;

import net.benji.bettertools.data.recipes.PaxelRecipeBuilder;
import net.benji.bettertools.item.BetterToolsItems;
import net.benji.bettertools.item.crafting.WoodChiselingRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class BetterToolsRecipeProvider extends FabricRecipeProvider {
    public BetterToolsRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registryLookup, @NonNull RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                generateHammerRecipe(exporter, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_HAMMER);
                generateHammerRecipe(exporter, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_HAMMER);
                generateHammerRecipe(exporter, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_HAMMER);
                netheriteSmithing(BetterToolsItems.DIAMOND_HAMMER, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_HAMMER);
                generateHammerRecipe(exporter, Items.COPPER_INGOT, Items.COPPER_BLOCK, BetterToolsItems.COPPER_HAMMER);
                generateHammerRecipe(exporter, Items.AMETHYST_SHARD, Items.AMETHYST_BLOCK, BetterToolsItems.AMETHYST_HAMMER);

                generateScytheRecipe(exporter, Items.IRON_INGOT, BetterToolsItems.IRON_SCYTHE);
                generateScytheRecipe(exporter, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_SCYTHE);
                generateScytheRecipe(exporter, Items.DIAMOND, BetterToolsItems.DIAMOND_SCYTHE);
                netheriteSmithing(BetterToolsItems.DIAMOND_SCYTHE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_SCYTHE);
                generateScytheRecipe(exporter, Items.COPPER_INGOT, BetterToolsItems.COPPER_SCYTHE);
                generateScytheRecipe(exporter, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_SCYTHE);

                generatePaxelRecipe(exporter, Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, BetterToolsItems.IRON_PAXEL);
                generatePaxelRecipe(exporter, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, BetterToolsItems.GOLDEN_PAXEL);
                generatePaxelRecipe(exporter, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, BetterToolsItems.DIAMOND_PAXEL);
                netheriteSmithing(BetterToolsItems.DIAMOND_PAXEL, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_PAXEL);
                generatePaxelRecipe(exporter, Items.COPPER_PICKAXE, Items.COPPER_AXE, Items.COPPER_SHOVEL, BetterToolsItems.COPPER_PAXEL);
                generatePaxelRecipe(exporter, BetterToolsItems.AMETHYST_PICKAXE, BetterToolsItems.AMETHYST_AXE, BetterToolsItems.AMETHYST_SHOVEL, BetterToolsItems.AMETHYST_PAXEL);

                shaped(RecipeCategory.TOOLS, BetterToolsItems.GLASS_CHIPPER, 1)
                        .pattern(" i")
                        .pattern("s ")
                        .define('i', Items.IRON_INGOT)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, BetterToolsItems.BEDROCK_SMASHER, 1)
                        .pattern("ini")
                        .pattern(" s ")
                        .pattern(" s ")
                        .define('i', Items.NETHERITE_INGOT)
                        .define('n', Items.NETHER_STAR)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                        .save(exporter);

                shaped(RecipeCategory.TOOLS, BetterToolsItems.WOOD_CHISEL, 1)
                        .pattern("n")
                        .pattern("i")
                        .pattern("l")
                        .define('n', Items.IRON_NUGGET)
                        .define('i', Items.IRON_INGOT)
                        .define('l', ItemTags.LOGS)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(exporter);

                generateLumberAxeRecipe(exporter, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_LUMBER_AXE);
                generateLumberAxeRecipe(exporter, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_LUMBER_AXE);
                generateLumberAxeRecipe(exporter, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_LUMBER_AXE);
                netheriteSmithing(BetterToolsItems.DIAMOND_LUMBER_AXE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_LUMBER_AXE);
                generateLumberAxeRecipe(exporter, Items.COPPER_INGOT, Items.COPPER_BLOCK, BetterToolsItems.COPPER_LUMBER_AXE);
                generateLumberAxeRecipe(exporter, Items.AMETHYST_SHARD, Items.AMETHYST_BLOCK, BetterToolsItems.AMETHYST_LUMBER_AXE);

                generateMacheteRecipe(exporter, Items.IRON_INGOT, BetterToolsItems.IRON_MACHETE);
                generateMacheteRecipe(exporter, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_MACHETE);
                generateMacheteRecipe(exporter, Items.DIAMOND, BetterToolsItems.DIAMOND_MACHETE);
                netheriteSmithing(BetterToolsItems.DIAMOND_MACHETE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_MACHETE);
                generateMacheteRecipe(exporter, Items.COPPER_INGOT, BetterToolsItems.COPPER_MACHETE);
                generateMacheteRecipe(exporter, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_MACHETE);

                generateSwordRecipe(exporter, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_SWORD);
                generateShovelRecipe(exporter, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_SHOVEL);
                generatePickaxeRecipe(exporter, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_PICKAXE);
                generateAxeRecipe(exporter, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_AXE);
                generateHoeRecipe(exporter, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_HOE);

                SpecialRecipeBuilder.special(WoodChiselingRecipe::new).save(exporter, "wood_chiseling");
            }

            public void generatePaxelRecipe(RecipeOutput recipeOutput, Item pickaxe, Item axe, Item shovel, Item output) {
                PaxelRecipeBuilder.paxel(registries.lookupOrThrow(Registries.ITEM), RecipeCategory.TOOLS, output, 1)
                        .pattern("pas")
                        .pattern(" r ")
                        .pattern(" r ")
                        .define('p', pickaxe)
                        .define('a', axe)
                        .define('s', shovel)
                        .define('r', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(pickaxe), has(pickaxe))
                        .save(recipeOutput);
            }

            public void generateHammerRecipe(RecipeOutput recipeOutput, Item ingot, Item block, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("mbm")
                        .pattern("msm")
                        .pattern(" s ")
                        .define('m', ingot)
                        .define('b', block)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }

            public void generateScytheRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("mmm")
                        .pattern(" sm")
                        .pattern(" s ")
                        .define('m', ingot)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }

            public void generateLumberAxeRecipe(RecipeOutput recipeOutput, Item ingot, Item block, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("ib")
                        .pattern("is")
                        .pattern(" s")
                        .define('i', ingot)
                        .define('b', block)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }

            public void generateMacheteRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("  i")
                        .pattern(" i ")
                        .pattern("s  ")
                        .define('i', ingot)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }

            public void generateSwordRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern(" i ")
                        .pattern(" i ")
                        .pattern(" s ")
                        .define('i', ingot)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }
            public void generateShovelRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern(" i ")
                        .pattern(" s ")
                        .pattern(" s ")
                        .define('i', ingot)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }
            public void generatePickaxeRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("iii")
                        .pattern(" s ")
                        .pattern(" s ")
                        .define('i', ingot)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }
            public void generateAxeRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("ii ")
                        .pattern("is ")
                        .pattern(" s ")
                        .define('i', ingot)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }
            public void generateHoeRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("ii ")
                        .pattern(" s ")
                        .pattern(" s ")
                        .define('i', ingot)
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(recipeOutput);
            }
        };
    }

    @Override
    public @NotNull String getName() {
        return "BetterToolsRecipeProvider";
    }
}
