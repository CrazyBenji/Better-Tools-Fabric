package net.benji.bettertools.data;

import net.benji.bettertools.BetterToolsFabric;
import net.benji.bettertools.item.BetterToolsItems;
import net.benji.bettertools.util.BetterToolsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BetterToolsAdvancementProvider extends FabricAdvancementProvider {
    public BetterToolsAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    public AdvancementHolder getAdvancement(String id) {
        return Advancement.Builder.advancement().build(Identifier.fromNamespaceAndPath("minecraft", id));
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider provider, @NonNull Consumer<AdvancementHolder> consumer) {
        HolderGetter<Item> holderGetter = provider.lookupOrThrow(Registries.ITEM);

        AdvancementHolder getHammer = Advancement.Builder.advancement()
                .parent(getAdvancement("story/iron_tools"))
                .display(
                        BetterToolsItems.IRON_HAMMER,
                        Component.translatable("advancements.story.get_hammer.title"),
                        Component.translatable("advancements.story.get_hammer.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("hammer", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(holderGetter, BetterToolsTags.Items.HAMMERS).build()
                ))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_hammer");

        AdvancementHolder getPaxel = Advancement.Builder.advancement()
                .parent(getAdvancement("story/iron_tools"))
                .display(
                        BetterToolsItems.IRON_PAXEL,
                        Component.translatable("advancements.story.get_paxel.title"),
                        Component.translatable("advancements.story.get_paxel.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(holderGetter, BetterToolsTags.Items.PAXELS).build()
                ))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_paxel");

        AdvancementHolder getScythe = Advancement.Builder.advancement()
                .parent(getAdvancement("husbandry/plant_seed"))
                .display(
                        BetterToolsItems.IRON_SCYTHE,
                        Component.translatable("advancements.husbandry.get_scythe.title"),
                        Component.translatable("advancements.husbandry.get_scythe.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_scythe", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(holderGetter, BetterToolsTags.Items.SCYTHES).build()
                ))
                .save(consumer, BetterToolsFabric.MOD_ID + ":husbandry/get_scythe");

        AdvancementHolder getNetheriteScythe = Advancement.Builder.advancement()
                .parent(getScythe)
                .display(
                        BetterToolsItems.NETHERITE_SCYTHE,
                        Component.translatable("advancements.husbandry.get_netherite_scythe.title"),
                        Component.translatable("advancements.husbandry.get_netherite_scythe.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .rewards(
                        new AdvancementRewards.Builder().addExperience(100).build()
                )
                .addCriterion("got_netherite_scythe", InventoryChangeTrigger.TriggerInstance.hasItems(BetterToolsItems.NETHERITE_SCYTHE))
                .save(consumer, BetterToolsFabric.MOD_ID + ":husbandry/get_netherite_scythe");

        AdvancementHolder getGlassChipper = Advancement.Builder.advancement()
                .parent(getAdvancement("story/smelt_iron"))
                .display(BetterToolsItems.GLASS_CHIPPER,
                        Component.translatable("advancements.story.get_glass_chipper.title"),
                        Component.translatable("advancements.story.get_glass_chipper.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_glass_chipper", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(holderGetter, BetterToolsTags.Items.GLASS_CHIPPERS).build()
                ))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_glass_chipper");

        AdvancementHolder getBedrockSmasher = Advancement.Builder.advancement()
                .parent(getAdvancement("nether/summon_wither"))
                .display(BetterToolsItems.BEDROCK_SMASHER,
                        Component.translatable("advancements.nether.get_bedrock_smasher.title"),
                        Component.translatable("advancements.nether.get_bedrock_smasher.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .addCriterion("got_bedrock_smasher", InventoryChangeTrigger.TriggerInstance.hasItems(BetterToolsItems.BEDROCK_SMASHER))
                .save(consumer, BetterToolsFabric.MOD_ID + ":nether/get_bedrock_smasher");

        AdvancementHolder getLumberAxe = Advancement.Builder.advancement()
                .parent(getAdvancement("story/smelt_iron"))
                .display(BetterToolsItems.IRON_LUMBER_AXE,
                        Component.translatable("advancements.story.get_lumber_axe.title"),
                        Component.translatable("advancements.story.get_lumber_axe.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_lumber_axe", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(holderGetter, BetterToolsTags.Items.LUMBER_AXES).build()
                ))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_lumber_axe");

        AdvancementHolder getMachete = Advancement.Builder.advancement()
                .parent(getAdvancement("story/smelt_iron"))
                .display(BetterToolsItems.IRON_MACHETE,
                        Component.translatable("advancements.story.get_machete.title"),
                        Component.translatable("advancements.story.get_machete.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_machete", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(holderGetter, BetterToolsTags.Items.MACHETES).build()
                ))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_machete");

        AdvancementHolder getCopperTools = Advancement.Builder.advancement()
                .parent(getAdvancement("story/upgrade_tools"))
                .display(Items.COPPER_PICKAXE,
                        Component.translatable("advancements.story.get_copper_tools.title"),
                        Component.translatable("advancements.story.get_copper_tools.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_copper_tool", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(holderGetter, BetterToolsTags.Items.COPPER_TOOLS).build()
                ))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_copper_tool");

        AdvancementHolder getAmethystTool = Advancement.Builder.advancement()
                .parent(getAdvancement("story/upgrade_tools"))
                .display(BetterToolsItems.AMETHYST_PICKAXE,
                        Component.translatable("advancements.story.get_amethyst_tools.title"),
                        Component.translatable("advancements.story.get_amethyst_tools.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_amethyst_tool", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(holderGetter, BetterToolsTags.Items.AMETHYST_TOOLS).build()
                ))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_amethyst_tool");

        AdvancementHolder getWoodChisel = Advancement.Builder.advancement()
                .parent(getAdvancement("story/smelt_iron"))
                .display(BetterToolsItems.WOOD_CHISEL,
                        Component.translatable("advancements.story.get_wood_chisel.title"),
                        Component.translatable("advancements.story.get_wood_chisel.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_wood_chisel", InventoryChangeTrigger.TriggerInstance.hasItems(BetterToolsItems.WOOD_CHISEL))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_wood_chisel");
    }
}
