package net.fabricmc.oregenerator.orefluid;

import net.fabricmc.oregenerator.OreGeneratorAdditions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public class DiamondOreFluid extends OreFluid {

    @Override
    public Block getGenerationBlock() {
        return OreGeneratorAdditions.DIAMOND_COBBLE_ORE;
    }

    @Override
    public Fluid getStill() {
        return OreGeneratorAdditions.STILL_DIAMOND_OREFLUID;
    }

    @Override
    public Fluid getFlowing() {
        return OreGeneratorAdditions.FLOWING_DIAMOND_OREFLUID;
    }

    @Override
    public Item getBucketItem() {
        return OreGeneratorAdditions.DIAMOND_OREFLUID_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return OreGeneratorAdditions.DIAMOND_OREFLUID.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }

    public static class Flowing extends DiamondOreFluid {
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

    public static class Still extends DiamondOreFluid {
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
