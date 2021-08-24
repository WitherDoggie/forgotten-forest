package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.item.*;
import io.github.witherdoggie.forgottenforest.item.materials.armor.FireiteArmorMaterial;
import io.github.witherdoggie.forgottenforest.item.materials.armor.OrchiumArmorMaterial;
import io.github.witherdoggie.forgottenforest.item.materials.tool.FireiteToolMaterial;
import io.github.witherdoggie.forgottenforest.item.materials.tool.OrchiumToolMaterial;
import io.github.witherdoggie.forgottenforest.item.tools.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static final Item TRANSMUTATION_WAND = new TransmutationWandItem(new FabricItemSettings().group(ModItemGroups.ITEMS).maxCount(1).maxDamage(100));
    public static final Item ORCHIUM_INGOT = new Item(new FabricItemSettings().group(ModItemGroups.ITEMS));
    public static final Item FIREITE_GEM = new Item(new FabricItemSettings().group(ModItemGroups.ITEMS));

    public static ToolItem ORCHIUM_PICKAXE = new ModPickaxeItem(OrchiumToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(ModItemGroups.ITEMS));
    public static ToolItem ORCHIUM_AXE = new ModAxeItem(OrchiumToolMaterial.INSTANCE, 5.0F, -3.2F, new Item.Settings().group(ModItemGroups.ITEMS));
    public static ToolItem ORCHIUM_HOE = new ModHoeItem(OrchiumToolMaterial.INSTANCE, -3, -3.2F, new Item.Settings().group(ModItemGroups.ITEMS));
    public static ToolItem ORCHIUM_SWORD = new ModSwordItem(OrchiumToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings().group(ModItemGroups.ITEMS));
    public static ToolItem ORCHIUM_SHOVEL = new ModShovelItem(OrchiumToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(ModItemGroups.ITEMS));

    public static final Item ORCHIUM_HELMET = new ArmorItem(OrchiumArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item ORCHIUM_CHESTPLATE = new ArmorItem(OrchiumArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item ORCHIUM_LEGGINGS = new ArmorItem(OrchiumArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item ORCHIUM_BOOTS = new ArmorItem(OrchiumArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ITEMS));

    public static final Item FIREITE_HELMET = new ArmorItem(FireiteArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item FIREITE_CHESTPLATE = new ArmorItem(FireiteArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item FIREITE_LEGGINGS = new ArmorItem(FireiteArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item FIREITE_BOOTS = new ArmorItem(FireiteArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ITEMS));

    public static ToolItem FIREITE_PICKAXE = new ModPickaxeItem(FireiteToolMaterial.INSTANCE, 2, -2.8F, new Item.Settings().group(ModItemGroups.ITEMS));
    public static ToolItem FIREITE_AXE = new ModAxeItem(FireiteToolMaterial.INSTANCE, 6.0F, -3.2F, new Item.Settings().group(ModItemGroups.ITEMS));
    public static ToolItem FIREITE_HOE = new ModHoeItem(FireiteToolMaterial.INSTANCE, -4, -3.2F, new Item.Settings().group(ModItemGroups.ITEMS));
    public static ToolItem FIREITE_SWORD = new ModSwordItem(FireiteToolMaterial.INSTANCE, 4, -2.4F, new Item.Settings().group(ModItemGroups.ITEMS));
    public static ToolItem FIREITE_SHOVEL = new ModShovelItem(FireiteToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(ModItemGroups.ITEMS));

    public static final Item ROTTEN_APPLE = new RottenAppleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 50, 0), 1.0F)
            .build()).group(ModItemGroups.ITEMS));

    public static final Item SOULLESS_SOUL = new SoullessSoulItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 160, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 1), 1.0F)
            .build()).group(ModItemGroups.ITEMS));

    public static final Item FIRE_PORKCHOP = new FirePorkChopItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(10).saturationModifier(0.8F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 0), 1.0F)
            .build()).group(ModItemGroups.ITEMS));

    public static final Item LEFT_SHADOW_AMULET = new ShadowAmuletHalfItem(new FabricItemSettings().group(ModItemGroups.ITEMS));
    public static final Item RIGHT_SHADOW_AMULET = new ShadowAmuletHalfItem(new FabricItemSettings().group(ModItemGroups.ITEMS));
    public static final Item FULL_SHADOW_AMULET = new ShadowAmuletFullItem(new FabricItemSettings().group(ModItemGroups.ITEMS));

    public static final Item SOUL_SKELETON_SPAWN_EGG = new SpawnEggItem(EntityRegistry.SOUL_SKELETON, 0x0c3ff, 0xFFFFFF, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item SOUL_SPIDER_SPAWN_EGG = new SpawnEggItem(EntityRegistry.SOUL_SPIDER, 0xe3e3e3, 0xFFFFFF, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item SOUL_CHICKEN_SPAWN_EGG = new SpawnEggItem(EntityRegistry.SOUL_CHICKEN, 0xffb8b8, 0xFFFFFF, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item GHOST_SPAWN_EGG = new SpawnEggItem(EntityRegistry.GHOST, 0x403e3e, 0x808080, new Item.Settings().group(ModItemGroups.ITEMS));
    public static final Item FIRE_PIG_SPAWN_EGG = new SpawnEggItem(EntityRegistry.FIRE_PIG, 0xfa732f, 0xfc0000, new Item.Settings().group(ModItemGroups.ITEMS));

    public static final Item EGG_OF_LIFE_ITEM = new EggOfLifeItem(new FabricItemSettings().group(ModItemGroups.ITEMS).maxCount(16));

    public static Item POISON_WATER_BUCKET;

    public static void initItems() {

        register("orchium_ingot", ORCHIUM_INGOT);
        register("rotten_apple", ROTTEN_APPLE);
        register("left_shadow_amulet", LEFT_SHADOW_AMULET);
        register("right_shadow_amulet", RIGHT_SHADOW_AMULET);
        register("full_shadow_amulet", FULL_SHADOW_AMULET);
        register("soulless_soul", SOULLESS_SOUL);
        register("soul_skeleton_spawn_egg", SOUL_SKELETON_SPAWN_EGG);
        register("soul_spider_spawn_egg", SOUL_SPIDER_SPAWN_EGG);
        register("soul_chicken_spawn_egg", SOUL_CHICKEN_SPAWN_EGG);
        register("fire_pig_spawn_egg", FIRE_PIG_SPAWN_EGG);
        register("ghost_spawn_egg", GHOST_SPAWN_EGG);
        register("orchium_pickaxe", ORCHIUM_PICKAXE);
        register("orchium_axe", ORCHIUM_AXE);
        register("orchium_hoe", ORCHIUM_HOE);
        register("orchium_sword", ORCHIUM_SWORD);
        register("orchium_shovel", ORCHIUM_SHOVEL);
        register("fire_porkchop", FIRE_PORKCHOP);
        register("fireite_gem", FIREITE_GEM);

        register("fireite_pickaxe", FIREITE_PICKAXE);
        register("fireite_axe", FIREITE_AXE);
        register("fireite_hoe", FIREITE_HOE);
        register("fireite_sword", FIREITE_SWORD);
        register("fireite_shovel", FIREITE_SHOVEL);

        register("orchium_helmet", ORCHIUM_HELMET);
        register("orchium_chestplate", ORCHIUM_CHESTPLATE);
        register("orchium_leggings", ORCHIUM_LEGGINGS);
        register("orchium_boots", ORCHIUM_BOOTS);

        register("fireite_helmet", FIREITE_HELMET);
        register("fireite_chestplate", FIREITE_CHESTPLATE);
        register("fireite_leggings", FIREITE_LEGGINGS);
        register("fireite_boots", FIREITE_BOOTS);

        register("egg_of_life_item", EGG_OF_LIFE_ITEM);
        register("transmutation_wand", TRANSMUTATION_WAND);

        POISON_WATER_BUCKET = Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "poison_water_bucket"), new BucketItem(BlockRegistry.STILL_POISON_WATER, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(Registry.ITEM, ForgottenForest.id(id), item);
    }
}
