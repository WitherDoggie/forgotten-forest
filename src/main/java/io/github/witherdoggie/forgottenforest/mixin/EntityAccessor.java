package io.github.witherdoggie.forgottenforest.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.TeleportTarget;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityAccessor {

    @Nullable
    @Invoker("getTeleportTarget")
    TeleportTarget invokeGetTeleportTarget(ServerWorld destination);

    @Accessor("yaw")
    float getYaw();

    @Accessor("pitch")
    float getPitch();

    @Accessor("yaw")
    void setYaw(float y);

    @Accessor("pitch")
    void setPitch(float p);
}
