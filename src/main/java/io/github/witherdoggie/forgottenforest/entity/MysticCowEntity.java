package io.github.witherdoggie.forgottenforest.entity;

import io.github.witherdoggie.forgottenforest.entity.goal.MysticCowIgniteGoal;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MysticCowEntity extends CowEntity implements SkinOverlayOwner {

    private static TrackedData<Boolean> IGNITE = DataTracker.registerData(CowEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static TrackedData<Integer> FUSE = DataTracker.registerData(CowEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private int currentFuseTime;
    private int fuseTime = 30;
    private int lastFuseTime;

    public MysticCowEntity(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new MysticCowIgniteGoal(this));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(1, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]));
    }

    private void explode() {
        if (!this.world.isClient) {
            LivingEntity target = this.getTarget();

            if(target instanceof ServerPlayerEntity){
                ((ServerPlayerEntity) target).teleport(((ServerPlayerEntity) target).getServerWorld(), target.getX(), this.getY() + 100, target.getZ(), target.getYaw(), this.getPitch());
                ((ServerPlayerEntity) target).sendMessage(new TranslatableText("action.bar.mystic_mob.teleport"), true);
            }
            this.dead = true;
            this.discard();
        }
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            ItemStack itemStack2 = player.getStackInHand(hand);
            itemStack2.decrement(1);
            player.setStackInHand(hand, itemStack2);
            return ActionResult.success(this.world.isClient);
        } else {
            return super.interactMob(player, hand);
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

    @Override
    public boolean shouldRenderOverlay() {
        return true;
    }
}
