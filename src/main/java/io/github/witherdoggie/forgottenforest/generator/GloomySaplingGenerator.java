package io.github.witherdoggie.forgottenforest.generator;

import io.github.witherdoggie.forgottenforest.world.feature.ConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class GloomySaplingGenerator extends SaplingGenerator {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bl) {
        return (ConfiguredFeature<TreeFeatureConfig, ?>) ConfiguredFeatures.GLOOMY_TREE;
    }

}
