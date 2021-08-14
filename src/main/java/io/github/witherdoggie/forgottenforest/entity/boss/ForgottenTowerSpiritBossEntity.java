package io.github.witherdoggie.forgottenforest.entity.boss;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class ForgottenTowerSpiritBossEntity extends PathAwareEntity {

    protected ForgottenTowerSpiritBossEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createForgottenTowerSpiritBossAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.55D).add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0D);
    }

    public void initGoals(){

    }
}
