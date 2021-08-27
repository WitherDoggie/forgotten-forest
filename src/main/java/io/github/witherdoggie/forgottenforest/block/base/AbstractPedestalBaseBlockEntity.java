package io.github.witherdoggie.forgottenforest.block.base;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

public abstract class AbstractPedestalBaseBlockEntity extends BlockEntity implements BlockEntityClientSerializable {

    protected ItemStack containedItem = ItemStack.EMPTY;

    public AbstractPedestalBaseBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public ItemStack getHeldItemStack() {
        return containedItem;
    }

    public void setHeldItemStack(ItemStack stack) {
        if (!stack.isEmpty()) {
            stack = stack.copy();
            stack.setCount(1);
        }

        this.containedItem = stack;
    }

    public ActionResult addItemToPedestal(PlayerEntity player, Hand hand){
        ItemStack playerStackInHand = player.getStackInHand(hand);
        boolean isStackEmpty = !this.getHeldItemStack().isEmpty();
        boolean isPlayerStackEmpty = !playerStackInHand.isEmpty();
        if (!this.world.isClient) {
            if (!isStackEmpty) {
                if (isPlayerStackEmpty && !this.isRemoved()) {

                    this.setHeldItemStack(playerStackInHand);
                    if (!player.getAbilities().creativeMode) {
                        playerStackInHand.decrement(1);
                    }
                }
            }
            this.sync();
            System.out.println("HASH AT ADD: " + this.hashCode());
            return ActionResult.CONSUME;
        } else {
            return !isStackEmpty && !isPlayerStackEmpty ? ActionResult.PASS : ActionResult.SUCCESS;
        }
    }

    public void removeItemFromPedestal(PlayerEntity player, Hand hand) {

        if(!this.world.isClient) {
            if (containedItem.isEmpty() == false) {
                player.setStackInHand(Hand.MAIN_HAND, this.getHeldItemStack());
                this.setHeldItemStack(ItemStack.EMPTY);
            }
            this.sync();
        }
    }

   @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        NbtCompound nbtCompound = nbt.getCompound("Item");
        if (nbtCompound != null && !nbtCompound.isEmpty()) {
            ItemStack itemStack = ItemStack.fromNbt(nbtCompound);
            this.setHeldItemStack(itemStack);
        }
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        if (!this.getHeldItemStack().isEmpty()) {
            nbt.put("Item", this.getHeldItemStack().writeNbt(new NbtCompound()));
            markDirty();
        }
        return super.writeNbt(nbt);
    }

    @Override
    public void fromClientTag(NbtCompound nbt){
        NbtCompound nbtCompound = nbt.getCompound("Item");
        if (nbtCompound != null && !nbtCompound.isEmpty()) {
            ItemStack itemStack = ItemStack.fromNbt(nbtCompound);
            this.setHeldItemStack(itemStack);
        }
    }

    @Override
    public NbtCompound toClientTag(NbtCompound nbt){
        nbt.put("Item", this.getHeldItemStack().writeNbt(new NbtCompound()));
        this.markDirty();

        return nbt;
    }
}