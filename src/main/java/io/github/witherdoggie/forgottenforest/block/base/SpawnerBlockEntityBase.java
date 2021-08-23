package io.github.witherdoggie.forgottenforest.block.base;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class SpawnerBlockEntityBase<T extends LivingEntity> extends BlockEntity {

    protected final EntityType<?> entityType;
    protected boolean hasSpawnedBoss = false;

    public SpawnerBlockEntityBase(BlockEntityType<?> type, EntityType<T> entityType, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.entityType = entityType;
    }

    public boolean anyPlayerInRange() {
        return world.isPlayerInRange(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, 10);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SpawnerBlockEntityBase<?> blockEntity) {

        if(blockEntity.anyPlayerInRange() && blockEntity.hasSpawnedBoss == false){
            Entity entity = blockEntity.entityType.create(world);
            entity.updatePositionAndAngles(blockEntity.getPos().getX(), blockEntity.getPos().getY(), blockEntity.getPos().getZ(), 0.0F, 0.0F);
            world.spawnEntity(entity);
            world.setBlockState(blockEntity.pos, Blocks.AIR.getDefaultState());
            blockEntity.hasSpawnedBoss = true;

        }
    }
}
