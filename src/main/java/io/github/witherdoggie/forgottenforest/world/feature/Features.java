package io.github.witherdoggie.forgottenforest.world.feature;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class Features {

    public static ConfiguredFeature<?,?> GLOOMY_TREE;

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<?, ?> configuredFeature) {
        return (ConfiguredFeature) Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }

    public static void initFeatures(){

        GLOOMY_TREE = register(ForgottenForest.MODID, Feature.TREE.configure(
                (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.GLOOMY_LOG),
                        new SimpleBlockStateProvider(Features.States.GLOOMY_LEAVES),
                        new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3),
                        new StraightTrunkPlacer(4, 2, 0),
                        new TwoLayersFeatureSize(0, 0, 0))).ignoreVines().build()));
    }

    public static class States {

        protected static final BlockState GLOOMY_LOG = BlockRegistry.GLOOMY_LOG.getDefaultState();
        protected static final BlockState GLOOMY_LEAVES = BlockRegistry.GLOOMY_LEAVES.getDefaultState();
    }
}
