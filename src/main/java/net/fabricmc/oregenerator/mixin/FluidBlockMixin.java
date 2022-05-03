package net.fabricmc.oregenerator.mixin;

import com.google.common.collect.UnmodifiableIterator;
import net.fabricmc.oregenerator.OreGeneratorMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.FluidDrainable;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public abstract class FluidBlockMixin extends Block implements FluidDrainable {

    @Shadow
    protected final FlowableFluid fluid;

    public FluidBlockMixin(FlowableFluid fluid, Settings settings) {
        super(settings);
        this.fluid = fluid;
    }

    @Inject(method = "receiveNeighborFluids", at = @At("HEAD"), cancellable = true)
    public void onUpdate(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> ci){
        if (this.fluid.isIn(FluidTags.LAVA)) {

            OreGeneratorMod.LOGGER.info(pos.toString());

            // Get iterator of available flow direcitons
            UnmodifiableIterator directions = FluidBlock.FLOW_DIRECTIONS.iterator();

            // Check the block of each direction
            while(directions.hasNext()) {
                Direction dir = (Direction) directions.next();
                BlockPos blockPos = pos.offset(dir.getOpposite());
                BlockState blockState = world.getBlockState(blockPos);

                // If this lava collides with an orefluids fluids, place block
                if (blockState.getFluidState().isIn(OreGeneratorMod.ORE_FLUIDS)) {
                    world.setBlockState(pos, OreGeneratorMod.IRON_COBBLE_ORE.getDefaultState());

                }

            }

        }
    }
}
