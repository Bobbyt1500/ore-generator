package net.fabricmc.oregenerator;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.oregenerator.orefluid.IronOreFluid;
import net.fabricmc.oregenerator.orefluid.OreFluid;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class OreGeneratorModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Render Fluid Renderer
        FluidRenderHandlerRegistry.INSTANCE.register(OreGeneratorAdditions.STILL_OREFLUID, OreGeneratorAdditions.FLOWING_OREFLUID, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                OreFluid.tintColor
        ));

        // Render Fluid Renderer
        FluidRenderHandlerRegistry.INSTANCE.register(OreGeneratorAdditions.STILL_IRON_OREFLUID, OreGeneratorAdditions.FLOWING_IRON_OREFLUID, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                IronOreFluid.tintColor
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), OreGeneratorAdditions.STILL_OREFLUID, OreGeneratorAdditions.FLOWING_OREFLUID);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), OreGeneratorAdditions.STILL_IRON_OREFLUID, OreGeneratorAdditions.FLOWING_IRON_OREFLUID);
    }
}
