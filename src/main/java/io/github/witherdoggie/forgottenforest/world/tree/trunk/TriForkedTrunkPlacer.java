package io.github.witherdoggie.forgottenforest.world.tree.trunk;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.witherdoggie.forgottenforest.world.feature.ConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TriForkedTrunkPlacer extends TrunkPlacer {

    public static final Codec<TriForkedTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return fillTrunkPlacerFields(instance).apply(instance, TriForkedTrunkPlacer::new);
    });

    public TriForkedTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ConfiguredFeatures.TRI_FORKED_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {

        setToDirt(world, replacer, random, startPos.down(), config);
        List<FoliagePlacer.TreeNode> nodes = Lists.newArrayList();

        for(int i = 0; i < baseHeight; i++) {
            getAndSetState(world, replacer, random, startPos, config);
            startPos = startPos.up();
        }

        BlockPos branchOne = startPos;
        BlockPos branchTwo = startPos;

        for(int i = 0; i < random.nextInt(5); i++){
            getAndSetState(world, replacer, random, branchOne.east().north(), config);
            branchOne = branchOne.east().north().up();
            getAndSetState(world, replacer, random, branchTwo.west(), config);
            branchTwo = branchTwo.west().up();
            getAndSetState(world, replacer, random, startPos.south(), config);
            startPos = startPos.south().up();
        }

        return nodes;
    }
}
