package net.metropia.addition.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;

import net.metropia.addition.particle.EuphoriaParticle;
import net.metropia.addition.MetropiaadditionMod;

import java.util.Map;

public class EuphoriaEffectTickActifSurEffetProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency world for procedure EuphoriaEffectTickActifSurEffet!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency x for procedure EuphoriaEffectTickActifSurEffet!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency y for procedure EuphoriaEffectTickActifSurEffet!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency z for procedure EuphoriaEffectTickActifSurEffet!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(EuphoriaParticle.particle, x, y, z, (int) 1, 2, 2, 2, 0.1);
		}
		if (world instanceof World) {
			if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos(x, y - 0, z))
					|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos(x, y - 0, z), (Direction) null)) {
				if (!world.isRemote())
					((World) world).playEvent(2005, new BlockPos(x, y - 0, z), 0);
			}
		}
	}
}
