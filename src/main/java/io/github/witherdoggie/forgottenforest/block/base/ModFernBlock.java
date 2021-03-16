package io.github.witherdoggie.forgottenforest.block.base;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FernBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModFernBlock extends FernBlock {

    public ModFernBlock(Settings settings) {
        super(settings);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(BlockRegistry.GLOOMY_GRASS_BLOCK) || floor.isOf(BlockRegistry.GLOOMY_DIRT);
    }
}
