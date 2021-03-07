package io.github.witherdoggie.forgottenforest.world.structure;

import com.mojang.serialization.Codec;
import io.github.witherdoggie.forgottenforest.ForgottenForest;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class CryptFeature extends StructureFeature<DefaultFeatureConfig> {

    public CryptFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    public static class Start extends MarginedStructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> feature, int chunkX, int chunkZ, BlockBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, int chunkX, int chunkZ, Biome biome, DefaultFeatureConfig config) {

            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            BlockPos.Mutable blockpos = new BlockPos.Mutable(x, 0, z);

            StructurePoolBasedGenerator.method_30419(
                    registryManager,
                    new StructurePoolFeatureConfig(() -> registryManager.get(Registry.TEMPLATE_POOL_WORLDGEN)
                            .get(new Identifier(ForgottenForest.MODID, "crypt_pool_top")), 10), PoolStructurePiece::new,
                            chunkGenerator, manager, blockpos, this.children, this.random, false, true);

            this.children.forEach(piece -> piece.translate(0, 1, 0));
            this.children.forEach(piece -> piece.getBoundingBox().minY -= 1);
            this.setBoundingBoxFromChildren();
        }
    }
}
