package net.fabricmc.oregenerator;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.oregenerator.oreblock.CobbleOre;
import net.fabricmc.oregenerator.oreblock.DiamondCobbleOre;
import net.fabricmc.oregenerator.oreblock.GoldCobbleOre;
import net.fabricmc.oregenerator.oreblock.IronCobbleOre;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OreGeneratorAdditions {
    public static final CobbleOre COBBLE_ORE = new CobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());
    public static final IronCobbleOre IRON_COBBLE_ORE = new IronCobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());
    public static final GoldCobbleOre GOLD_COBBLE_ORE = new GoldCobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());
    public static final DiamondCobbleOre DIAMOND_COBBLE_ORE = new DiamondCobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());

    public static void initiliazeBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "cobble_ore"), COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "cobble_ore"),
                new BlockItem(COBBLE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "iron_cobble_ore"), IRON_COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "iron_cobble_ore"),
                new BlockItem(IRON_COBBLE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "gold_cobble_ore"), GOLD_COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "gold_cobble_ore"),
                new BlockItem(GOLD_COBBLE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "diamond_cobble_ore"), DIAMOND_COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "diamond_cobble_ore"),
                new BlockItem(DIAMOND_COBBLE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
