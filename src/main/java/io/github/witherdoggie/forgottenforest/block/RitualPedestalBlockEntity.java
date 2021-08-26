package io.github.witherdoggie.forgottenforest.block;

import io.github.witherdoggie.forgottenforest.block.base.AbstractPedestalBaseBlockEntity;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class RitualPedestalBlockEntity extends AbstractPedestalBaseBlockEntity {

    public RitualPedestalBlockEntity(BlockPos pos, BlockState state) {
        super(BlockRegistry.RITUAL_PEDESTAL_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void fromClientTag(NbtCompound tag) {
        super.fromClientTag(tag);
    }

    @Override
    public NbtCompound toClientTag(NbtCompound tag) {
        return super.toClientTag(tag);
    }
}
