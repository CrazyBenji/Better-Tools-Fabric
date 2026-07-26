package net.benji.bettertools.data;

import net.benji.bettertools.data.recipes.PaxelRecipeBuilder;
import net.benji.bettertools.item.BetterToolsItems;
import net.benji.bettertools.item.crafting.WoodChiselingRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class BetterToolsRecipeProvider extends FabricRecipeProvider {
    public BetterToolsRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    public void generatePaxelRecipe(RecipeOutput recipeOutput, Item pickaxe, Item axe, Item shovel, Item output) {
        PaxelRecipeBuilder.paxel(RecipeCategory.TOOLS, output, 1)
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
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
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
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("mmm")
                .pattern(" sm")
                .pattern(" s ")
                .define('m', ingot)
                .define('s', ConventionalItemTags.WOODEN_RODS)
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
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    public void generateMacheteRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("  i")
                .pattern(" i ")
                .pattern("s  ")
                .define('i', ingot)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    public void generateProspectingPickRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("iii")
                .pattern("is ")
                .pattern(" s ")
                .define('i', ingot)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    public void generateSwordRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("i")
                .pattern("i")
                .pattern("s")
                .define('i', ingot)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }
    public void generateShovelRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("i")
                .pattern("s")
                .pattern("s")
                .define('i', ingot)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }
    public void generatePickaxeRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("iii")
                .pattern(" s ")
                .pattern(" s ")
                .define('i', ingot)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }
    public void generateAxeRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("ii")
                .pattern("is")
                .pattern(" s")
                .define('i', ingot)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }
    public void generateHoeRecipe(RecipeOutput recipeOutput, Item ingot, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, output, 1)
                .pattern("ii")
                .pattern(" s")
                .pattern(" s")
                .define('i', ingot)
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        generateHammerRecipe(recipeOutput, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_HAMMER);
        generateHammerRecipe(recipeOutput, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_HAMMER);
        generateHammerRecipe(recipeOutput, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_HAMMER);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_HAMMER, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_HAMMER);
        generateHammerRecipe(recipeOutput, Items.COPPER_INGOT, Items.COPPER_BLOCK, BetterToolsItems.COPPER_HAMMER);
        generateHammerRecipe(recipeOutput, Items.AMETHYST_SHARD, Items.AMETHYST_BLOCK, BetterToolsItems.AMETHYST_HAMMER);

        generateScytheRecipe(recipeOutput, Items.IRON_INGOT, BetterToolsItems.IRON_SCYTHE);
        generateScytheRecipe(recipeOutput, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_SCYTHE);
        generateScytheRecipe(recipeOutput, Items.DIAMOND, BetterToolsItems.DIAMOND_SCYTHE);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_SCYTHE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_SCYTHE);
        generateScytheRecipe(recipeOutput, Items.COPPER_INGOT, BetterToolsItems.COPPER_SCYTHE);
        generateScytheRecipe(recipeOutput, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_SCYTHE);

        generatePaxelRecipe(recipeOutput, Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, BetterToolsItems.IRON_PAXEL);
        generatePaxelRecipe(recipeOutput, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, BetterToolsItems.GOLDEN_PAXEL);
        generatePaxelRecipe(recipeOutput, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, BetterToolsItems.DIAMOND_PAXEL);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_PAXEL, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_PAXEL);
        generatePaxelRecipe(recipeOutput, BetterToolsItems.COPPER_PICKAXE, BetterToolsItems.COPPER_AXE, BetterToolsItems.COPPER_SHOVEL, BetterToolsItems.COPPER_PAXEL);
        generatePaxelRecipe(recipeOutput, BetterToolsItems.AMETHYST_PICKAXE, BetterToolsItems.AMETHYST_AXE, BetterToolsItems.AMETHYST_SHOVEL, BetterToolsItems.AMETHYST_PAXEL);

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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BetterToolsItems.WOOD_CHISEL, 1)
                .pattern("n")
                .pattern("i")
                .pattern("l")
                .define('n', Items.IRON_NUGGET)
                .define('i', Items.IRON_INGOT)
                .define('l', ItemTags.LOGS)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(recipeOutput);

        generateLumberAxeRecipe(recipeOutput, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_LUMBER_AXE);
        generateLumberAxeRecipe(recipeOutput, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_LUMBER_AXE);
        generateLumberAxeRecipe(recipeOutput, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_LUMBER_AXE);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_LUMBER_AXE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_LUMBER_AXE);
        generateLumberAxeRecipe(recipeOutput, Items.COPPER_INGOT, Items.COPPER_BLOCK, BetterToolsItems.COPPER_LUMBER_AXE);
        generateLumberAxeRecipe(recipeOutput, Items.AMETHYST_SHARD, Items.AMETHYST_BLOCK, BetterToolsItems.AMETHYST_LUMBER_AXE);

        generateMacheteRecipe(recipeOutput, Items.IRON_INGOT, BetterToolsItems.IRON_MACHETE);
        generateMacheteRecipe(recipeOutput, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_MACHETE);
        generateMacheteRecipe(recipeOutput, Items.DIAMOND, BetterToolsItems.DIAMOND_MACHETE);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_MACHETE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_MACHETE);
        generateMacheteRecipe(recipeOutput, Items.COPPER_INGOT, BetterToolsItems.COPPER_MACHETE);
        generateMacheteRecipe(recipeOutput, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_MACHETE);

        generateProspectingPickRecipe(recipeOutput, Items.IRON_INGOT, BetterToolsItems.IRON_PROSPECTING_PICK);
        generateProspectingPickRecipe(recipeOutput, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_PROSPECTING_PICK);
        generateProspectingPickRecipe(recipeOutput, Items.DIAMOND, BetterToolsItems.DIAMOND_PROSPECTING_PICK);
        netheriteSmithing(recipeOutput, BetterToolsItems.DIAMOND_PROSPECTING_PICK, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_PROSPECTING_PICK);
        generateProspectingPickRecipe(recipeOutput, Items.COPPER_INGOT, BetterToolsItems.COPPER_PROSPECTING_PICK);
        generateProspectingPickRecipe(recipeOutput, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_PROSPECTING_PICK);

        generateSwordRecipe(recipeOutput, Items.COPPER_INGOT, BetterToolsItems.COPPER_SWORD);
        generateShovelRecipe(recipeOutput, Items.COPPER_INGOT, BetterToolsItems.COPPER_SHOVEL);
        generatePickaxeRecipe(recipeOutput, Items.COPPER_INGOT, BetterToolsItems.COPPER_PICKAXE);
        generateAxeRecipe(recipeOutput, Items.COPPER_INGOT, BetterToolsItems.COPPER_AXE);
        generateHoeRecipe(recipeOutput, Items.COPPER_INGOT, BetterToolsItems.COPPER_HOE);

        generateSwordRecipe(recipeOutput, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_SWORD);
        generateShovelRecipe(recipeOutput, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_SHOVEL);
        generatePickaxeRecipe(recipeOutput, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_PICKAXE);
        generateAxeRecipe(recipeOutput, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_AXE);
        generateHoeRecipe(recipeOutput, Items.AMETHYST_SHARD, BetterToolsItems.AMETHYST_HOE);

        SpecialRecipeBuilder.special(WoodChiselingRecipe::new).save(recipeOutput, "wood_chiseling");
    }
}
