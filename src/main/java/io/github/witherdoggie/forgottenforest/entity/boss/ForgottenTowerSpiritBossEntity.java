package io.github.witherdoggie.forgottenforest.entity.boss;

import io.github.witherdoggie.forgottenforest.mixin.LivingEntityAccessor;
import io.github.witherdoggie.forgottenforest.registry.StatusEffectRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.Random;

public class ForgottenTowerSpiritBossEntity extends PathAwareEntity {

    private final Random random = new Random();
    private final ServerBossBar bossBar;

    public ForgottenTowerSpiritBossEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = (ServerBossBar)(new ServerBossBar(this.getDisplayName(), BossBar.Color.BLUE, BossBar.Style.PROGRESS)).setDarkenSky(true);
    }

    public static DefaultAttributeContainer.Builder createForgottenTowerSpiritBossAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.55D).add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0D);
    }

    public void initGoals(){

        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
        this.targetSelector.add(2, new FollowTargetGoal(this, PlayerEntity.class, true));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(0, new SwimGoal(this));
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = super.tryAttack(target);

        int attackValue = random.nextInt(30);

        if(attackValue == 3) {
            if (target instanceof PlayerEntity) {
                dropPlayerItem((PlayerEntity) target);
            }
        }
        else if(attackValue == 23){
            if (bl == true) {
                heal((LivingEntity) target);
            }
        }
        else if(attackValue == 15){
            createExplosion();
        }
        return bl;
    }

    protected void mobTick(){
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    private void heal(LivingEntity target) {

        if (target.hasStatusEffect(StatusEffectRegistry.SOUL_SERUM)) {
            return;
        }
        this.heal(((LivingEntityAccessor) target).getLastDamageTaken());
    }

    private void dropPlayerItem(PlayerEntity player){
        player.dropItem(player.getMainHandStack(), false);
        player.setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
    }

    private void createExplosion(){
        if (!this.world.isClient) {
            Explosion.DestructionType destructionType = Explosion.DestructionType.NONE;
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), (float) 2.0, destructionType);
        }
    }
}
