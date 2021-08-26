package io.github.witherdoggie.forgottenforest.block.base;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractPedestalBaseBlock extends BlockWithEntity {

    protected AbstractPedestalBaseBlock(Settings settings) {
        super(settings);
    }

    public abstract BlockEntity createBlockEntity(BlockPos pos, BlockState state);

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        AbstractPedestalBaseBlockEntity blockEntity = (AbstractPedestalBaseBlockEntity) world.getBlockEntity(pos);

        if(blockEntity.getHeldItemStack().isEmpty() == true && player.getStackInHand(hand).isEmpty() == false) {
            blockEntity.addItemToPedestal(player, hand);
            return ActionResult.SUCCESS;
        }
        else if (player.getStackInHand(hand).isEmpty() == true && blockEntity.getHeldItemStack().isEmpty() == false){
            blockEntity.removeItemFromPedestal(player, hand);
            return ActionResult.CONSUME;
        }

        return ActionResult.PASS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        AbstractPedestalBaseBlockEntity blockEntity = (AbstractPedestalBaseBlockEntity) world.getBlockEntity(pos);
        dropStack(world, pos, blockEntity.getHeldItemStack());
    }
}
