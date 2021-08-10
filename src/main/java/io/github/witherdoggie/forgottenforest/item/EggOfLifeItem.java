package io.github.witherdoggie.forgottenforest.item;

import io.github.witherdoggie.forgottenforest.entity.projectile.EggOfLifeEntity;
import io.github.witherdoggie.forgottenforest.mixin.EntityAccessor;
import io.github.witherdoggie.forgottenforest.mixin.PlayerEntityAccessor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EggOfLifeItem extends Item {

    public EggOfLifeItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

        if (!world.isClient) {
            EggOfLifeEntity eggOfLifeEntity = new EggOfLifeEntity(world, user);
            eggOfLifeEntity.setItem(itemStack);
            eggOfLifeEntity.setProperties(user, ((EntityAccessor)user).getPitch(), ((EntityAccessor)user).getYaw(), 0.0F, 1.5F, 0F);
            world.spawnEntity(eggOfLifeEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!((PlayerEntityAccessor)user).getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
