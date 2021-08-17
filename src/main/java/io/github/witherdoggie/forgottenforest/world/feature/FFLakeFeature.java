package io.github.witherdoggie.forgottenforest.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.LightType;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class FFLakeFeature extends Feature<LakeFeatureBlockConfig> {

    private static final BlockState CAVE_AIR;

    static {
        CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();
    }

    public FFLakeFeature() {
        super(LakeFeatureBlockConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<LakeFeatureBlockConfig> context) {
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        Random random = context.getRandom();

        LakeFeatureBlockConfig singleStateFeatureConfig;
        for(singleStateFeatureConfig = context.getConfig(); blockPos.getY() > structureWorldAccess.getBottomY() + 5 && structureWorldAccess.isAir(blockPos); blockPos = blockPos.down()) {
        }

        if (blockPos.getY() <= structureWorldAccess.getBottomY() + 4) {
            return false;
        } else {
            blockPos = blockPos.down(4);
            if (structureWorldAccess.getStructures(ChunkSectionPos.from(blockPos), StructureFeature.VILLAGE).findAny().isPresent()) {
                return false;
            } else {
                boolean[] bls = new boolean[2048];
                int i = random.nextInt(4) + 4;

                int ae;
                for(ae = 0; ae < i; ++ae) {
                    double d = random.nextDouble() * 6.0D + 3.0D;
                    double e = random.nextDouble() * 4.0D + 2.0D;
                    double f = random.nextDouble() * 6.0D + 3.0D;
                    double g = random.nextDouble() * (16.0D - d - 2.0D) + 1.0D + d / 2.0D;
                    double h = random.nextDouble() * (8.0D - e - 4.0D) + 2.0D + e / 2.0D;
                    double k = random.nextDouble() * (16.0D - f - 2.0D) + 1.0D + f / 2.0D;

                    for(int l = 1; l < 15; ++l) {
                        for(int m = 1; m < 15; ++m) {
                            for(int n = 1; n < 7; ++n) {
                                double o = ((double)l - g) / (d / 2.0D);
                                double p = ((double)n - h) / (e / 2.0D);
                                double q = ((double)m - k) / (f / 2.0D);
                                double r = o * o + p * p + q * q;
                                if (r < 1.0D) {
                                    bls[(l * 16 + m) * 8 + n] = true;
                                }
                            }
                        }
                    }
                }

                int ac;
                int ab;
                for(ae = 0; ae < 16; ++ae) {
                    for(ab = 0; ab < 16; ++ab) {
                        for(ac = 0; ac < 8; ++ac) {
                            boolean bl = !bls[(ae * 16 + ab) * 8 + ac] && (ae < 15 && bls[((ae + 1) * 16 + ab) * 8 + ac] || ae > 0 && bls[((ae - 1) * 16 + ab) * 8 + ac] || ab < 15 && bls[(ae * 16 + ab + 1) * 8 + ac] || ab > 0 && bls[(ae * 16 + (ab - 1)) * 8 + ac] || ac < 7 && bls[(ae * 16 + ab) * 8 + ac + 1] || ac > 0 && bls[(ae * 16 + ab) * 8 + (ac - 1)]);
                            if (bl) {
                                Material material = structureWorldAccess.getBlockState(blockPos.add(ae, ac, ab)).getMaterial();
                                if (ac >= 4 && material.isLiquid()) {
                                    return false;
                                }

                                if (ac < 4 && !material.isSolid() && structureWorldAccess.getBlockState(blockPos.add(ae, ac, ab)) != singleStateFeatureConfig.state) {
                                    return false;
                                }
                            }
                        }
                    }
                }

                BlockPos blockPos5;
                boolean bl3;
                for(ae = 0; ae < 16; ++ae) {
                    for(ab = 0; ab < 16; ++ab) {
                        for(ac = 0; ac < 8; ++ac) {
                            if (bls[(ae * 16 + ab) * 8 + ac]) {
                                blockPos5 = blockPos.add(ae, ac, ab);
                                bl3 = ac >= 4;
                                structureWorldAccess.setBlockState(blockPos5, bl3 ? CAVE_AIR : singleStateFeatureConfig.state, 2);
                                if (bl3) {
                                    structureWorldAccess.getBlockTickScheduler().schedule(blockPos5, CAVE_AIR.getBlock(), 0);
                                    this.markBlocksAboveForPostProcessing(structureWorldAccess, blockPos5);
                                }
                            }
                        }
                    }
                }

                for(ae = 0; ae < 16; ++ae) {
                    for(ab = 0; ab < 16; ++ab) {
                        for(ac = 4; ac < 8; ++ac) {
                            if (bls[(ae * 16 + ab) * 8 + ac]) {
                                blockPos5 = blockPos.add(ae, ac - 1, ab);
                                if (isSoil(structureWorldAccess.getBlockState(blockPos5)) && structureWorldAccess.getLightLevel(LightType.SKY, blockPos.add(ae, ac, ab)) > 0) {
                                    Biome biome = structureWorldAccess.getBiome(blockPos5);
                                    if (biome.getGenerationSettings().getSurfaceConfig().getTopMaterial().isOf(Blocks.MYCELIUM)) {
                                        structureWorldAccess.setBlockState(blockPos5, Blocks.MYCELIUM.getDefaultState(), 2);
                                    } else {
                                        structureWorldAccess.setBlockState(blockPos5, Blocks.GRASS_BLOCK.getDefaultState(), 2);
                                    }
                                }
                            }
                        }
                    }
                }

                if (singleStateFeatureConfig.state.getMaterial() == Material.LAVA) {
                    for(ab = 0; ab < 16; ++ab) {
                        for(ac = 0; ac < 16; ++ac) {
                            for(int ad = 0; ad < 8; ++ad) {
                                bl3 = !bls[(ab * 16 + ac) * 8 + ad] && (ab < 15 && bls[((ab + 1) * 16 + ac) * 8 + ad] || ab > 0 && bls[((ab - 1) * 16 + ac) * 8 + ad] || ac < 15 && bls[(ab * 16 + ac + 1) * 8 + ad] || ac > 0 && bls[(ab * 16 + (ac - 1)) * 8 + ad] || ad < 7 && bls[(ab * 16 + ac) * 8 + ad + 1] || ad > 0 && bls[(ab * 16 + ac) * 8 + (ad - 1)]);
                                if (bl3 && (ad < 4 || random.nextInt(2) != 0) && context.getWorld().getBlockState(blockPos.add(ab, ad, ac)).getMaterial().isSolid()) {
                                    context.getWorld().setBlockState(blockPos.add(ab, ad, ac), context.getConfig().surroundingBlock, 2);
                                }
                            }
                        }
                    }
                }

                if (singleStateFeatureConfig.state.getMaterial() == Material.WATER) {
                    for(ae = 0; ae < 16; ++ae) {
                        for(ab = 0; ab < 16; ++ab) {
                            blockPos5 = blockPos.add(ae, 4, ab);
                            if (structureWorldAccess.getBiome(blockPos5).canSetIce(structureWorldAccess, blockPos5, false)) {
                                structureWorldAccess.setBlockState(blockPos5, Blocks.ICE.getDefaultState(), 2);
                            }
                        }
                    }
                }
                return true;
            }
        }
    }
}
