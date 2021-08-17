package io.github.witherdoggie.forgottenforest.item;

import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestItem extends Item {

    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult use(World world, PlayerEntity user, Hand hand){

        MinecraftClient client = MinecraftClient.getInstance();
        HitResult hit = client.crosshairTarget;
        ItemStack stack = user.getStackInHand(hand);

        switch(hit.getType()) {
            case ENTITY:
                EntityHitResult entityHit = (EntityHitResult) hit;
                Entity entity = entityHit.getEntity();
                BlockPos pos = entity.getBlockPos();
                entity.discard();
                world.setBlockState(pos, Blocks.STONE.getDefaultState());
                return TypedActionResult.success(stack);
        }
        return TypedActionResult.pass(stack);
    }
}