package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.world.generator.structure.CryptGenerator;
import io.github.witherdoggie.forgottenforest.world.generator.structure.FireRuinsGenerator;
import io.github.witherdoggie.forgottenforest.world.generator.structure.ForgottenTowerGenerator;
import io.github.witherdoggie.forgottenforest.world.structure.CryptFeature;
import io.github.witherdoggie.forgottenforest.world.structure.FireRuinsFeature;
import io.github.witherdoggie.forgottenforest.world.structure.ForgottenTower;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class StructureRegistry {

    public static final StructureFeature<DefaultFeatureConfig> CRYPT = new CryptFeature(DefaultFeatureConfig.CODEC);
    public static final ConfiguredStructureFeature<?, ?> CRYPT_CONFIGURED = CRYPT.configure(DefaultFeatureConfig.DEFAULT);
    public static final StructurePieceType CRYPT_PIECE = StructurePieceType.register(CryptGenerator.Piece::new, "crypt");

    public static final StructureFeature<DefaultFeatureConfig> FIRE_RUINS = new FireRuinsFeature(DefaultFeatureConfig.CODEC);
    public static final ConfiguredStructureFeature<?, ?> FIRE_RUINS_CONFIGURED = FIRE_RUINS.configure(DefaultFeatureConfig.DEFAULT);
    public static final StructurePieceType FIRE_RUINS_PIECE = StructurePieceType.register(FireRuinsGenerator.Piece::new, "ruins");

    public static final StructureFeature<DefaultFeatureConfig> FORGOTTEN_TOWER = new ForgottenTower(DefaultFeatureConfig.CODEC);
    public static final ConfiguredStructureFeature<?, ?> FORGOTTEN_TOWER_CONFIGURED = FORGOTTEN_TOWER.configure(DefaultFeatureConfig.DEFAULT);
    public static final StructurePieceType FORGOTTEN_TOWER_PIECE = StructurePieceType.register(ForgottenTowerGenerator.Piece::new, "forgotten_tower");

    public static void initStructures() {

        FabricStructureBuilder.create(new Identifier(ForgottenForest.MODID, "crypt"), CRYPT)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();

        FabricStructureBuilder.create(new Identifier(ForgottenForest.MODID, "ruins"), FIRE_RUINS)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(20, 8, 1237986756)
                .adjustsSurface()
                .register();

        FabricStructureBuilder.create(new Identifier(ForgottenForest.MODID, "forgotten_tower"), FORGOTTEN_TOWER)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(34, 8, 987124098)
                .adjustsSurface()
                .register();

        Registry<ConfiguredStructureFeature<?, ?>> myConfigured = (BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE);
        Registry.register(myConfigured, ForgottenForest.id("crypt"), CRYPT_CONFIGURED);

        Registry<ConfiguredStructureFeature<?, ?>> configuredFireRuins = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(configuredFireRuins, ForgottenForest.id("ruins"), FIRE_RUINS_CONFIGURED);

        Registry<ConfiguredStructureFeature<?, ?>> configuredForgottenTower = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(configuredForgottenTower, ForgottenForest.id("forgotten_tower"), FORGOTTEN_TOWER_CONFIGURED);
    }
}
