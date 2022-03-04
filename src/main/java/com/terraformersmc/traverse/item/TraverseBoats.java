package com.terraformersmc.traverse.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.terraform.boat.impl.item.TerraformBoatItem;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TraverseBoats {
	public static TerraformBoatType FIR_BOAT_TYPE;

	public static TerraformBoatItem FIR_BOAT;


	public static void register() {
		FIR_BOAT = (TerraformBoatItem) TerraformBoatItemHelper.registerBoatItem(new Identifier(Traverse.MOD_ID, "fir_boat"), () -> FIR_BOAT_TYPE, Traverse.itemGroup);

		FIR_BOAT_TYPE = new TerraformBoatType.Builder().item(FIR_BOAT).build();

		Registry.register(TerraformBoatTypeRegistry.INSTANCE, new Identifier(Traverse.MOD_ID, "fir"), FIR_BOAT_TYPE);
	}
}
