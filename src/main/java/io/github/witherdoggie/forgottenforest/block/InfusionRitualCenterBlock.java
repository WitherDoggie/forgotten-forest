package io.github.witherdoggie.forgottenforest.block;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class InfusionRitualCenterBlock extends BlockWithEntity {

    public InfusionRitualCenterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(checkForValidSetup(world, pos) == true){
            beginRitual();
        }

        return null;
    }

    private boolean checkForValidSetup(World world, BlockPos centerPos){

        if(world.getBlockState(centerPos.west(2)).getBlock() == BlockRegistry.GLOOMY_STONE && world.getBlockState(centerPos.north(2)).getBlock() == BlockRegistry.GLOOMY_STONE && world.getBlockState(centerPos.east(2)).getBlock() == BlockRegistry.GLOOMY_STONE && world.getBlockState(centerPos.south(2)).getBlock() == BlockRegistry.GLOOMY_STONE){
            return true;
        }
        else {
            return false;
        }
    }

    private void beginRitual(){


    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
