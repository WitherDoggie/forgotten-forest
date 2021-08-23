package io.github.witherdoggie.forgottenforest.block;

import io.github.witherdoggie.forgottenforest.block.base.SpawnerBlockBase;
import io.github.witherdoggie.forgottenforest.block.base.SpawnerBlockEntityBase;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ForgottenSpiritBossSpawnerBlock extends SpawnerBlockBase {
    public ForgottenSpiritBossSpawnerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ForgottenSpiritBossSpawnerEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockRegistry.FORGOTTEN_SPIRIT_SPAWNER, ((world1, pos, state1, blockEntity) -> SpawnerBlockEntityBase.tick(world1, pos, state, blockEntity)));
    }
}
