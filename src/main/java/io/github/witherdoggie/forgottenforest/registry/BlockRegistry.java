package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.block.GloomyGrassBlock;
import io.github.witherdoggie.forgottenforest.block.ModSaplingBlock;
import io.github.witherdoggie.forgottenforest.block.OrchiumOreBlock;
import io.github.witherdoggie.forgottenforest.generator.GloomySaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    public static final Block GLOOMY_GRASS_BLOCK = new GloomyGrassBlock(AbstractBlock.Settings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block GLOOMY_DIRT = new Block(AbstractBlock.Settings.of(Material.SOIL, MaterialColor.DIRT).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final OrchiumOreBlock ORCHIUM_ORE = new OrchiumOreBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).sounds(BlockSoundGroup.STONE).requiresTool().strength(3.0f, 3.0f).breakByTool(FabricToolTags.PICKAXES, 3));
    public static final Block GLOOMY_BRICKS = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block CHISELED_GLOOMY_BRICKS = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block CRACKED_GLOOMY_BRICKS = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block GLOOMY_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block GLOOMY_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.ORANGE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block GLOOMY_LEAVES = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static final Block GLOOMY_SAPLING = new ModSaplingBlock(new GloomySaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static void initBlocks(){

        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_grass_block"), GLOOMY_GRASS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_dirt"), GLOOMY_DIRT);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "orchium_ore"), ORCHIUM_ORE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_bricks"), GLOOMY_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "chiseled_gloomy_bricks"), CHISELED_GLOOMY_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "cracked_gloomy_bricks"), CRACKED_GLOOMY_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_log"), GLOOMY_LOG);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_planks"), GLOOMY_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_leaves"), GLOOMY_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_sapling"), GLOOMY_SAPLING);


        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_grass_block"), new BlockItem(GLOOMY_GRASS_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_dirt"), new BlockItem(GLOOMY_DIRT, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"orchium_ore"), new BlockItem(ORCHIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_bricks"), new BlockItem(GLOOMY_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"chiseled_gloomy_bricks"), new BlockItem(CHISELED_GLOOMY_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"cracked_gloomy_bricks"), new BlockItem(CRACKED_GLOOMY_BRICKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_log"), new BlockItem(GLOOMY_LOG, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_planks"), new BlockItem(GLOOMY_PLANKS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_leaves"), new BlockItem(GLOOMY_LEAVES, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID, "gloomy_sapling"), new BlockItem(GLOOMY_SAPLING, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
