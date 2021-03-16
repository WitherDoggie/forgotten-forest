package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.class_5423;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeCreator;
import org.jetbrains.annotations.Nullable;

public class BiomeRegistry {

    public static final RegistryKey<Biome> GLOOMY_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(ForgottenForest.MODID, "gloomy_forest"));
    public static final RegistryKey<Biome> GLOOMY_MOUNTAINS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(ForgottenForest.MODID, "gloomy_mountains"));

    public static void initBiomes() {

        Registry.register(BuiltinRegistries.BIOME, new Identifier(ForgottenForest.MODID, "gloomy_forest"), DefaultBiomeCreator.createTheVoid());
        Registry.register(BuiltinRegistries.BIOME, new Identifier(ForgottenForest.MODID, "gloomy_mountains"), DefaultBiomeCreator.createTheVoid());

        OverworldBiomes.addContinentalBiome(GLOOMY_FOREST_KEY, OverworldClimate.TEMPERATE, 2D);
    }

    public static boolean biomeMatches(@Nullable class_5423 world, Biome biome, RegistryKey<Biome> type) {
        if (world == null) {
            return false;
        }

        Biome biome2 = world.getRegistryManager().get(Registry.BIOME_KEY).get(type);
        return biome.equals(biome2);
    }
}
