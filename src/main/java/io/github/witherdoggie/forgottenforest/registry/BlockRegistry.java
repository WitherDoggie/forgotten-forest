package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.block.GloomyGrassBlock;
import io.github.witherdoggie.forgottenforest.block.OrchiumOreBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    public static final Block GLOOMY_GRASS_BLOCK = new GloomyGrassBlock(AbstractBlock.Settings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block GLOOMY_DIRT = new Block(AbstractBlock.Settings.of(Material.SOIL, MaterialColor.DIRT).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final OrchiumOreBlock ORCHIUM_ORE = new OrchiumOreBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).sounds(BlockSoundGroup.STONE)
            .requiresTool().strength(3.0f, 3.0f).breakByTool(FabricToolTags.PICKAXES, 3));

    public static void initBlocks(){

        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_grass_block"), GLOOMY_GRASS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_dirt"), GLOOMY_DIRT);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "orchium_ore"), ORCHIUM_ORE);

        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_grass_block"), new BlockItem(GLOOMY_GRASS_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"gloomy_dirt"), new BlockItem(GLOOMY_DIRT, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ForgottenForest.MODID,"orchium_ore"), new BlockItem(ORCHIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
