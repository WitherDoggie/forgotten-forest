package io.github.witherdoggie.forgottenforest.gameplay.ritual;

import io.github.witherdoggie.forgottenforest.block.base.AbstractPedestalBaseBlockEntity;
import io.github.witherdoggie.forgottenforest.util.pattern.PedestalPattern;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class Ritual {

    protected boolean canStart = false;

    public Ritual(){}

    protected abstract boolean canStart(World world, BlockPos pos);

    protected abstract boolean arePedestalsPositionsValid(World world, BlockPos pos);

    protected abstract boolean areItemStacksValid(World world, BlockPos pos, PedestalPattern pattern);

    public abstract void Start(World world, BlockPos pos);

    protected boolean checkForBlockAtPosition(World world, BlockPos pos, Block block){
        return world.getBlockState(pos).isOf(block) ? true : false;
    }

    protected ItemStack getItemStackFromPedestalAtPosition(World world, BlockPos pos){
        AbstractPedestalBaseBlockEntity blockEntity = (AbstractPedestalBaseBlockEntity) world.getBlockEntity(pos);
        return blockEntity.getHeldItemStack();
    }

    protected static ItemStack create(Item item){
        return new ItemStack(item);
    }
}
