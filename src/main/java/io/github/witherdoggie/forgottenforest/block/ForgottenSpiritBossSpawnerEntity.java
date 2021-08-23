package io.github.witherdoggie.forgottenforest.block;

import io.github.witherdoggie.forgottenforest.block.base.SpawnerBlockEntityBase;
import io.github.witherdoggie.forgottenforest.entity.boss.ForgottenTowerSpiritBossEntity;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import io.github.witherdoggie.forgottenforest.registry.EntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;

public class ForgottenSpiritBossSpawnerEntity extends SpawnerBlockEntityBase<ForgottenTowerSpiritBossEntity> {

    public ForgottenSpiritBossSpawnerEntity(BlockPos pos, BlockState state) {
        super(BlockRegistry.FORGOTTEN_SPIRIT_SPAWNER, EntityRegistry.FORGOTTEN_TOWER_SPIRIT, pos, state);
    }
}
