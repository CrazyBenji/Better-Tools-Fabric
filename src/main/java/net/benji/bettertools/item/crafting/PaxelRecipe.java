package net.benji.bettertools.item.crafting;

import com.google.common.annotations.VisibleForTesting;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.ShapedCraftingRecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PaxelRecipe extends NormalCraftingRecipe {
    public static final MapCodec<PaxelRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(CommonInfo.MAP_CODEC.forGetter((o) -> o.commonInfo), CraftingBookInfo.MAP_CODEC.forGetter((o) -> o.bookInfo), ShapedRecipePattern.MAP_CODEC.forGetter((o) -> o.pattern), ItemStackTemplate.CODEC.fieldOf("result").forGetter((o) -> o.result)).apply(i, PaxelRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, PaxelRecipe> STREAM_CODEC = StreamCodec.composite(CommonInfo.STREAM_CODEC, (o) -> o.commonInfo, CraftingBookInfo.STREAM_CODEC, (o) -> o.bookInfo, ShapedRecipePattern.STREAM_CODEC, (o) -> o.pattern, ItemStackTemplate.STREAM_CODEC, (o) -> o.result, PaxelRecipe::new);
    public static final RecipeSerializer<PaxelRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);
    private final ShapedRecipePattern pattern;
    private final ItemStackTemplate result;

    public PaxelRecipe(final Recipe.CommonInfo commonInfo, final CraftingRecipe.CraftingBookInfo bookInfo, final ShapedRecipePattern pattern, final ItemStackTemplate result) {
        super(commonInfo, bookInfo);
        this.pattern = pattern;
        this.result = result;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingInput craftingInput) {
        ItemStack toReturn = result.create();
        EnchantmentHelper.setEnchantments(toReturn, combineEnchantments(craftingInput));
        return toReturn;
    }

    private ItemEnchantments combineEnchantments(CraftingInput craftingInput) {
        if (this.pattern.ingredients().getFirst().isPresent()) {
            ItemEnchantments.Mutable combined = this.pattern.ingredients().getFirst().get().test(craftingInput.getItem(0))
                    ? new ItemEnchantments.Mutable(EnchantmentHelper.getEnchantmentsForCrafting(craftingInput.getItem(0)))
                    : new ItemEnchantments.Mutable(EnchantmentHelper.getEnchantmentsForCrafting(craftingInput.getItem(2)));

            List<ItemEnchantments> enchantmentsToCombine = List.of(
                    EnchantmentHelper.getEnchantmentsForCrafting(craftingInput.getItem(1)),
                    this.pattern.ingredients().getFirst().get().test(craftingInput.getItem(0))
                            ? EnchantmentHelper.getEnchantmentsForCrafting(craftingInput.getItem(2))
                            : EnchantmentHelper.getEnchantmentsForCrafting(craftingInput.getItem(0))
            );

            for (ItemEnchantments itemEnchantment : enchantmentsToCombine) {
                for (Holder<Enchantment> enchantment : itemEnchantment.keySet()) {
                    Collection<Holder<Enchantment>> enchantmentCollection = combined.keySet();
                    if (EnchantmentHelper.isEnchantmentCompatible(enchantmentCollection, enchantment)) {
                        combined.upgrade(enchantment, itemEnchantment.getLevel(enchantment));
                    }
                }
            }
            return combined.toImmutable();
        }

        return null;
    }

    @VisibleForTesting
    public List<Optional<Ingredient>> getIngredients() {
        return this.pattern.ingredients();
    }

    protected @NonNull PlacementInfo createPlacementInfo() {
        return PlacementInfo.createFromOptionals(this.pattern.ingredients());
    }

    public boolean matches(final CraftingInput input, final @NonNull Level level) {
        return this.pattern.matches(input);
    }

    public int getWidth() {
        return this.pattern.width();
    }

    public int getHeight() {
        return this.pattern.height();
    }

    public @NonNull List<RecipeDisplay> display() {
        return List.of(new ShapedCraftingRecipeDisplay(this.pattern.width(), this.pattern.height(), this.pattern.ingredients().stream().map((e) -> (SlotDisplay)e.map(Ingredient::display).orElse(SlotDisplay.Empty.INSTANCE)).toList(), new SlotDisplay.ItemStackSlotDisplay(this.result), new SlotDisplay.ItemSlotDisplay(Items.CRAFTING_TABLE)));
    }

    @Override
    public @NotNull RecipeSerializer<PaxelRecipe> getSerializer() {
        return SERIALIZER;
    }
}