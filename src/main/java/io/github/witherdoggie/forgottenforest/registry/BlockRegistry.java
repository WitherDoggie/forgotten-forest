package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.block.GloomyGrassBlock;
import io.github.witherdoggie.forgottenforest.block.OrchiumOreBlock;
import io.github.witherdoggie.forgottenforest.block.ShadowGrassBlock;
import io.github.witherdoggie.forgottenforest.block.base.FireGrassBlock;
import io.github.witherdoggie.forgottenforest.block.base.ModFernBlock;
import io.github.witherdoggie.forgottenforest.block.base.ModSaplingBlock;
import io.github.witherdoggie.forgottenforest.block.base.ModStairsBlock;
import io.github.witherdoggie.forgottenforest.block.fluid.PoisonWaterFluid;
import io.github.witherdoggie.forgottenforest.generator.GloomySaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    //Ores
    public static final OrchiumOreBlock ORCHIUM_ORE = new OrchiumOreBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).sounds(BlockSoundGroup.STONE).requiresTool().strength(3.0f, 3.0f).breakByTool(FabricToolTags.PICKAXES, 3));
    public static final Block FF_IRON_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    public static final Block FF_GOLD_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    public static final Block FF_COAL_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    public static final Block FF_LAPIS_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    public static final Block FF_DIAMOND_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));
    public static final Block FF_REDSTONE_ORE = new RedstoneOreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F));

    //Gloomy Blocks
    public static final Block GLOOMY_GRASS_BLOCK = new GloomyGrassBlock(AbstractBlock.Settings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block GLOOMY_DIRT = new Block(AbstractBlock.Settings.of(Material.SOIL, MaterialColor.DIRT).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block GLOOMY_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block CHISELED_GLOOMY_BRICKS = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block CRACKED_GLOOMY_BRICKS = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block GLOOMY_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block GLOOMY_BRICKS_STAIRS = new ModStairsBlock(GLOOMY_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(GLOOMY_BRICKS));
    public static final Block GLOOMY_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block GLOOMY_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.ORANGE).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block GLOOMY_PLANK_SLAB = new SlabBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block GLOOMY_PLANK_STAIRS = new ModStairsBlock(GLOOMY_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(GLOOMY_PLANKS));
    public static final Block GLOOMY_LEAVES = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static final Block GLOOMY_SAPLING = new ModSaplingBlock(new GloomySaplingGenerator(), FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block GLOOMY_STONE = new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block GLOOMY_GRASS = new ModFernBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));

    //Shadow Blocks
    public static final Block SHADOW_STONE = new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block SHADOW_DIRT = new Block(AbstractBlock.Settings.of(Material.SOIL, MaterialColor.DIRT).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block SHADOW_GRASS_BLOCK = new ShadowGrassBlock(AbstractBlock.Settings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));

    //Fire Blocks
    public static final Block FIRE_STONE = new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).requiresTool().strength(1.5F, 6.0F));
    public static final Block FIRE_DIRT = new Block(AbstractBlock.Settings.of(Material.SOIL, MaterialColor.DIRT).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block FIRE_GRASS_BLOCK = new FireGrassBlock(AbstractBlock.Settings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block FIRE_GRASS = new ModFernBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));

    //Arkian Blocks
    public static Block ARKIAN_STONE = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F));

    //Fluids
    public static Block POISON_WATER;
    public static FlowableFluid STILL_POISON_WATER;
    public static FlowableFluid FLOWING_POISON_WATER;

    public static final Tag<Fluid> POISON_WATER_TAG = TagRegistry.fluid(new Identifier(ForgottenForest.MODID, "poison_water"));

    public static void initBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_grass_block"), GLOOMY_GRASS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_dirt"), GLOOMY_DIRT);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_bricks"), GLOOMY_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "chiseled_gloomy_bricks"), CHISELED_GLOOMY_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "cracked_gloomy_bricks"), CRACKED_GLOOMY_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_log"), GLOOMY_LOG);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_planks"), GLOOMY_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_leaves"), GLOOMY_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_sapling"), GLOOMY_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "arkian_stone"), ARKIAN_STONE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_stone"), GLOOMY_STONE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_grass"), GLOOMY_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_plank_slab"), GLOOMY_PLANK_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_plank_stairs"), GLOOMY_PLANK_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_bricks_slab"), GLOOMY_BRICKS_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "gloomy_bricks_stairs"), GLOOMY_BRICKS_STAIRS);

        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "fire_grass_block"), FIRE_GRASS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "fire_dirt"), FIRE_DIRT);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "fire_stone"), FIRE_STONE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "fire_grass"), FIRE_GRASS);

        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "mod_iron_ore"), FF_IRON_ORE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "mod_gold_ore"), FF_GOLD_ORE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "mod_coal_ore"), FF_COAL_ORE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "mod_lapis_ore"), FF_LAPIS_ORE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "mod_diamond_ore"), FF_DIAMOND_ORE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "mod_redstone_ore"), FF_REDSTONE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "orchium_ore"), ORCHIUM_ORE);

        STILL_POISON_WATER = Registry.register(Registry.FLUID, new Identifier(ForgottenForest.MODID, "poison_water"), new PoisonWaterFluid.Still());
        FLOWING_POISON_WATER = Registry.register(Registry.FLUID, new Identifier(ForgottenForest.MODID, "flowing_poison_water"), new PoisonWaterFluid.Flowing());
        POISON_WATER = Registry.register(Registry.BLOCK, new Identifier(ForgottenForest.MODID, "poison_water"), new FluidBlock(STILL_POISON_WATER, FabricBlockSettings.copy(Blocks.WATER)){});

    }
}
