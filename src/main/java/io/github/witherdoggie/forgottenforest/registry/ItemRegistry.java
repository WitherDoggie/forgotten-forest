package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.item.RottenAppleItem;
import io.github.witherdoggie.forgottenforest.item.ShadowAmuletFullItem;
import io.github.witherdoggie.forgottenforest.item.ShadowAmuletHalfItem;
import io.github.witherdoggie.forgottenforest.item.SoullessSoulItem;
import io.github.witherdoggie.forgottenforest.item.materials.OrchiumToolMaterial;
import io.github.witherdoggie.forgottenforest.item.tools.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static final Item ORCHIUM_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));


    public static ToolItem ORCHIUM_PICKAXE = new ModPickaxeItem(OrchiumToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem ORCHIUM_AXE = new ModAxeItem(OrchiumToolMaterial.INSTANCE, 7.0F, -3.2F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem ORCHIUM_HOE = new ModHoeItem(OrchiumToolMaterial.INSTANCE, 7, -3.2F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem ORCHIUM_SWORD = new ModSwordItem(OrchiumToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem ORCHIUM_SHOVEL = new ModShovelItem(OrchiumToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));

    public static final Item ROTTEN_APPLE = new RottenAppleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 50, 0), 1.0F)
            .build()).group(ItemGroup.FOOD));

    public static final Item SOULLESS_SOUL = new SoullessSoulItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 160, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 1), 1.0F)
            .build()).group(ItemGroup.FOOD));

    public static final Item LEFT_SHADOW_AMULET = new ShadowAmuletHalfItem(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item RIGHT_SHADOW_AMULET = new ShadowAmuletHalfItem(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final Item FULL_SHADOW_AMULET = new ShadowAmuletFullItem(new FabricItemSettings().group(ItemGroup.MATERIALS));

    public static final Item SOUL_SKELETON_SPAWN_EGG = new SpawnEggItem(EntityRegistry.SOUL_SKELETON, 0x0c3ff, 0xFFFFFF, new Item.Settings().group(ItemGroup.MISC));
    public static final Item SOUL_SPIDER_SPAWN_EGG = new SpawnEggItem(EntityRegistry.SOUL_SPIDER, 0xe3e3e3, 0xFFFFFF, new Item.Settings().group(ItemGroup.MISC));
    public static final Item SOUL_CHICKEN_SPAWN_EGG = new SpawnEggItem(EntityRegistry.SOUL_CHICKEN, 0xffb8b8, 0xFFFFFF, new Item.Settings().group(ItemGroup.MISC));

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
        register("orchium_pickaxe", ORCHIUM_PICKAXE);
        register("orchium_axe", ORCHIUM_AXE);
        register("orchium_hoe", ORCHIUM_HOE);
        register("orchium_sword", ORCHIUM_SWORD);
        register("orchium_shovel", ORCHIUM_SHOVEL);

        POISON_WATER_BUCKET = Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "poison_water_bucket"), new BucketItem(BlockRegistry.STILL_POISON_WATER, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(Registry.ITEM, ForgottenForest.id(id), item);
    }
}
