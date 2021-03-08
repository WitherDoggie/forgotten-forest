package io.github.witherdoggie.forgottenforest.entity;

import io.github.witherdoggie.forgottenforest.mixin.LivingEntityAccessor;
import io.github.witherdoggie.forgottenforest.registry.StatusEffectRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.List;

public class SoulSpiderEntity extends SpiderEntity {

    public SoulSpiderEntity(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createSoulSpiderAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4D);
    }

    @Override
    public boolean tryAttack(Entity target){
        boolean bl = super.tryAttack(target);

        if(bl == true){
            heal((LivingEntity) target);
        }
        return bl;
    }

    private void heal(LivingEntity target){

        if(target.hasStatusEffect(StatusEffectRegistry.SOUL_SERUM)){
            return;
        }
        this.heal(((LivingEntityAccessor)target).getLastDamageTaken());
    }
}
