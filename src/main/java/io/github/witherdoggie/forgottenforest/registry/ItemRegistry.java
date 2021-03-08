package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.item.RottenAppleItem;
import io.github.witherdoggie.forgottenforest.item.ShadowAmuletFullItem;
import io.github.witherdoggie.forgottenforest.item.ShadowAmuletHalfItem;
import io.github.witherdoggie.forgottenforest.item.SoullessSoulItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    public static final Item ORCHIUM_INGOT = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

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


    public static void initItems(){

        /* Block Items */
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_grass_block"), new BlockItem(BlockRegistry.GLOOMY_GRASS_BLOCK, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_dirt"), new BlockItem(BlockRegistry.GLOOMY_DIRT, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"orchium_ore"), new BlockItem(BlockRegistry.ORCHIUM_ORE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_bricks"), new BlockItem(BlockRegistry.GLOOMY_BRICKS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"chiseled_gloomy_bricks"), new BlockItem(BlockRegistry.CHISELED_GLOOMY_BRICKS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"cracked_gloomy_bricks"), new BlockItem(BlockRegistry.CRACKED_GLOOMY_BRICKS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_log"), new BlockItem(BlockRegistry.GLOOMY_LOG, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_planks"), new BlockItem(BlockRegistry.GLOOMY_PLANKS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_leaves"), new BlockItem(BlockRegistry.GLOOMY_LEAVES, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_sapling"), new BlockItem(BlockRegistry.GLOOMY_SAPLING, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "arkian_stone"), new BlockItem(BlockRegistry.ARKIAN_STONE, new Item.Settings().group(ModItemGroups.BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_ingot"), ORCHIUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "rotten_apple"), ROTTEN_APPLE);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "left_shadow_amulet"), LEFT_SHADOW_AMULET);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "right_shadow_amulet"), RIGHT_SHADOW_AMULET);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "full_shadow_amulet"), FULL_SHADOW_AMULET);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "soulless_soul"), SOULLESS_SOUL);

    }
}
