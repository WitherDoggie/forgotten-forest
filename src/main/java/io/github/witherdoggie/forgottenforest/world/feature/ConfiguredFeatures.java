package io.github.witherdoggie.forgottenforest.world.feature;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountNoiseDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ConfiguredFeatures {

    public static ConfiguredFeature<?, ?> GLOOMY_TREE;
    public static ConfiguredFeature<?, ?> GLOOMY_GRASS = Feature.RANDOM_PATCH.configure(Configs.GLOOMY_GRASS_CONFIG).decorate(net.minecraft.world.gen.feature.ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(2);
    public static ConfiguredFeature<?, ?> FIRE_GRASS = Feature.RANDOM_PATCH.configure(Configs.FIRE_GRASS_CONFIG).decorate(net.minecraft.world.gen.feature.ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE)
            .decorate(Decorator.COUNT_NOISE.configure(new CountNoiseDecoratorConfig(-0.8D, 5, 10)));

    public static ConfiguredFeature<?, ?> ORCHIUM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.ORCHIUM_ORE.getDefaultState(),
                        8)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(16)))).spreadHorizontally().repeat(3);

    public static ConfiguredFeature<?, ?> FF_IRON_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.FF_IRON_ORE.getDefaultState(),
            9)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))).spreadHorizontally().repeat(20);

    public static ConfiguredFeature<?, ?> FF_GOLD_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.FF_GOLD_ORE.getDefaultState(),
            9)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(32)))).spreadHorizontally().repeat(2);

    public static ConfiguredFeature<?, ?> FF_COAL_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.FF_COAL_ORE.getDefaultState(),
            17)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(128)))).spreadHorizontally().repeat(20);

    public static ConfiguredFeature<?, ?> FF_LAPIS_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.FF_LAPIS_ORE.getDefaultState(),
            9)).triangleRange(YOffset.aboveBottom(0), YOffset.fixed(32)).spreadHorizontally();

    public static ConfiguredFeature<?, ?> FF_DIAMOND_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.FF_DIAMOND_ORE.getDefaultState(),
            8)).uniformRange(YOffset.getBottom(), YOffset.aboveBottom(15)).spreadHorizontally();

    public static ConfiguredFeature<?, ?> FF_REDSTONE_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.FF_REDSTONE_ORE.getDefaultState(),
            8)).spreadHorizontally().repeat(8);

    public static RegistryKey<ConfiguredFeature<?, ?>> oreOrchiumOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "ore_orchium_overworld"));
    public static RegistryKey<ConfiguredFeature<?, ?>> modIronOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "ore_mod_iron"));
    public static RegistryKey<ConfiguredFeature<?, ?>> modGoldOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "ore_mod_gold"));
    public static RegistryKey<ConfiguredFeature<?, ?>> modCoalOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "ore_mod_coal"));
    public static RegistryKey<ConfiguredFeature<?, ?>> modLapisOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "ore_mod_lapis"));
    public static RegistryKey<ConfiguredFeature<?, ?>> modDiamondOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "ore_mod_diamond"));
    public static RegistryKey<ConfiguredFeature<?, ?>> modRedstoneOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "ore_mod_redstone"));

    public static RegistryKey<ConfiguredFeature<?, ?>> gloomyGrass = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "gloomy_grass_gen"));
    public static RegistryKey<ConfiguredFeature<?, ?>> fireGrass = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ForgottenForest.MODID, "fire_grass_gen"));

    public static void initConfiguredFeatures() {

        GLOOMY_TREE = register(ForgottenForest.MODID + ":gloomy_tree", Feature.TREE.configure((
                new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.GLOOMY_LOG), new StraightTrunkPlacer(4, 2, 0), new SimpleBlockStateProvider(States.GLOOMY_LEAVES), new SimpleBlockStateProvider(States.GLOOMY_SAPLING),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreOrchiumOverworld.getValue(), ORCHIUM_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, modIronOre.getValue(), FF_IRON_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, modGoldOre.getValue(), FF_GOLD_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, modCoalOre.getValue(), FF_COAL_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, modLapisOre.getValue(), FF_LAPIS_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, modDiamondOre.getValue(), FF_DIAMOND_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, modRedstoneOre.getValue(), FF_REDSTONE_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, gloomyGrass.getValue(), GLOOMY_GRASS);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, fireGrass.getValue(), FIRE_GRASS);


    }

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<?, ?> configuredFeature) {
        return (ConfiguredFeature) Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }



    public static class Configs {

        public static final RandomPatchFeatureConfig GLOOMY_GRASS_CONFIG = new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(States.GLOOMY_GRASS), SimpleBlockPlacer.INSTANCE).tries(32).build();
        public static final RandomPatchFeatureConfig FIRE_GRASS_CONFIG = new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(States.FIRE_GRASS), SimpleBlockPlacer.INSTANCE).tries(32).build();

    }

    public static class States {

        protected static final BlockState GLOOMY_LOG = BlockRegistry.GLOOMY_LOG.getDefaultState();
        protected static final BlockState GLOOMY_LEAVES = BlockRegistry.GLOOMY_LEAVES.getDefaultState();
        protected static final BlockState GLOOMY_SAPLING = BlockRegistry.GLOOMY_SAPLING.getDefaultState();
        protected static final BlockState GLOOMY_GRASS = BlockRegistry.GLOOMY_GRASS.getDefaultState();
        protected static final BlockState FIRE_GRASS = BlockRegistry.FIRE_GRASS.getDefaultState();
    }
}
