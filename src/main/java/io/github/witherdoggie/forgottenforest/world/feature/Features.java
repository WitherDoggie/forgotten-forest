package io.github.witherdoggie.forgottenforest.world.feature;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.registry.BiomeRegistry;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class Features {

    public static ConfiguredFeature<?, ?> GLOOMY_TREE;
    public static ConfiguredFeature<?, ?> ORCHIUM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.ORCHIUM_ORE.getDefaultState(),
                        8)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 16))).spreadHorizontally().repeat(3);

    public static ConfiguredFeature<?, ?> FF_IRON_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.FF_IRON_ORE.getDefaultState(),
            9)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64))).spreadHorizontally().repeat(20);

    public static RegistryKey<ConfiguredFeature<?, ?>> oreOrchiumOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
            new Identifier(ForgottenForest.MODID, "ore_orchium_overworld"));

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<?, ?> configuredFeature) {
        return (ConfiguredFeature) Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }

    public static void initFeatures() {

        GLOOMY_TREE = register(ForgottenForest.MODID + ":gloomy_tree", Feature.TREE.configure(
                (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.GLOOMY_LOG),
                        new SimpleBlockStateProvider(Features.States.GLOOMY_LEAVES),
                        new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3),
                        new StraightTrunkPlacer(4, 2, 0),
                        new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build()));

        ORCHIUM_ORE = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreOrchiumOverworld.getValue(), ORCHIUM_ORE);
        //BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeRegistry.GLOOMY_FOREST_KEY), GenerationStep.Feature.UNDERGROUND_ORES, oreOrchiumOverworld);

    }

    public static class States {

        protected static final BlockState GLOOMY_LOG = BlockRegistry.GLOOMY_LOG.getDefaultState();
        protected static final BlockState GLOOMY_LEAVES = BlockRegistry.GLOOMY_LEAVES.getDefaultState();
    }
}
