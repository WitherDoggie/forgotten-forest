package io.github.witherdoggie.forgottenforest.gameplay.ritual;

import com.google.common.collect.ImmutableList;
import io.github.witherdoggie.forgottenforest.block.base.AbstractPedestalBaseBlockEntity;
import io.github.witherdoggie.forgottenforest.item.EntitySummoningStaffItem;
import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import io.github.witherdoggie.forgottenforest.util.pattern.BindingRitualPattern;
import io.github.witherdoggie.forgottenforest.util.pattern.PedestalPattern;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 *
 * Binding Ritual will always require 4 pedestals and thus 4 items to begin.
 *
 **/

public class BindingRitual extends Ritual {

    private EntityType<?> type;
    private PedestalPattern patternToUse;

    private static PedestalPattern COW_PATTERN = new BindingRitualPattern(4, EntityType.COW, create(Items.WHEAT), create(Items.BEEF), create(Items.WHEAT), create(Items.BEEF));
    private static PedestalPattern PIG_PATTERN = new BindingRitualPattern(4, EntityType.PIG, create(Items.CARROT), create(Items.PORKCHOP), create(Items.CARROT), create(Items.PORKCHOP));
    private static PedestalPattern SHEEP_PATTERN = new BindingRitualPattern(4, EntityType.SHEEP, create(Items.WHITE_WOOL), create(Items.MUTTON), create(Items.WHITE_WOOL), create(Items.MUTTON));

    private final ArrayList<PedestalPattern> patternsList = new ArrayList<>(ImmutableList.of(COW_PATTERN, PIG_PATTERN, SHEEP_PATTERN));

    public BindingRitual(){

    }

    @Override
    protected boolean canStart(World world, BlockPos pos) {
        if(arePedestalsPositionsValid(world, pos)){
            return false;
        }
        else {
            for(int i = 0; i < patternsList.size(); i++){
                if(areItemStacksValid(world, pos, patternsList.get(i))){
                    patternToUse = patternsList.get(i);
                    type = ((BindingRitualPattern)patternsList.get(i)).getEntityType();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean arePedestalsPositionsValid(World world, BlockPos pos) {
        Block block = BlockRegistry.RITUAL_PEDESTAL_BLOCK;
        return (checkForBlockAtPosition(world, pos.west(2), block) && checkForBlockAtPosition(world, pos.north(2), block) && checkForBlockAtPosition(world, pos.east(2), block) && checkForBlockAtPosition(world, pos.north(2), block)) ? true : false;
    }

    @Override
    protected boolean areItemStacksValid(World world, BlockPos pos, PedestalPattern pattern) {
        return ((getItemStackFromPedestalAtPosition(world, pos.west(2))) == pattern.get(0) && (getItemStackFromPedestalAtPosition(world, pos.north(2))) == pattern.get(1) && (getItemStackFromPedestalAtPosition(world, pos.east(2))) == pattern.get(2) && (getItemStackFromPedestalAtPosition(world, pos.south(2))) == pattern.get(3)) ? true : false;
    }

    @Override
    public void Start(World world, BlockPos pos) {

        if(canStart(world, pos)){
            return;
        }
        else {
            bind(((AbstractPedestalBaseBlockEntity)(world.getBlockEntity(pos))).getHeldItemStack());
        }
    }

    private void bind(ItemStack stack){
        ((EntitySummoningStaffItem)stack.getItem()).bindEntityToStaff(type);
    }
}
