package net.benji.bettertools.item.crafting;

import net.benji.bettertools.BetterToolsFabric;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.*;

public class BetterToolsRecipeSerializers {
    public static final RecipeSerializer<PaxelRecipe> PAXEL_RECIPE_SERIALIZER = registerRecipeSerializer(
            "paxel",
            PaxelRecipe.SERIALIZER
    );

    public static final RecipeSerializer<WoodChiselingRecipe> WOOD_CHISELING_RECIPE_SERIALIZER = registerRecipeSerializer(
            "wood_chiseling",
            WoodChiselingRecipe.SERIALIZER
    );

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerRecipeSerializer(String key, S recipeSerializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, key), recipeSerializer);
    }

    public static void registerRecipeSerializers() {
        BetterToolsFabric.LOGGER.info("Registering recipe serializers for " + BetterToolsFabric.MOD_ID);
    }
}