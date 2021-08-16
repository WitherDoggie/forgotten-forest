package io.github.witherdoggie.forgottenforest.world.structure;

import com.mojang.serialization.Codec;
import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class ForgottenTower extends StructureFeature<DefaultFeatureConfig> {

    public ForgottenTower(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureFeature.StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return ForgottenTower.Start::new;
    }

    public static class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> structureIn, ChunkPos chunkPos, int referenceIn, long seedIn) {
            super(structureIn, chunkPos, referenceIn, seedIn);
        }

        @Override
        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, DefaultFeatureConfig defaultFeatureConfig, HeightLimitView heightLimitView) {

            int x = (chunkPos.x << 4) + 7;
            int z = (chunkPos.z << 4) + 7;
            BlockPos.Mutable blockPos = new BlockPos.Mutable(x, 0, z);

            StructurePoolBasedGenerator.generate(
                    dynamicRegistryManager,
                    new StructurePoolFeatureConfig(() -> dynamicRegistryManager.get(Registry.STRUCTURE_POOL_KEY)
                            .get(new Identifier(ForgottenForest.MODID, "forgotten_tower_pool")), 10), PoolStructurePiece::new,
                    chunkGenerator, structureManager, blockPos, this, this.random, false, true, heightLimitView);

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
