package io.github.witherdoggie.forgottenforest;

import io.github.witherdoggie.forgottenforest.registry.*;
import io.github.witherdoggie.forgottenforest.world.feature.Features;
import io.github.witherdoggie.forgottenforest.world.surface.SurfaceBuilders;
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
        SurfaceBuilders.initSurfaceBuilders();
        ModItemGroups.initItemGroups();
        ItemRegistry.initItems();
        StatusEffectRegistry.initEffects();
        PotionRegistry.initPotions();
        EntityRegistry.initEntities();
        Features.initFeatures();
        BiomeRegistry.initBiomes();
        StructureRegistry.initStructures();

        LOGGER.info("Finished Loading Forgotten Forest");
    }
}
