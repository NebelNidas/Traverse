package com.terraformersmc.traverse;

import com.terraformersmc.terraform.config.BiomeConfigHandler;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.item.TraverseBoats;
import com.terraformersmc.traverse.village.TraverseVillagerTypes;
import com.terraformersmc.traverse.world.biome.TraverseBiomes;
import com.terraformersmc.traverse.world.gen.TraverseGeneration;
import com.terraformersmc.traverse.world.gen.surfacebuilder.TraverseSurfaceBuilders;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Traverse implements ModInitializer {

	public static final String MOD_ID = "traverse";
	public static ItemGroup itemGroup;
	public static final BiomeConfigHandler BIOME_CONFIG_HANDLER = new BiomeConfigHandler(MOD_ID);

	private static void register() {
		TraverseBlocks.register();
		TraverseBoats.register();
		TraverseSurfaceBuilders.register();
		TraverseBiomes.register();
		TraverseGeneration.register();
		TraverseVillagerTypes.register();

		itemGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "items"), () -> new ItemStack(TraverseBoats.FIR_BOAT));
	}

	@Override
	public void onInitialize() {
		register();
	}

}
