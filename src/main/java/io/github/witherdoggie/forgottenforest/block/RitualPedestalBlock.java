package io.github.witherdoggie.forgottenforest.block;

import io.github.witherdoggie.forgottenforest.block.base.AbstractPedestalBaseBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RitualPedestalBlock extends AbstractPedestalBaseBlock {

    public RitualPedestalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RitualPedestalBlockEntity(pos, state);
    }
}
