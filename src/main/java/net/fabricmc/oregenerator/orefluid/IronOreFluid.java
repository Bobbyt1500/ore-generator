package net.fabricmc.oregenerator.orefluid;

import net.fabricmc.oregenerator.OreGeneratorAdditions;
import net.fabricmc.oregenerator.OreGeneratorMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;

public class IronOreFluid extends OreFluid{

    public static int tintColor = 1;

    @Override
    public Block getGenerationBlock() {
        return OreGeneratorAdditions.IRON_COBBLE_ORE;
    }

    @Override
    public Fluid getStill() {
        return OreGeneratorAdditions.STILL_IRON_OREFLUID;
    }

    @Override
    public Fluid getFlowing() {
        return OreGeneratorAdditions.FLOWING_IRON_OREFLUID;
    }

    @Override
    public Item getBucketItem() {
        return OreGeneratorAdditions.IRON_OREFLUID_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return OreGeneratorAdditions.IRON_OREFLUID.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return 0;
    }
}
