package io.github.witherdoggie.forgottenforest;

import com.google.common.collect.ImmutableSet;
import io.github.witherdoggie.forgottenforest.mixin.CarverAccessor;
import io.github.witherdoggie.forgottenforest.registry.*;
import io.github.witherdoggie.forgottenforest.world.feature.ConfiguredFeatures;
import io.github.witherdoggie.forgottenforest.world.feature.FFFeatures;
import io.github.witherdoggie.forgottenforest.world.surface.SurfaceBuilders;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;


public class ForgottenForest implements ModInitializer {

    public static final String MODID = "forgotten_forest";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static Identifier id(String id) {
        return new Identifier(MODID, id);
    }

    @Override
    public void onInitialize() {

        LOGGER.info("Began Loading Forgotten Forest");

        ModItemGroups.initItemGroups();
        BlockRegistry.initBlocks();
        SurfaceBuilders.initSurfaceBuilders();
        ItemRegistry.initItems();
        StatusEffectRegistry.initEffects();
        PotionRegistry.initPotions();
        EntityRegistry.initEntities();
        FFFeatures.initFeatures();
        ConfiguredFeatures.initConfiguredFeatures();
        BiomeRegistry.initBiomes();

        //Add new stone types to carvers.
        Registry.CARVER.forEach(carver -> {
            HashSet<Block> newList = new HashSet<>(ImmutableSet.copyOf(((CarverAccessor) carver).getCarvableBlocks()));
            if(newList.contains(Blocks.STONE)) {
                newList.add(BlockRegistry.GLOOMY_STONE);
                newList.add(BlockRegistry.FIRE_STONE);
            }
            ((CarverAccessor) carver).setCarvableBlocks(newList);
        });

        ProcessorRegistry.initStructureProcessors();
        StructureRegistry.initStructures();

        LOGGER.info("Finished Loading Forgotten Forest");
    }
}
