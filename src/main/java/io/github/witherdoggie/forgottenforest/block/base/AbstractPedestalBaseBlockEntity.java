package io.github.witherdoggie.forgottenforest.block.base;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.map.MapState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPedestalBaseBlockEntity extends BlockEntity implements BlockEntityClientSerializable {

    protected ItemStack containedItem = ItemStack.EMPTY;

    public AbstractPedestalBaseBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public ItemStack getHeldItemStack() {
        return containedItem;
    }

    public void setHeldItemStack(ItemStack stack) {
        this.setHeldItemStack(stack, true);
    }

    public void setHeldItemStack(ItemStack value, boolean update) {
        if (!value.isEmpty()) {
            value = value.copy();
            value.setCount(1);
        }

        this.containedItem = value;
    }

    public ActionResult addItemToPedestal(PlayerEntity player, Hand hand){
        ItemStack itemStack = player.getStackInHand(hand);
        boolean isStackEmpty = !this.getHeldItemStack().isEmpty();
        boolean bl2 = !itemStack.isEmpty();
        if (!this.world.isClient) {
            if (!isStackEmpty) {
                if (bl2 && !this.isRemoved()) {

                    this.setHeldItemStack(itemStack);
                    if (!player.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                    }
                }
            }
            this.sync();
            return ActionResult.CONSUME;
        } else {
            return !isStackEmpty && !bl2 ? ActionResult.PASS : ActionResult.SUCCESS;
        }
    }

    public ActionResult removeStack(PlayerEntity player, Hand hand) {

        if(!this.world.isClient) {
            if (containedItem.isEmpty() == false) {
                player.setStackInHand(hand, this.getHeldItemStack());
                this.setHeldItemStack(ItemStack.EMPTY, true);
            }
            this.sync();
            return ActionResult.CONSUME;
        }
        return ActionResult.PASS;
    }

   @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        NbtCompound nbtCompound = nbt.getCompound("Item");
        if (nbtCompound != null && !nbtCompound.isEmpty()) {
            ItemStack itemStack = ItemStack.fromNbt(nbtCompound);
            this.setHeldItemStack(itemStack, false);
        }
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        if (!this.getHeldItemStack().isEmpty()) {
            nbt.put("Item", this.getHeldItemStack().writeNbt(new NbtCompound()));
        }
        return super.writeNbt(nbt);
    }

    @Override
    public void fromClientTag(NbtCompound nbt){
        NbtCompound nbtCompound = nbt.getCompound("Item");
        if (nbtCompound != null && !nbtCompound.isEmpty()) {
            ItemStack itemStack = ItemStack.fromNbt(nbtCompound);
            this.setHeldItemStack(itemStack, false);
        }
    }

    @Override
    public NbtCompound toClientTag(NbtCompound nbt){
        if (!this.getHeldItemStack().isEmpty()) {
            nbt.put("Item", this.getHeldItemStack().writeNbt(new NbtCompound()));
        }
        return nbt;
    }
}