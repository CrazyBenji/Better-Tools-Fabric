package net.benji.bettertools.data;

import net.benji.bettertools.block.BetterToolsBlocks;
import net.benji.bettertools.item.BetterToolsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BetterToolsLootTableProvider extends FabricBlockLootSubProvider {
    public final LootItemCondition.Builder HAS_GLASS_CHIPPER_OR_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().of(this.registries.lookupOrThrow(Registries.ITEM), BetterToolsItems.GLASS_CHIPPER))
            .or(this.hasSilkTouch());

    public static final List<Block> GLASS_BLOCKS = List.of(
            Blocks.GLASS,
            Blocks.STAINED_GLASS.white(),
            Blocks.STAINED_GLASS.lightGray(),
            Blocks.STAINED_GLASS.gray(),
            Blocks.STAINED_GLASS.black(),
            Blocks.STAINED_GLASS.brown(),
            Blocks.STAINED_GLASS.red(),
            Blocks.STAINED_GLASS.orange(),
            Blocks.STAINED_GLASS.yellow(),
            Blocks.STAINED_GLASS.lime(),
            Blocks.STAINED_GLASS.green(),
            Blocks.STAINED_GLASS.cyan(),
            Blocks.STAINED_GLASS.lightBlue(),
            Blocks.STAINED_GLASS.blue(),
            Blocks.STAINED_GLASS.purple(),
            Blocks.STAINED_GLASS.magenta(),
            Blocks.STAINED_GLASS.pink(),
            Blocks.GLASS_PANE,
            Blocks.STAINED_GLASS_PANE.white(),
            Blocks.STAINED_GLASS_PANE.lightGray(),
            Blocks.STAINED_GLASS_PANE.gray(),
            Blocks.STAINED_GLASS_PANE.black(),
            Blocks.STAINED_GLASS_PANE.brown(),
            Blocks.STAINED_GLASS_PANE.red(),
            Blocks.STAINED_GLASS_PANE.orange(),
            Blocks.STAINED_GLASS_PANE.yellow(),
            Blocks.STAINED_GLASS_PANE.lime(),
            Blocks.STAINED_GLASS_PANE.green(),
            Blocks.STAINED_GLASS_PANE.cyan(),
            Blocks.STAINED_GLASS_PANE.lightBlue(),
            Blocks.STAINED_GLASS_PANE.blue(),
            Blocks.STAINED_GLASS_PANE.purple(),
            Blocks.STAINED_GLASS_PANE.magenta(),
            Blocks.STAINED_GLASS_PANE.pink()
    );

    public BetterToolsLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        for (Block b : GLASS_BLOCKS) {
            this.dropWhenGlassChipper(b);
        }

        this.add(Blocks.GLOWSTONE,
                block -> createSelfDropDispatchTable(
                        block,
                        HAS_GLASS_CHIPPER_OR_SILK_TOUCH,
                        this.applyExplosionCondition(
                                block,
                                LootItem.lootTableItem(Items.GLOWSTONE_DUST)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))
                                        .apply(LimitCount.limitCount(IntRange.range(1, 4)))
                        )
                )
        );
        this.add(Blocks.SEA_LANTERN,
                block -> createSelfDropDispatchTable(
                        block,
                        HAS_GLASS_CHIPPER_OR_SILK_TOUCH,
                        this.applyExplosionDecay(
                                block,
                                LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))
                                        .apply(LimitCount.limitCount(IntRange.range(1, 5)))
                        )
                )
        );

        this.dropSelf(BetterToolsBlocks.SMASHED_BEDROCK);
    }

    public void dropWhenGlassChipper(Block block) {
        this.add(block, LootTable.lootTable().withPool(LootPool.lootPool().when(HAS_GLASS_CHIPPER_OR_SILK_TOUCH).setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block))));
    }
}
