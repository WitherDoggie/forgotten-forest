package io.github.witherdoggie.forgottenforest.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public class LakeFeatureBlockConfig implements FeatureConfig {

    public static final Codec<LakeFeatureBlockConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(BlockState.CODEC.fieldOf("state").forGetter((config) -> {
                    return config.state;
            }), BlockState.CODEC.fieldOf("surrounding_block").forGetter((config) -> {
                    return config.surroundingBlock;
                })
        ).apply(instance, LakeFeatureBlockConfig::new);
    });

    public final BlockState surroundingBlock;
    public final BlockState state;

    public LakeFeatureBlockConfig(BlockState state, BlockState surroundingBlock) {
        this.surroundingBlock = surroundingBlock;
        this.state = state;
    }
}
