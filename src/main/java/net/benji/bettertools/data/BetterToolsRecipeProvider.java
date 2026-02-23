package net.benji.bettertools.data;

import net.benji.bettertools.data.recipes.PaxelRecipeBuilder;
import net.benji.bettertools.item.BetterToolsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class BetterToolsRecipeProvider extends FabricRecipeProvider {
    public BetterToolsRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    public void generatePaxelRecipe(Consumer<FinishedRecipe> writer, Item pickaxe, Item axe, Item shovel, Item result) {
        PaxelRecipeBuilder.paxel(pickaxe, axe, shovel, result)
                .unlockedBy(getHasName(Items.IRON_PICKAXE), has(Items.IRON_PICKAXE))
                .save(writer);
    }

    public void generateHammerRecipe(Consumer<FinishedRecipe> writer, Item ingot, Item block, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("mbm")
                .pattern("msm")
                .pattern(" s ")
                .define('m', ingot)
                .define('b', block)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(writer);
    }

    public void generateSickleRecipe(Consumer<FinishedRecipe> writer, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("mmm")
                .pattern(" sm")
                .pattern(" s ")
                .define('m', ingot)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(writer);
    }

    public void generateLumberAxeRecipe(Consumer<FinishedRecipe> writer, Item ingot, Item block, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("ib")
                .pattern("is")
                .pattern(" s")
                .define('i', ingot)
                .define('b', block)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(writer);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> writer) {
        generateHammerRecipe(writer, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_HAMMER);
        generateHammerRecipe(writer, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_HAMMER);
        generateHammerRecipe(writer, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_HAMMER);
        netheriteSmithing(writer, BetterToolsItems.DIAMOND_HAMMER, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_HAMMER);

        generateSickleRecipe(writer, Items.IRON_INGOT, BetterToolsItems.IRON_SCYTHE);
        generateSickleRecipe(writer, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_SCYTHE);
        generateSickleRecipe(writer, Items.DIAMOND, BetterToolsItems.DIAMOND_SCYTHE);
        netheriteSmithing(writer, BetterToolsItems.DIAMOND_SCYTHE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_SCYTHE);

        generatePaxelRecipe(writer, Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, BetterToolsItems.IRON_PAXEL);
        generatePaxelRecipe(writer, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, BetterToolsItems.GOLDEN_PAXEL);
        generatePaxelRecipe(writer, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, BetterToolsItems.DIAMOND_PAXEL);
        netheriteSmithing(writer, BetterToolsItems.DIAMOND_PAXEL, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_PAXEL);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BetterToolsItems.GLASS_CHIPPER, 1)
                .pattern(" i")
                .pattern("s ")
                .define('i', Items.IRON_INGOT)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BetterToolsItems.BEDROCK_SMASHER, 1)
                .pattern("ini")
                .pattern(" s ")
                .pattern(" s ")
                .define('i', Items.NETHERITE_INGOT)
                .define('n', Items.NETHER_STAR)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(writer);

        generateLumberAxeRecipe(writer, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_LUMBER_AXE);
        generateLumberAxeRecipe(writer, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_LUMBER_AXE);
        generateLumberAxeRecipe(writer, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_LUMBER_AXE);
        netheriteSmithing(writer, BetterToolsItems.DIAMOND_LUMBER_AXE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_LUMBER_AXE);
    }
}
