package io.github.witherdoggie.forgottenforest.item;

import io.github.witherdoggie.forgottenforest.util.accessors.PlayerEntityInterface;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class EntitySummoningStaffItem extends Item {

    private boolean isBound = false;
    private EntityType<?> boundEntity;
    public static HashMap<EntityType<?>, Integer> entitySummonMap = new HashMap(Map.ofEntries(
            Map.entry(EntityType.COW, 10),
            Map.entry(EntityType.PIG, 15),
            Map.entry(EntityType.CHICKEN, 20),
            Map.entry(EntityType.SHEEP, 20),
            Map.entry(EntityType.GOAT, 5),
            Map.entry(EntityType.ZOMBIE, 10),
            Map.entry(EntityType.SKELETON, 10),
            Map.entry(EntityType.CREEPER, 15),
            Map.entry(EntityType.HORSE, 20),
            Map.entry(EntityType.WOLF, 15),
            Map.entry(EntityType.ENDERMAN, 20
    )));

    public EntitySummoningStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult use(World world, PlayerEntity player, Hand hand){

        if(this.isBound){
            return TypedActionResult.pass(player.getStackInHand(hand));
        }
        else {
            MinecraftClient client = MinecraftClient.getInstance();
            HitResult hit = client.crosshairTarget;

            switch (hit.getType()) {
                case BLOCK:
                    BlockHitResult blockHit = (BlockHitResult) hit;
                    BlockPos blockPos = blockHit.getBlockPos();
                    if((((PlayerEntityInterface)player).getCurrentSoulCount() > entitySummonMap.get(boundEntity))){
                        ((PlayerEntityInterface)player).decrementSoulCount(entitySummonMap.get(boundEntity));
                        summonEntity(world, blockPos);
                        return TypedActionResult.success(player.getStackInHand(hand));
                    }
                    else {
                        player.sendMessage(new TranslatableText("action.bar.summon.fail"), true);
                }
            }
        }
        return TypedActionResult.pass(player.getStackInHand(hand));
    }

    public void bindEntityToStaff(EntityType<?> entityType){
        this.boundEntity = entityType;
        ItemStack itemStack = this.getDefaultStack();
        NbtCompound display1 = itemStack.getNbt().getCompound("display");
        NbtList lore = new NbtList();
        lore.add(NbtString.of(("Bound Entity: ") + entityType.getName()));
        display1.put("Lore", lore);
    }

    private void summonEntity(World world, BlockPos pos){

        Entity entity = boundEntity.create(world);
        entity.updatePositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);
        world.spawnEntity(entity);
    }
}
