package io.github.witherdoggie.forgottenforest.block.fluid;

import io.github.witherdoggie.forgottenforest.registry.BlockRegistry;
import io.github.witherdoggie.forgottenforest.registry.ItemRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public class PoisonWaterFluid extends ModFluid {

    @Override
    public Fluid getFlowing() {
        return BlockRegistry.FLOWING_POISON_WATER;
    }

    @Override
    public Fluid getStill() {
        return BlockRegistry.STILL_POISON_WATER;
    }

    @Override
    public Item getBucketItem() {
        return ItemRegistry.POISON_WATER_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return BlockRegistry.POISON_WATER.getDefaultState().with(Properties.LEVEL_15, method_15741(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }

    public static class Flowing extends PoisonWaterFluid {

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends PoisonWaterFluid {

        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
