package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.generator.CryptGenerator;
import io.github.witherdoggie.forgottenforest.world.structure.CryptFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class StructureRegistry {

    public static final StructurePieceType PIECE = CryptGenerator.Piece::new;
    private static final StructureFeature<DefaultFeatureConfig> CRYPT = new CryptFeature(DefaultFeatureConfig.CODEC);
    private static final ConfiguredStructureFeature<?, ?> CRYPT_CONFIGURED = CRYPT.configure(DefaultFeatureConfig.DEFAULT);

    public static void initStructures(){

        Registry.register(Registry.STRUCTURE_PIECE, new Identifier(ForgottenForest.MODID, "piece"), PIECE);
        FabricStructureBuilder.create(new Identifier(ForgottenForest.MODID, "crypt"), CRYPT)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier(ForgottenForest.MODID, "crypt"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), CRYPT_CONFIGURED);
        BiomeModifications.addStructure(BiomeSelectors.all(), myConfigured);
    }
}
