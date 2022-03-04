package com.terraformersmc.traverse.world.biome;

import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.TerraformBiomeBuilder;
import com.terraformersmc.terraform.biomebuilder.TerraformSlimeSpawnBiomes;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.HashMap;
import java.util.Map;

import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.*;

public class TraverseBiomes {

	private static int getSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = MathHelper.clamp(f, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}

	private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

	static final BiomeTemplate BIOME_TEMPLATE = new BiomeTemplate(TerraformBiomeBuilder.create()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
			.addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD)
			.addStructureFeature(ConfiguredStructureFeatures.MINESHAFT)
			.precipitation(Biome.Precipitation.RAIN)
			.effects(createDefaultBiomeEffects()));

	public static BiomeEffects.Builder createDefaultBiomeEffects() {
		return new BiomeEffects.Builder()
				.waterColor(0x3F76E4)
				.waterFogColor(0x50533)
				.skyColor(getSkyColor(0.2F))
				.fogColor(0xC0D8FF);
	}

	protected static final RegistryKey<Biome> ARID_HIGHLANDS = add("arid_highlands", AridHighlandsBiomes.ARID_HIGHLANDS);
	protected static final RegistryKey<Biome> AUTUMNAL_WOODS = add("autumnal_woods", AutumnalWoodsBiomes.AUTUMNAL_WOODS);
	protected static final RegistryKey<Biome> AUTUMNAL_WOODED_HILLS = add("autumnal_wooded_hills", AutumnalWoodsBiomes.AUTUMNAL_WOODED_HILLS);
	protected static final RegistryKey<Biome> CLIFFS = add("cliffs", CliffsBiomes.CLIFFS);
	protected static final RegistryKey<Biome> CONIFEROUS_FOREST = add("coniferous_forest", ConiferousForestBiomes.CONIFEROUS_FOREST);
	protected static final RegistryKey<Biome> CONIFEROUS_WOODED_HILLS = add("coniferous_wooded_hills", ConiferousForestBiomes.CONIFEROUS_WOOODED_HILLS);
	protected static final RegistryKey<Biome> DESERT_SHRUBLAND = add("desert_shrubland", DesertShrublandBiomes.DESERT_SHRUBLAND);
	protected static final RegistryKey<Biome> HIGH_CONIFEROUS_FOREST = add("high_coniferous_forest", ConiferousForestBiomes.HIGH_CONIFEROUS_FOREST);
	protected static final RegistryKey<Biome> LUSH_SWAMP = add("lush_swamp", LushSwampBiomes.LUSH_SWAMP);
	protected static final RegistryKey<Biome> MEADOW = add("meadow", MeadowBiomes.MEADOW);
	protected static final RegistryKey<Biome> MINI_JUNGLE = add("mini_jungle", MiniJungleBiomes.MINI_JUNGLE);
	protected static final RegistryKey<Biome> PLAINS_PLATEAU = add("plains_plateau", PlainsPlateauBiomes.PLAINS_PLATEAU);
	protected static final RegistryKey<Biome> ROCKY_EDGE = add("rocky_edge", PlainsPlateauBiomes.ROCKY_EDGE);
	protected static final RegistryKey<Biome> ROLLING_HILLS = add("rolling_hills", RollingHillsBiomes.ROLLING_HILLS);
	protected static final RegistryKey<Biome> SNOWY_CLIFFS = add("snowy_cliffs", CliffsBiomes.SNOWY_CLIFFS);
	protected static final RegistryKey<Biome> SNOWY_CONIFEROUS_FOREST = add("snowy_coniferous_forest", ConiferousForestBiomes.SNOWY_CONIFEROUS_FOREST);
	protected static final RegistryKey<Biome> SNOWY_CONIFEROUS_WOODED_HILLS = add("snowy_coniferous_wooded_hills", ConiferousForestBiomes.SNOWY_CONIFEROUS_WOOODED_HILLS);
	protected static final RegistryKey<Biome> SNOWY_HIGH_CONIFEROUS_FOREST = add("snowy_high_coniferous_forest", ConiferousForestBiomes.SNOWY_HIGH_CONIFEROUS_FOREST);
	protected static final RegistryKey<Biome> WOODED_ISLAND = add("wooded_island", WoodedIslandBiomes.WOODED_ISLAND);
	protected static final RegistryKey<Biome> WOODED_PLATEAU = add("wooded_plateau", PlainsPlateauBiomes.WOODED_PLATEAU);
	protected static final RegistryKey<Biome> WOODLANDS = add("woodlands", WoodlandsBiomes.WOODLANDS);

	static RegistryKey<Biome> add(String name, Biome biome) {
		Identifier id = new Identifier(Traverse.MOD_ID, name);
		BIOMES.put(id, biome);
		return RegistryKey.of(Registry.BIOME_KEY, id);
	}

	public static void register() {
		for (Identifier id : BIOMES.keySet()) {
			BuiltinRegistries.add(BuiltinRegistries.BIOME, id, BIOMES.get(id));
		}

		TerraformSlimeSpawnBiomes.addSlimeSpawnBiome(LUSH_SWAMP);
	}

}
