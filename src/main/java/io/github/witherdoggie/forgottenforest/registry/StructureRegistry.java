package io.github.witherdoggie.forgottenforest.registry;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.world.generator.CryptGenerator;
import io.github.witherdoggie.forgottenforest.world.structure.CryptFeature;
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

    public static void initStructures() {

        FabricStructureBuilder.create(new Identifier(ForgottenForest.MODID, "crypt"), CRYPT)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();

        Registry<ConfiguredStructureFeature<?, ?>> myConfigured = (BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE);
        Registry.register(myConfigured, ForgottenForest.id("crypt"), CRYPT_CONFIGURED);
    }
}
