package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.item.RottenAppleItem;
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
    public static final Item  ROTTEN_APPLE = new RottenAppleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 50, 0), 1.0F)
            .build()).group(ItemGroup.FOOD));


    public static void initItems(){

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

    }
}
