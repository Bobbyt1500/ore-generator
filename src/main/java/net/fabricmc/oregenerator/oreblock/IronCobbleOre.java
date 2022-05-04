package net.fabricmc.oregenerator.oreblock;

import net.fabricmc.oregenerator.oreblock.CobbleOre;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronCobbleOre extends CobbleOre
{
    public IronCobbleOre(Settings settings)
    {
        super(settings);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
    }
}