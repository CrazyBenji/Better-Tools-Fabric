package net.benji.bettertools.util;

import net.benji.bettertools.BetterToolsFabric;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class BetterToolsTags {
    public static class Blocks {
        public static final TagKey<@NotNull Block> PAXEL_MINEABLE = createTag("mineable/paxel");
        public static final TagKey<@NotNull Block> GLASS_CHIPPER_MINEABLE = createTag("mineable/glass_chipper");

        private static TagKey<@NotNull Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<@NotNull Item> HAMMERS = createTag("hammers");
        public static final TagKey<@NotNull Item> PAXELS = createTag("paxels");
        public static final TagKey<@NotNull Item> SCYTHES = createTag("scythes");
        public static final TagKey<@NotNull Item> GLASS_CHIPPERS = createTag("glass_chippers");
        public static final TagKey<@NotNull Item> LUMBER_AXES = createTag("lumber_axes");

        private static TagKey<@NotNull Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, name));
        }
    }
}
