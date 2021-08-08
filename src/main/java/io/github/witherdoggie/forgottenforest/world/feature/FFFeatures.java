package io.github.witherdoggie.forgottenforest.world.feature;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class FFFeatures {

    public static void initFeatures(){

        register("fire_lava_lake", new FFLakeFeature());
    }

    @SuppressWarnings("UnusedReturnValue")
    private static <C extends FeatureConfig, F extends Feature<C>> F register(String id, F feature) {
        return Registry.register(Registry.FEATURE, ForgottenForest.id(id), feature);
    }
}
