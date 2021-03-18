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

    public void generate(Random random, Chunk chunk, Biome biome, int i, int j, int k, double d, BlockState blockState, BlockState blockState2, int l, long m, QuinteroSurfaceConfig quinteroSurfaceConfig) {
        this.generate(random, chunk, biome, i, j, k, d, quinteroSurfaceConfig.getDefaultBlock(), quinteroSurfaceConfig.getDefaultFluid(), quinteroSurfaceConfig.getTopMaterial(), quinteroSurfaceConfig.getUnderMaterial(), quinteroSurfaceConfig.getUnderwaterMaterial(), l);
    }

    protected void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState fluidBlock, BlockState topBlock, BlockState underBlock, BlockState underwaterBlock, int seaLevel) {
        BlockState blockState = topBlock;
        BlockState blockState2 = underBlock;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int i = -1;
        int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int k = x & 15;
        int l = z & 15;

        for(int m = height; m >= 0; --m) {
            mutable.set(k, m, l);
            BlockState blockState3 = chunk.getBlockState(mutable);
            if (blockState3.isAir()) {
                i = -1;
            } else if (blockState3.getFluidState().isEmpty()) {
                if (i == -1) {
                    if (j <= 0) {
                        blockState = Blocks.AIR.getDefaultState();
                        blockState2 = defaultBlock;
                    } else if (m >= seaLevel - 4 && m <= seaLevel + 1) {
                        blockState = topBlock;
                        blockState2 = underBlock;
                    }

                    if (m < seaLevel && (blockState == null || blockState.isAir())) {
                        blockState = fluidBlock;

                        mutable.set(k, m, l);
                    }

                    i = j;
                    if (m >= seaLevel - 1) {
                        chunk.setBlockState(mutable, blockState, false);
                    } else if (m < seaLevel - 7 - j) {
                        blockState = Blocks.AIR.getDefaultState();
                        blockState2 = defaultBlock;
                        chunk.setBlockState(mutable, underwaterBlock, false);
                    } else {
                        chunk.setBlockState(mutable, blockState2, false);
                    }
                } else if (i > 0) {
                    --i;
                    chunk.setBlockState(mutable, blockState2, false);
                }
                else {
                    chunk.setBlockState(mutable, defaultBlock, false);
                }
            }
            else {
                chunk.setBlockState(mutable, fluidBlock, false);
            }
        }
    }
}
