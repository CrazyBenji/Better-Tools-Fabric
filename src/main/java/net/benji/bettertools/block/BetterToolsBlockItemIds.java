package net.benji.bettertools.block;

import net.benji.bettertools.BetterToolsFabric;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class BetterToolsBlockItemIds {
    public static final BlockItemId SMASHED_BEDROCK = create("smashed_bedrock");

    public static BlockItemId create(String key) {
        return BlockItemId.create(
                Identifier.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, key),
                Identifier.fromNamespaceAndPath(BetterToolsFabric.MOD_ID, key)
        );
    }
}