package io.github.witherdoggie.forgottenforest.mixin;

import com.mojang.authlib.GameProfile;
import io.github.witherdoggie.forgottenforest.util.accessors.PlayerEntityInterface;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {

    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }

    @Inject(method = "onDeath", at = @At("TAIL"))
    private void onDeath(DamageSource source, CallbackInfo ci){

        /* Player loses 10% of souls on death */
        double souls = ((PlayerEntityInterface)this).getCurrentSoulCount() * 0.1;
        ((PlayerEntityInterface)this).setCurrentSoulCount(((PlayerEntityInterface)this).getCurrentSoulCount() - (int)souls);
    }
}
