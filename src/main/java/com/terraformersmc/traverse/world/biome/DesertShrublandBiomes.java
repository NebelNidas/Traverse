package com.terraformersmc.traverse.world.biome;

import com.terraformersmc.terraform.biomebuilder.DefaultFeature;
import com.terraformersmc.traverse.world.gen.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.world.gen.feature.TraverseFeatureConfigs;
import com.terraformersmc.traverse.world.gen.surfacebuilder.TraverseSurfaceBuilders;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class DesertShrublandBiomes {
	static final Biome DESERT_SHRUBLAND = TraverseBiomes.BIOME_TEMPLATE.builder()
			.configureSurfaceBuilder(TraverseSurfaceBuilders.DESERT_SHRUBLAND, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(DefaultFeature.DESERT_LAKES, DefaultFeature.DESERT_DEAD_BUSHES, DefaultFeature.DESERT_VEGETATION, DefaultFeature.DESERT_FEATURES, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.DEFAULT_GRASS)
			.addStructureFeature(ConfiguredStructureFeatures.VILLAGE_DESERT)
			.addStructureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_DESERT)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseConfiguredFeatures.DESERT_SHRUBS)
			.precipitation(Biome.Precipitation.NONE)
			.addDefaultAmbientSpawnEntries()
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 19, 4, 4))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1))

			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.HUSK, 80, 4, 4))
			.category(Biome.Category.DESERT)
			.depth(0.125F)
			.scale(0.125F)
			.temperature(2.0F)
			.downfall(0.0F)
			.playerSpawnFriendly()
			.build();
}
