package io.github.witherdoggie.forgottenforest;

import com.google.common.collect.ImmutableSet;
import io.github.witherdoggie.forgottenforest.mixin.CarverAccessor;
import io.github.witherdoggie.forgottenforest.registry.*;
import io.github.witherdoggie.forgottenforest.world.feature.Features;
import io.github.witherdoggie.forgottenforest.world.surface.SurfaceBuilders;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;


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

        Registry.CARVER.forEach(carver -> {
            HashSet<Block> newList = new HashSet<>(ImmutableSet.copyOf(((CarverAccessor) carver).getCarvableBlocks()));
            newList.add(Blocks.IRON_BLOCK);
            ((CarverAccessor) carver).setCarvableBlocks(newList);
        });

        StructureRegistry.initStructures();

        LOGGER.info("Finished Loading Forgotten Forest");
    }
}
