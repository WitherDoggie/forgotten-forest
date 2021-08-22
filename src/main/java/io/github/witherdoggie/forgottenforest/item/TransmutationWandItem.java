package io.github.witherdoggie.forgottenforest.item;

import io.github.witherdoggie.forgottenforest.registry.TagRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class TransmutationWandItem extends Item {

    public TransmutationWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult use(World world, PlayerEntity user, Hand hand){

        Random random = new Random();
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult hit = client.crosshairTarget;
        ItemStack stack = user.getStackInHand(hand);

        switch(hit.getType()) {
            case ENTITY:
                EntityHitResult entityHit = (EntityHitResult) hit;
                Entity entity = entityHit.getEntity();
                if (entity.getType().getSpawnGroup() == SpawnGroup.CREATURE || entity.getType().getSpawnGroup() == SpawnGroup.WATER_CREATURE || entity.getType().getSpawnGroup() == SpawnGroup.WATER_AMBIENT){
                    BlockPos pos = entity.getBlockPos();
                    entity.discard();
                    world.setBlockState(pos, TagRegistry.TRANSMUTABLE_BLOCKS.getRandom(random).getDefaultState());
                    user.sendMessage(new TranslatableText("action.bar.transmute.success"), true);
                    return TypedActionResult.success(stack);
                }
                else {
                    user.sendMessage(new TranslatableText("action.bar.transmute.fail"), true);
                }
        }
        return TypedActionResult.pass(stack);
    }
}