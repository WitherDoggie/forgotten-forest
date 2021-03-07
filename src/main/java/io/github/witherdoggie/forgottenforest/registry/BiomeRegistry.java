package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeCreator;

public class BiomeRegistry {

    public static final RegistryKey<Biome> GLOOMY_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(ForgottenForest.MODID, "gloomy_forest"));

    public static void initBiomes(){

        Registry.register(BuiltinRegistries.BIOME, new Identifier(ForgottenForest.MODID, "gloomy_forest"), DefaultBiomeCreator.createTheVoid());

        OverworldBiomes.addContinentalBiome(GLOOMY_FOREST_KEY, OverworldClimate.TEMPERATE, 2D);
    }
}
