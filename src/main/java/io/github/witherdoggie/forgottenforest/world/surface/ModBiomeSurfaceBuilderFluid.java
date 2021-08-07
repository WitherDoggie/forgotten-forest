package io.github.witherdoggie.forgottenforest.world.surface;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.Random;

public class ModBiomeSurfaceBuilderFluid extends SurfaceBuilder<QuinteroSurfaceConfig> {

    public ModBiomeSurfaceBuilderFluid() {
        super(QuinteroSurfaceConfig.CODEC);
    }

    @Override
    public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int i, long l, QuinteroSurfaceConfig surfaceConfig) {

        BlockState topState = surfaceConfig.getTopMaterial();
        BlockState underState = surfaceConfig.getUnderMaterial();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int maxDepth = -1;
        int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int k = x & 15;
        int lx = z & 15;

        for(int m = height; m >= 0; --m) {
            mutable.set(k, m, lx);
            BlockState blockState3 = chunk.getBlockState(mutable);
            if (blockState3.isAir()) {
                maxDepth = -1;
            } else if (blockState3.getFluidState().isEmpty()) {
                if (maxDepth == -1) {
                    if (j <= 0) {
                        topState = Blocks.AIR.getDefaultState();
                        underState = surfaceConfig.getDefaultBlock();
                    } else if (m >= seaLevel - 4 && m <= seaLevel + 1) {
                        topState = surfaceConfig.getTopMaterial();
                        underState = surfaceConfig.getUnderMaterial();
                    }

                    if (m < seaLevel && (topState == null || topState.isAir())) {
                        topState = surfaceConfig.getDefaultFluid();

                        mutable.set(k, m, l);
                    }

                    maxDepth = j;
                    if (m >= seaLevel - 1) {
                        chunk.setBlockState(mutable, topState, false);
                    } else if (m < seaLevel - 7 - j) {
                        topState = Blocks.AIR.getDefaultState();
                        underState = surfaceConfig.getDefaultBlock();
                        chunk.setBlockState(mutable, surfaceConfig.getUnderwaterMaterial(), false);
                    } else {
                        chunk.setBlockState(mutable, underState, false);
                    }
                } else if (maxDepth > 0) {
                    --maxDepth;
                    chunk.setBlockState(mutable, underState, false);

                } else {
                    chunk.setBlockState(mutable, surfaceConfig.getDefaultBlock(), false);
                }
            }
        }
    }
}
