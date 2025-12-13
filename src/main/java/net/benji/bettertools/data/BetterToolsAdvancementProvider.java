package net.benji.bettertools.data;

import net.benji.bettertools.BetterToolsFabric;
import net.benji.bettertools.item.BetterToolsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BetterToolsAdvancementProvider extends FabricAdvancementProvider {
    public BetterToolsAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    public AdvancementHolder getAdvancement(String id) {
        return Advancement.Builder.advancement().build(new ResourceLocation("minecraft", id));
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
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
                .addCriterion("hammer", InventoryChangeTrigger.TriggerInstance.hasItems(BetterToolsItems.IRON_HAMMER))
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
                .addCriterion("got_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(BetterToolsItems.IRON_PAXEL))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_paxel");

        AdvancementHolder getScythe = Advancement.Builder.advancement()
                .parent(getAdvancement("story/iron_tools"))
                .display(
                        BetterToolsItems.IRON_SCYTHE,
                        Component.translatable("advancements.story.get_scythe.title"),
                        Component.translatable("advancements.story.get_scythe.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_scythe", InventoryChangeTrigger.TriggerInstance.hasItems(BetterToolsItems.IRON_SCYTHE))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_scythe");

        AdvancementHolder getNetheriteScythe = Advancement.Builder.advancement()
                .parent(getAdvancement("husbandry/obtain_netherite_hoe"))
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
                .parent(getAdvancement("story/iron_tools"))
                .display(BetterToolsItems.GLASS_CHIPPER,
                        Component.translatable("advancements.story.get_glass_chipper.title"),
                        Component.translatable("advancements.story.get_glass_chipper.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_glass_chipper", InventoryChangeTrigger.TriggerInstance.hasItems(BetterToolsItems.GLASS_CHIPPER))
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
                .parent(getAdvancement("story/iron_tools"))
                .display(BetterToolsItems.IRON_LUMBER_AXE,
                        Component.translatable("advancements.story.get_lumber_axe.title"),
                        Component.translatable("advancements.story.get_lumber_axe.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("got_lumber_axe", InventoryChangeTrigger.TriggerInstance.hasItems(BetterToolsItems.IRON_LUMBER_AXE))
                .save(consumer, BetterToolsFabric.MOD_ID + ":story/get_lumber_axe");

    }
}
