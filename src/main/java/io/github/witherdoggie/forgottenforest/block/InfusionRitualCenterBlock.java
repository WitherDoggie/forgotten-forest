package io.github.witherdoggie.forgottenforest.block;

import io.github.witherdoggie.forgottenforest.block.base.AbstractPedestalBaseBlock;
import io.github.witherdoggie.forgottenforest.block.base.AbstractPedestalBaseBlockEntity;
import io.github.witherdoggie.forgottenforest.gameplay.ritual.BindingRitual;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import io.github.witherdoggie.forgottenforest.util.enums.PedestalMode;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class InfusionRitualCenterBlock extends AbstractPedestalBaseBlock {

    PedestalMode mode = PedestalMode.BIND;

    public InfusionRitualCenterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){

        if(mode == PedestalMode.BIND){
            BindingRitual ritual = new BindingRitual();
            ritual.Start(world, pos);
        }
        return ActionResult.CONSUME;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;//new InfusionRitualCenterBlockEntity(pos, state);
    }

    private void cyclePedestalMode(){
        if(mode == PedestalMode.BIND){
            mode = PedestalMode.SUMMON;
        }
        else if(mode == PedestalMode.SUMMON){
            mode = PedestalMode.BIND;
        }
    }
}
