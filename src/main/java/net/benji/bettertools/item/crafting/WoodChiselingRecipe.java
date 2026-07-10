package net.benji.bettertools.item.crafting;

import net.benji.bettertools.item.BetterToolsItems;
import net.benji.bettertools.mixin.AxeItemAccessor;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Optional;

public class WoodChiselingRecipe extends CustomRecipe {
    public WoodChiselingRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingInput recipeInput, Level level) {
        boolean chisel = false;
        boolean log = false;

        for (int i = 0; i < recipeInput.size(); i++) {
            ItemStack itemStack = recipeInput.getItem(i);
            if (!itemStack.isEmpty()) {
                if (itemStack.is(BetterToolsItems.WOOD_CHISEL.asItem()) && !chisel) {
                    chisel = true;
                }
                else if (itemStack.getItem() instanceof BlockItem blockItem) {
                    Map<Block, Block> strippables = AxeItemAccessor.getStrippables();
                    Optional<Block> logBlock = Optional.ofNullable(strippables.get(blockItem.getBlock()));
                    if (logBlock.isPresent()) {
                        log = true;
                    }
                }
            }
        }

        return chisel && log;
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput recipeInput, HolderLookup.Provider provider) {
        ItemStack result = new ItemStack(Items.STRIPPED_OAK_LOG);

        for (int i = 0; i < recipeInput.size(); i++) {
            ItemStack input = recipeInput.getItem(i);
            if (!input.isEmpty()) {
                if (input.getItem() instanceof BlockItem blockItem) {
                    Map<Block, Block> strippables = AxeItemAccessor.getStrippables();
                    Optional<Block> logBlock = Optional.ofNullable(strippables.get(blockItem.getBlock()));
                    if (logBlock.isPresent()) {
                        result = new ItemStack(logBlock.get());
                    }
                }
            }
        }

        return result;
    }

    @Override
    public @NotNull RecipeSerializer<WoodChiselingRecipe> getSerializer() {
        return BetterToolsRecipeSerializers.WOOD_CHISELING_RECIPE_SERIALIZER;
    }
}
