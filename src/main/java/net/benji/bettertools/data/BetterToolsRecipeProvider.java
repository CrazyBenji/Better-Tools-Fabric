package net.benji.bettertools.data;

import net.benji.bettertools.data.recipes.PaxelRecipeBuilder;
import net.benji.bettertools.item.BetterToolsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class BetterToolsRecipeProvider extends FabricRecipeProvider {
    public BetterToolsRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    public void generatePaxelRecipe(RecipeOutput recipeOutput, Item pickaxe, Item axe, Item shovel, Item output) {
        PaxelRecipeBuilder.paxel(pickaxe, axe, shovel, output)
                .unlockedBy(getHasName(pickaxe), has(pickaxe))
                .save(recipeOutput);
    }

    public void generateHammerRecipe(RecipeOutput recipeOutput, Item ingot, Item block, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("mbm")
                .pattern("msm")
                .pattern(" s ")
                .define('m', ingot)
                .define('b', block)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    public void generateSickleRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("mmm")
                .pattern(" sm")
                .pattern(" s ")
                .define('m', ingot)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    public void generateLumberAxeRecipe(RecipeOutput recipeOutput, Item ingot, Item block, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("ib")
                .pattern("is")
                .pattern(" s")
                .define('i', ingot)
                .define('b', block)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    public void generateMacheteRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("  i")
                .pattern(" i ")
                .pattern("s  ")
                .define('i', ingot)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        generateHammerRecipe(recipeOutput, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_HAMMER);
        generateHammerRecipe(recipeOutput, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_HAMMER);
        generateHammerRecipe(recipeOutput, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_HAMMER);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_HAMMER, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_HAMMER);

        generateSickleRecipe(recipeOutput, Items.IRON_INGOT, BetterToolsItems.IRON_SCYTHE);
        generateSickleRecipe(recipeOutput, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_SCYTHE);
        generateSickleRecipe(recipeOutput, Items.DIAMOND, BetterToolsItems.DIAMOND_SCYTHE);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_SCYTHE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_SCYTHE);

        generatePaxelRecipe(recipeOutput, Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, BetterToolsItems.IRON_PAXEL);
        generatePaxelRecipe(recipeOutput, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, BetterToolsItems.GOLDEN_PAXEL);
        generatePaxelRecipe(recipeOutput, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, BetterToolsItems.DIAMOND_PAXEL);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_PAXEL, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_PAXEL);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BetterToolsItems.GLASS_CHIPPER, 1)
                .pattern(" i")
                .pattern("s ")
                .define('i', Items.IRON_INGOT)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BetterToolsItems.BEDROCK_SMASHER, 1)
                .pattern("ini")
                .pattern(" s ")
                .pattern(" s ")
                .define('i', Items.NETHERITE_INGOT)
                .define('n', Items.NETHER_STAR)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(recipeOutput);

        generateLumberAxeRecipe(recipeOutput, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_LUMBER_AXE);
        generateLumberAxeRecipe(recipeOutput, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_LUMBER_AXE);
        generateLumberAxeRecipe(recipeOutput, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_LUMBER_AXE);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_LUMBER_AXE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_LUMBER_AXE);

        generateMacheteRecipe(recipeOutput, Items.IRON_INGOT, BetterToolsItems.IRON_MACHETE);
        generateMacheteRecipe(recipeOutput, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_MACHETE);
        generateMacheteRecipe(recipeOutput, Items.DIAMOND, BetterToolsItems.DIAMOND_MACHETE);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_MACHETE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_MACHETE);
    }
}
