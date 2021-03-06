package net.fabricmc.oregenerator;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.oregenerator.oreblock.CobbleOre;
import net.fabricmc.oregenerator.oreblock.DiamondCobbleOre;
import net.fabricmc.oregenerator.oreblock.GoldCobbleOre;
import net.fabricmc.oregenerator.oreblock.IronCobbleOre;
import net.fabricmc.oregenerator.orefluid.DiamondOreFluid;
import net.fabricmc.oregenerator.orefluid.GoldOreFluid;
import net.fabricmc.oregenerator.orefluid.IronOreFluid;
import net.fabricmc.oregenerator.orefluid.OreFluid;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.*;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class OreGeneratorAdditions {
    public static FlowableFluid STILL_OREFLUID;
    public static FlowableFluid FLOWING_OREFLUID;
    public static Item OREFLUID_BUCKET;
    public static Block OREFLUID;

    public static FlowableFluid STILL_IRON_OREFLUID;
    public static FlowableFluid FLOWING_IRON_OREFLUID;
    public static Item IRON_OREFLUID_BUCKET;
    public static Block IRON_OREFLUID;

    public static FlowableFluid STILL_GOLD_OREFLUID;
    public static FlowableFluid FLOWING_GOLD_OREFLUID;
    public static Item GOLD_OREFLUID_BUCKET;
    public static Block GOLD_OREFLUID;
    public static FlowableFluid STILL_DIAMOND_OREFLUID;
    public static FlowableFluid FLOWING_DIAMOND_OREFLUID;
    public static Item DIAMOND_OREFLUID_BUCKET;
    public static Block DIAMOND_OREFLUID;

    public static final TagKey<Fluid> ORE_FLUIDS = TagKey.of(Registry.FLUID_KEY, new Identifier("ore-generator", "ore_fluids"));

    public static final CobbleOre COBBLE_ORE = new CobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());
    public static final IronCobbleOre IRON_COBBLE_ORE = new IronCobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());
    public static final GoldCobbleOre GOLD_COBBLE_ORE = new GoldCobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());
    public static final DiamondCobbleOre DIAMOND_COBBLE_ORE = new DiamondCobbleOre(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool());

    public static void initiliazeFluids() {
        Item.Settings bucketSettings = new Item.Settings();
        bucketSettings.group(OreGeneratorMod.ITEM_GROUP);
        bucketSettings.recipeRemainder(Items.BUCKET).maxCount(1);

        STILL_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "orefluid"), new OreFluid.Still());
        FLOWING_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "flowing_orefluid"), new OreFluid.Flowing());
        OREFLUID_BUCKET = Registry.register(Registry.ITEM, new Identifier("ore-generator", "orefluid_bucket"),
                new BucketItem(STILL_OREFLUID, bucketSettings));

        OREFLUID = Registry.register(Registry.BLOCK, new Identifier("ore-generator", "orefluid"),
                new FluidBlock(STILL_OREFLUID, FabricBlockSettings.copy(Blocks.WATER)){});

        // Iron Ore Fluid
        STILL_IRON_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "iron_orefluid"), new IronOreFluid.Still());
        FLOWING_IRON_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "flowing_iron_orefluid"), new IronOreFluid.Flowing());
        IRON_OREFLUID_BUCKET = Registry.register(Registry.ITEM, new Identifier("ore-generator", "iron_orefluid_bucket"),
                new BucketItem(STILL_IRON_OREFLUID, bucketSettings));

        IRON_OREFLUID = Registry.register(Registry.BLOCK, new Identifier("ore-generator", "iron_orefluid"),
                new FluidBlock(STILL_IRON_OREFLUID, FabricBlockSettings.copy(Blocks.WATER)){});

        // Gold Ore Fluid
        STILL_GOLD_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "gold_orefluid"), new GoldOreFluid.Still());
        FLOWING_GOLD_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "flowing_gold_orefluid"), new GoldOreFluid.Flowing());
        GOLD_OREFLUID_BUCKET = Registry.register(Registry.ITEM, new Identifier("ore-generator", "gold_orefluid_bucket"),
                new BucketItem(STILL_GOLD_OREFLUID, bucketSettings));
        GOLD_OREFLUID = Registry.register(Registry.BLOCK, new Identifier("ore-generator", "gold_orefluid"),
                new FluidBlock(STILL_GOLD_OREFLUID, FabricBlockSettings.copy(Blocks.WATER)){});

        // Diamond Ore Fluid
        STILL_DIAMOND_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "diamond_orefluid"), new DiamondOreFluid.Still());
        FLOWING_DIAMOND_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "flowing_diamond_orefluid"), new DiamondOreFluid.Flowing());
        DIAMOND_OREFLUID_BUCKET = Registry.register(Registry.ITEM, new Identifier("ore-generator", "diamond_orefluid_bucket"),
                new BucketItem(STILL_DIAMOND_OREFLUID, bucketSettings));

        DIAMOND_OREFLUID = Registry.register(Registry.BLOCK, new Identifier("ore-generator", "diamond_orefluid"),
                new FluidBlock(STILL_DIAMOND_OREFLUID, FabricBlockSettings.copy(Blocks.WATER)){});
    }

    public static void initiliazeBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "cobble_ore"), COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "cobble_ore"),
                new BlockItem(COBBLE_ORE, new Item.Settings().group(OreGeneratorMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "iron_cobble_ore"), IRON_COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "iron_cobble_ore"),
                new BlockItem(IRON_COBBLE_ORE, new Item.Settings().group(OreGeneratorMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "gold_cobble_ore"), GOLD_COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "gold_cobble_ore"),
                new BlockItem(GOLD_COBBLE_ORE, new Item.Settings().group(OreGeneratorMod.ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("ore-generator", "diamond_cobble_ore"), DIAMOND_COBBLE_ORE);
        Registry.register(Registry.ITEM, new Identifier("ore-generator", "diamond_cobble_ore"),
                new BlockItem(DIAMOND_COBBLE_ORE, new Item.Settings().group(OreGeneratorMod.ITEM_GROUP)));
    }
}