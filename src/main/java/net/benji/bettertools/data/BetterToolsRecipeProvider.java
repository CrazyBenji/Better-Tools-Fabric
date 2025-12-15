package net.benji.bettertools.data;

import net.benji.bettertools.item.BetterToolsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BetterToolsRecipeProvider extends FabricRecipeProvider {
    public BetterToolsRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                generateHammerRecipe(exporter, Items.COPPER_INGOT, Items.COPPER_BLOCK, BetterToolsItems.COPPER_HAMMER);
                generateHammerRecipe(exporter, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_HAMMER);
                generateHammerRecipe(exporter, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_HAMMER);
                generateHammerRecipe(exporter, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_HAMMER);
                netheriteSmithing(BetterToolsItems.DIAMOND_HAMMER, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_HAMMER);

                generatePaxelRecipe(exporter, Items.COPPER_PICKAXE, Items.COPPER_AXE, Items.COPPER_SHOVEL, BetterToolsItems.COPPER_PAXEL);
                generatePaxelRecipe(exporter, Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, BetterToolsItems.IRON_PAXEL);
                generatePaxelRecipe(exporter, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, BetterToolsItems.GOLDEN_PAXEL);
                generatePaxelRecipe(exporter, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.DIAMOND_SHOVEL, BetterToolsItems.DIAMOND_PAXEL);
                netheriteSmithing(BetterToolsItems.DIAMOND_PAXEL, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_PAXEL);

                generateScytheRecipe(exporter, Items.COPPER_INGOT, BetterToolsItems.COPPER_SCYTHE);
                generateScytheRecipe(exporter, Items.IRON_INGOT, BetterToolsItems.IRON_SCYTHE);
                generateScytheRecipe(exporter, Items.GOLD_INGOT, BetterToolsItems.GOLDEN_SCYTHE);
                generateScytheRecipe(exporter, Items.DIAMOND, BetterToolsItems.DIAMOND_SCYTHE);
                netheriteSmithing(BetterToolsItems.DIAMOND_SCYTHE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_SCYTHE);

                generateLumberAxeRecipe(exporter, Items.COPPER_INGOT, Items.COPPER_BLOCK, BetterToolsItems.COPPER_LUMBER_AXE);
                generateLumberAxeRecipe(exporter, Items.IRON_INGOT, Items.IRON_BLOCK, BetterToolsItems.IRON_LUMBER_AXE);
                generateLumberAxeRecipe(exporter, Items.GOLD_INGOT, Items.GOLD_BLOCK, BetterToolsItems.GOLDEN_LUMBER_AXE);
                generateLumberAxeRecipe(exporter, Items.DIAMOND, Items.DIAMOND_BLOCK, BetterToolsItems.DIAMOND_LUMBER_AXE);
                netheriteSmithing(BetterToolsItems.DIAMOND_LUMBER_AXE, RecipeCategory.TOOLS, BetterToolsItems.NETHERITE_LUMBER_AXE);

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
            }

            public void generatePaxelRecipe(RecipeOutput writer, Item pickaxe, Item axe, Item shovel, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("abc")
                        .pattern(" s ")
                        .pattern(" s ")
                        .define('a', pickaxe)
                        .define('b', axe)
                        .define('c', shovel)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(pickaxe), has(pickaxe))
                        .save(writer);
            }
            public void generateHammerRecipe(RecipeOutput writer, Item ingot, Item block, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("mbm")
                        .pattern("msm")
                        .pattern(" s ")
                        .define('m', ingot)
                        .define('b', block)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(writer);
            }
            public void generateScytheRecipe(RecipeOutput writer, Item ingot, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("mmm")
                        .pattern(" sm")
                        .pattern(" s ")
                        .define('m', ingot)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(writer);
            }

            public void generateLumberAxeRecipe(RecipeOutput writer, Item ingot, Item block, Item output) {
                shaped(RecipeCategory.TOOLS, output, 1)
                        .pattern("ib")
                        .pattern("is")
                        .pattern(" s")
                        .define('i', ingot)
                        .define('b', block)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(ingot), has(ingot))
                        .save(writer);
            }
        };
    }

    @Override
    public @NotNull String getName() {
        return "BetterToolsRecipeProvider";
    }
}
