package net.fabricmc.oregenerator;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class OreGeneratorModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Render Fluid Renderer
        FluidRenderHandlerRegistry.INSTANCE.register(OreGeneratorMod.STILL_OREFLUID, OreGeneratorMod.FLOWING_OREFLUID, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0xd3e8ed
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), OreGeneratorMod.STILL_OREFLUID, OreGeneratorMod.FLOWING_OREFLUID);
    }
}
