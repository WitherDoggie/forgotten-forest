package io.github.witherdoggie.forgottenforest.entity;

import io.github.witherdoggie.forgottenforest.entity.goal.ChickenIgniteGoal;
import io.github.witherdoggie.forgottenforest.entity.goal.CreateItemWhenBreedingGoal;
import io.github.witherdoggie.forgottenforest.registry.EntityRegistry;
import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class SoulChickenEntity extends ChickenEntity {

    private static TrackedData<Boolean> IGNITE = DataTracker.registerData(ChickenEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static TrackedData<Integer> FUSE = DataTracker.registerData(ChickenEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static Ingredient BREEDING_ITEM = Ingredient.ofItems(new ItemConvertible[]{Items.WHEAT_SEEDS.asItem()});
    private int lastFuseTime;
    private int currentFuseTime;
    private int fuseTime = 30;

    public SoulChickenEntity(EntityType<? extends ChickenEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new ChickenIgniteGoal(this));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]));
        this.goalSelector.add(0, new CreateItemWhenBreedingGoal(this, 2.0D, new ItemStack(ItemRegistry.EGG_OF_LIFE_ITEM, 1)));
    }

    public static DefaultAttributeContainer.Builder createSoulChickenAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
    }

    private void explode() {
        if (!this.world.isClient) {
            Explosion.DestructionType destructionType = this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;
            this.dead = true;
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), (float) 4.0, destructionType);
            this.discard();
        }
    }

    @Override
    public void tick() {
        if (this.isAlive()) {
            this.lastFuseTime = this.currentFuseTime;

            int i = this.getFuseSpeed();
            if (i > 0 && this.currentFuseTime == 0) {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
            }

            if (this.getIgnited()) {
                this.setFuseSpeed(1);
            }

            this.currentFuseTime += i;
            if (this.currentFuseTime < 0) {
                this.currentFuseTime = 0;
            }

            if (this.currentFuseTime >= this.fuseTime) {
                this.currentFuseTime = this.fuseTime;
                this.explode();
            }
        }
        super.tick();
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IGNITE, false);
        this.dataTracker.startTracking(FUSE, -1);
    }

    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);

        if (tag.contains("Fuse", 99)) {
            this.fuseTime = tag.getShort("Fuse");
        }

        if (tag.getBoolean("ignited")) {
            this.ignite();
        }
    }

    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putBoolean("ignited", this.getIgnited());
        tag.putShort("Fuse", (short) this.fuseTime);
    }

    public int getFuseSpeed() {
        return this.dataTracker.get(FUSE);
    }

    public void setFuseSpeed(int fuseSpeed) {
        this.dataTracker.set(FUSE, fuseSpeed);
    }

    public boolean getIgnited() {
        return this.dataTracker.get(IGNITE);
    }

    public void ignite() {
        this.dataTracker.set(IGNITE, true);
    }

    public ChickenEntity createChild(ServerWorld world, PassiveEntity entity) {
        return EntityRegistry.SOUL_CHICKEN.create(world);
    }
}
