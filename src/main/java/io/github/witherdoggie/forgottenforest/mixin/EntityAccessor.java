package io.github.witherdoggie.forgottenforest.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.TeleportTarget;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityAccessor {

    @Nullable
    @Invoker("getTeleportTarget")
    TeleportTarget invokeGetTeleportTarget(ServerWorld destination);
}
