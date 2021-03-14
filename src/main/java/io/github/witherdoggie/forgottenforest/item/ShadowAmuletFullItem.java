package io.github.witherdoggie.forgottenforest.item;

import io.github.witherdoggie.forgottenforest.mixin.EntityAccessor;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;

import java.util.List;

public class ShadowAmuletFullItem extends Item {

    public ShadowAmuletFullItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.forgotten_forest.shadow_amulet_full.tooltip").formatted(Formatting.GRAY));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);

        if(!world.isClient()) {
            ServerWorld serverWorld = (ServerWorld)world;
            MinecraftServer minecraftServer = serverWorld.getServer();
            RegistryKey<World> registryKey = World.END;
            ServerWorld serverWorld2 = minecraftServer.getWorld(registryKey);

            if (serverWorld2 != null) {
                user.moveToWorld(serverWorld2);
            }
            return TypedActionResult.success(itemStack);
        }

        return TypedActionResult.pass(itemStack);
    }
}
