package net.benji.bettertools.item.crafting;

import net.benji.bettertools.BetterToolsFabric;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class BetterToolsRecipeSerializers {
    public static final RecipeSerializer<PaxelRecipe> PAXEL_RECIPE_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER,
            ResourceLocation.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, "paxel"),
            new PaxelRecipe.PaxelRecipeSerializer()
    );

    public static void registerRecipeSerializers() {
        BetterToolsFabric.LOGGER.info("Registering recipe serializers for " + BetterToolsFabric.MOD_ID);
    }
}