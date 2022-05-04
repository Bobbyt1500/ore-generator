package net.fabricmc.oregenerator;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.oregenerator.oreblock.CobbleOre;
import net.fabricmc.oregenerator.oreblock.DiamondCobbleOre;
import net.fabricmc.oregenerator.oreblock.GoldCobbleOre;
import net.fabricmc.oregenerator.oreblock.IronCobbleOre;
import net.fabricmc.oregenerator.orefluid.IronOreFluid;
import net.fabricmc.oregenerator.orefluid.OreFluid;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OreGeneratorMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("ore-generator");

	// Create Fluids
	public static FlowableFluid STILL_OREFLUID;
	public static FlowableFluid FLOWING_OREFLUID;
	public static Item OREFLUID_BUCKET;
	public static Block OREFLUID;

	public static FlowableFluid STILL_IRON_OREFLUID;
	public static FlowableFluid FLOWING_IRON_OREFLUID;
	public static Item IRON_OREFLUID_BUCKET;
	public static Block IRON_OREFLUID;

	public static final TagKey<Fluid> ORE_FLUIDS = TagKey.of(Registry.FLUID_KEY, new Identifier("ore-generator", "ore_fluids"));

	// Create Ore Blocks

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		OreGeneratorAdditions.initiliazeBlocks();

		// Registering Fluid
		STILL_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "orefluid"), new OreFluid.Still());
		FLOWING_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "flowing_orefluid"), new OreFluid.Flowing());
		OREFLUID_BUCKET = Registry.register(Registry.ITEM, new Identifier("ore-generator", "orefluid_bucket"),
				new BucketItem(STILL_OREFLUID, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

		OREFLUID = Registry.register(Registry.BLOCK, new Identifier("ore-generator", "orefluid"),
				new FluidBlock(STILL_OREFLUID, FabricBlockSettings.copy(Blocks.WATER)){});

		// Iron Ore Fluid
		STILL_IRON_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "iron_orefluid"), new IronOreFluid.Still());
		FLOWING_IRON_OREFLUID = Registry.register(Registry.FLUID, new Identifier("ore-generator", "flowing_iron_orefluid"), new IronOreFluid.Flowing());
		IRON_OREFLUID_BUCKET = Registry.register(Registry.ITEM, new Identifier("ore-generator", "iron_orefluid_bucket"),
				new BucketItem(STILL_IRON_OREFLUID, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

		IRON_OREFLUID = Registry.register(Registry.BLOCK, new Identifier("ore-generator", "iron_orefluid"),
				new FluidBlock(STILL_IRON_OREFLUID, FabricBlockSettings.copy(Blocks.WATER)){});

	}
}
