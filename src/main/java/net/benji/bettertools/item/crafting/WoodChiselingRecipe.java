package net.benji.bettertools.item.crafting;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.benji.bettertools.item.BetterToolsItems;
import net.benji.bettertools.mixin.AxeItemAccessor;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Map;
import java.util.Optional;

public class WoodChiselingRecipe extends CustomRecipe {
    public static final MapCodec<WoodChiselingRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(
            i -> i.group(
                    Ingredient.CODEC.fieldOf("chisel").forGetter(o -> o.chisel),
                    Ingredient.CODEC.fieldOf("log").forGetter(o -> o.log)
            )
                    .apply(i, WoodChiselingRecipe::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, WoodChiselingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC,
            o -> o.chisel,
            Ingredient.CONTENTS_STREAM_CODEC,
            o -> o.log,
            WoodChiselingRecipe::new
    );
    public static final RecipeSerializer<WoodChiselingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    private final Ingredient chisel;
    private final Ingredient log;

    public WoodChiselingRecipe(Ingredient chisel, Ingredient log) {
        this.chisel = chisel;
        this.log = log;
    }

    @Override
    public boolean matches(CraftingInput recipeInput, @NonNull Level level) {
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
    public @NotNull ItemStack assemble(CraftingInput recipeInput) {
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
        return SERIALIZER;
    }
}
