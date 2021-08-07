package io.github.witherdoggie.forgottenforest.entity.projectile;

import io.github.witherdoggie.forgottenforest.ForgottenForest;
import io.github.witherdoggie.forgottenforest.registry.EntityRegistry;
import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import io.github.witherdoggie.forgottenforest.registry.TagRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.Random;

public class EggOfLifeEntity extends ThrownItemEntity{

    private static final int MAX_ENTITIES = 5;

    public EggOfLifeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public EggOfLifeEntity(World world, LivingEntity owner) {
        super(EntityRegistry.EGG_OF_LIFE, owner, world);
    }

    public EggOfLifeEntity(World world, double x, double y, double z) {
        super(EntityRegistry.EGG_OF_LIFE, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.EGG_OF_LIFE_ITEM;
    }


    protected ParticleEffect getParticleParameters() {
        return null;
    }

    @Override
    public void handleStatus(byte status) {

    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, this.getOwner()), 0.0F);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        Random rand = new Random();
        if (!this.world.isClient) {

            for(int i = 0; i < MAX_ENTITIES; i++){
                EntityType<?> entity = TagRegistry.LIFE_EGG_ENTITIES.getRandom(rand);
                Entity temp = entity.create(world);
                temp.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                temp.setVelocity((this.getVelocity().getX() + 0.5) * (rand.nextInt(3) - 1), this.getVelocity().getY() + 0.5, (this.getVelocity().getZ() + 0.5) * (rand.nextInt(3) - 1));
                this.world.spawnEntity(temp);
            }

            this.world.sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }
}
