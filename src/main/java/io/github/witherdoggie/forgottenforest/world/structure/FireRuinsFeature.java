package io.github.witherdoggie.forgottenforest.world.structure;

import com.mojang.serialization.Codec;
import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.world.generator.FireRuinsGenerator;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructureStart;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class FireRuinsFeature extends StructureFeature<DefaultFeatureConfig> {

    public FireRuinsFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return FireRuinsFeature.Start::new;
    }

    @Override
    public GenerationStep.Feature getGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {

        public Start(StructureFeature<DefaultFeatureConfig> feature, ChunkPos pos, int references, long seed) {
            super(feature, pos, references, seed);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, DefaultFeatureConfig config, HeightLimitView world) {
            int x = (pos.x << 4) + 7;
            int z = (pos.z << 4) + 7;
            BlockPos.Mutable blockPos = new BlockPos.Mutable(x, 0, z);

            StructurePoolBasedGenerator.generate(
                    registryManager,
                    new StructurePoolFeatureConfig(() -> registryManager.get(Registry.STRUCTURE_POOL_KEY).get(new Identifier(ForgottenForest.MODID, "ruins_pool")), 10), PoolStructurePiece::new,
                    chunkGenerator, manager, blockPos, this, this.random, false, true, world);

            this.children.forEach(piece -> piece.translate(0, 1, 0));
            this.children.forEach(piece -> piece.getBoundingBox().move(0, -1, 0));
            this.setBoundingBoxFromChildren();

            Vec3i structureCenter = this.children.get(0).getBoundingBox().getCenter();
            int xOffset = blockPos.getX() - structureCenter.getX();
            int zOffset = blockPos.getZ() - structureCenter.getZ();
            for(StructurePiece structurePiece : this.children){
                structurePiece.translate(xOffset, 0, zOffset);
            }
        }
    }
}