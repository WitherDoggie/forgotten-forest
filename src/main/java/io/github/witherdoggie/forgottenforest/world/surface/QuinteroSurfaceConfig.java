package io.github.witherdoggie.forgottenforest.world.surface;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;

public class QuinteroSurfaceConfig implements SurfaceConfig {

    public static final Codec<QuinteroSurfaceConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.CODEC.fieldOf("top_material").forGetter((config) -> {
                    return config.topMaterial;
                }), BlockState.CODEC.fieldOf("under_material").forGetter((config) -> {
                    return config.underMaterial;
                }), BlockState.CODEC.fieldOf("underwater_material").forGetter((config) -> {
                    return config.underwaterMaterial;
                }), BlockState.CODEC.fieldOf("default_block").forGetter((config) -> {
                    return config.defaultBlock;
                }), BlockState.CODEC.fieldOf("default_fluid").forGetter((config) -> {
                    return config.defaultFluid;
        })
        ).apply(instance, QuinteroSurfaceConfig::new);
    });

    private final BlockState topMaterial;
    private final BlockState underMaterial;
    private final BlockState underwaterMaterial;
    private final BlockState defaultBlock;
    private final BlockState defaultFluid;

    public QuinteroSurfaceConfig(BlockState topMaterial, BlockState underMaterial, BlockState underwaterMaterial, BlockState defaultBlock, BlockState defaultFluid) {
        this.topMaterial = topMaterial;
        this.underMaterial = underMaterial;
        this.underwaterMaterial = underwaterMaterial;
        this.defaultBlock = defaultBlock;
        this.defaultFluid = defaultFluid;
    }

    @Override
    public BlockState getTopMaterial() {
        return topMaterial;
    }

    @Override
    public BlockState getUnderMaterial() {
        return underMaterial;
    }

    public BlockState getUnderwaterMaterial(){
        return underwaterMaterial;
    }

    public BlockState getDefaultBlock(){
        return defaultBlock;
    }

    public BlockState getDefaultFluid(){
        return defaultFluid;
    }
}
