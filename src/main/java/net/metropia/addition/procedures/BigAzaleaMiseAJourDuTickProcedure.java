package net.metropia.addition.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.metropia.addition.potion.EuphoriaEffectPotionEffect;
import net.metropia.addition.particle.EuphoriaParticle;
import net.metropia.addition.MetropiaadditionMod;

import java.util.Map;

public class BigAzaleaMiseAJourDuTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency world for procedure BigAzaleaMiseAJourDuTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency x for procedure BigAzaleaMiseAJourDuTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency y for procedure BigAzaleaMiseAJourDuTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency z for procedure BigAzaleaMiseAJourDuTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency entity for procedure BigAzaleaMiseAJourDuTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(EuphoriaParticle.particle, x, y, z, (int) 3, 3, 3, 3, 0.1);
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(EuphoriaEffectPotionEffect.potion, (int) 600, (int) 1));
	}
}
