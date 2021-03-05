package io.github.witherdoggie.forgottenforest;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import io.github.witherdoggie.forgottenforest.world.feature.Features;
import net.fabricmc.api.ModInitializer;

public class ForgottenForest implements ModInitializer {

    public static final String MODID = "forgotten_forest";
    @Override
    public void onInitialize() {

        BlockRegistry.initBlocks();
        ItemRegistry.initItems();
        Features.initFeatures();
    }
}
