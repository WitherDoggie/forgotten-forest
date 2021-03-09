package io.github.witherdoggie.forgottenforest.entity;

import io.github.witherdoggie.forgottenforest.mixin.LivingEntityAccessor;
import io.github.witherdoggie.forgottenforest.registry.StatusEffectRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;

public class SoulSkeletonEntity extends WitherSkeletonEntity {

    public SoulSkeletonEntity(EntityType<? extends WitherSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createSoulSkeletonAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D).add(EntityAttributes.GENERIC_MAX_HEALTH, 20D);
    }

    protected void initEquipment(LocalDifficulty difficulty) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BONE));
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
