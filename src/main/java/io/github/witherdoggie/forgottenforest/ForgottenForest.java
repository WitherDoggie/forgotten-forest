package io.github.witherdoggie.forgottenforest;

import io.github.witherdoggie.forgottenforest.registry.*;
import io.github.witherdoggie.forgottenforest.world.feature.Features;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ForgottenForest implements ModInitializer {

    public static final String MODID = "forgotten_forest";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize() {

        LOGGER.info("Began Loading Forgotten Forest");

        BlockRegistry.initBlocks();
        ModItemGroups.initItemGroups();
        ItemRegistry.initItems();
        Features.initFeatures();
        BiomeRegistry.initBiomes();
        StructureRegistry.initStructures();

        LOGGER.info("Finished Loading Forgotten Forest");
    }
}
