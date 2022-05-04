package net.fabricmc.oregenerator;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.oregenerator.oreblock.CobbleOre;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OreGeneratorAdditions {
    public static final CobbleOre COBBLE_ORE = new CobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());

    public static void initiliaze() {
        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "cobble_ore"), COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "cobble_ore"),
                new BlockItem(COBBLE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
