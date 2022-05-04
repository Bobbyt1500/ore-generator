package net.fabricmc.oregenerator;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OreGeneratorMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("ore-generator");

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("ore-generator", "general"),
			() -> new ItemStack(OreGeneratorAdditions.COBBLE_ORE));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		OreGeneratorAdditions.initiliazeBlocks();
		OreGeneratorAdditions.initiliazeFluids();

	}
}
