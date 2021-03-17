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


    public static void initItems() {

        /* Block Items */
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_grass_block"), new BlockItem(BlockRegistry.GLOOMY_GRASS_BLOCK, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_dirt"), new BlockItem(BlockRegistry.GLOOMY_DIRT, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_ore"), new BlockItem(BlockRegistry.ORCHIUM_ORE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_bricks"), new BlockItem(BlockRegistry.GLOOMY_BRICKS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "chiseled_gloomy_bricks"), new BlockItem(BlockRegistry.CHISELED_GLOOMY_BRICKS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "cracked_gloomy_bricks"), new BlockItem(BlockRegistry.CRACKED_GLOOMY_BRICKS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_log"), new BlockItem(BlockRegistry.GLOOMY_LOG, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_planks"), new BlockItem(BlockRegistry.GLOOMY_PLANKS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_leaves"), new BlockItem(BlockRegistry.GLOOMY_LEAVES, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_sapling"), new BlockItem(BlockRegistry.GLOOMY_SAPLING, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "arkian_stone"), new BlockItem(BlockRegistry.ARKIAN_STONE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_stone"), new BlockItem(BlockRegistry.GLOOMY_STONE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_grass"), new BlockItem(BlockRegistry.GLOOMY_GRASS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_plank_stairs"), new BlockItem(BlockRegistry.GLOOMY_PLANK_STAIRS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_plank_slab"), new BlockItem(BlockRegistry.GLOOMY_PLANK_SLAB, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_bricks_slab"), new BlockItem(BlockRegistry.GLOOMY_BRICKS_SLAB, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_bricks_stairs"), new BlockItem(BlockRegistry.GLOOMY_BRICKS_STAIRS, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "fire_grass_block"), new BlockItem(BlockRegistry.FIRE_GRASS_BLOCK, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "fire_dirt"), new BlockItem(BlockRegistry.FIRE_DIRT, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "fire_stone"), new BlockItem(BlockRegistry.FIRE_STONE, new Item.Settings().group(ModItemGroups.BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "mod_iron_ore"), new BlockItem(BlockRegistry.FF_IRON_ORE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "mod_gold_ore"), new BlockItem(BlockRegistry.FF_GOLD_ORE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "mod_coal_ore"), new BlockItem(BlockRegistry.FF_COAL_ORE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "mod_diamond_ore"), new BlockItem(BlockRegistry.FF_DIAMOND_ORE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "mod_lapis_ore"), new BlockItem(BlockRegistry.FF_LAPIS_ORE, new Item.Settings().group(ModItemGroups.BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "mod_redstone_ore"), new BlockItem(BlockRegistry.FF_REDSTONE_ORE, new Item.Settings().group(ModItemGroups.BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_ingot"), ORCHIUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "rotten_apple"), ROTTEN_APPLE);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "left_shadow_amulet"), LEFT_SHADOW_AMULET);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "right_shadow_amulet"), RIGHT_SHADOW_AMULET);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "full_shadow_amulet"), FULL_SHADOW_AMULET);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "soulless_soul"), SOULLESS_SOUL);

        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "soul_skeleton_spawn_egg"), SOUL_SKELETON_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "soul_spider_spawn_egg"), SOUL_SPIDER_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "soul_chicken_spawn_egg"), SOUL_CHICKEN_SPAWN_EGG);

        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_pickaxe"), ORCHIUM_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_axe"), ORCHIUM_AXE);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_hoe"), ORCHIUM_HOE);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_sword"), ORCHIUM_SWORD);
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "orchium_shovel"), ORCHIUM_SHOVEL);
    }
}
