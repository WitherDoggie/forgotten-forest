package io.github.witherdoggie.forgottenforest.mixin;

import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import io.github.witherdoggie.forgottenforest.registry.StatusEffectRegistry;
import io.github.witherdoggie.forgottenforest.util.accessors.PlayerEntityInterface;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerEntityInterface {

    private int currentSoulCount = 0;
    private int currentLifeForce = 100;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void orchiumArmorEffects(CallbackInfo ci){

        Item helmet = getEquippedStack(EquipmentSlot.HEAD).getItem();
        Item chest = getEquippedStack(EquipmentSlot.CHEST).getItem();
        Item legs = getEquippedStack(EquipmentSlot.LEGS).getItem();
        Item boots = getEquippedStack(EquipmentSlot.FEET).getItem();

        if(helmet == ItemRegistry.ORCHIUM_HELMET && chest == ItemRegistry.ORCHIUM_CHESTPLATE && legs == ItemRegistry.ORCHIUM_LEGGINGS && boots == ItemRegistry.ORCHIUM_BOOTS){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 42, 2, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 42, 1, false, false));
        }

        if(helmet == ItemRegistry.FIREITE_HELMET && chest == ItemRegistry.FIREITE_CHESTPLATE && legs == ItemRegistry.FIREITE_LEGGINGS && boots == ItemRegistry.FIREITE_BOOTS){
            this.addStatusEffect(new StatusEffectInstance(StatusEffectRegistry.ANTI_POISON_EFFECT, 42, 1, false, false));
        }
    }

    @Inject(method = "onKilledOther", at = @At("TAIL"))
    private void onKilledOther(ServerWorld world, LivingEntity other, CallbackInfo ci){

        incrementSoulCount();
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    private void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo callbackInfo){
        nbt.putInt("currentSouls", currentSoulCount);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    private void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo callbackInfo){
        this.currentSoulCount = nbt.getInt("currentSouls");
    }

    public int getCurrentSoulCount(){
        return currentSoulCount;
    }

    public void setCurrentSoulCount(int soulCount){
        currentSoulCount = soulCount;
    }

    public void resetSoulCount(){
        setCurrentSoulCount(0);
    }

    public void decrementSoulCount(){
        setCurrentSoulCount(currentSoulCount - 1);
    }

    public void decrementSoulCount(int amount){
        setCurrentSoulCount(currentSoulCount - amount);
    }

    public void incrementSoulCount(){
        setCurrentSoulCount(currentSoulCount + 1);
    }

    public void incrementSoulCount(int amount){
        setCurrentSoulCount(currentSoulCount + amount);
    }
}