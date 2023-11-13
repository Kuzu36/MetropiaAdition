package net.metropia.addition.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import net.metropia.addition.MetropiaadditionMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class FireAuraFlowerQuandLeMobjoueurEntreEnCollisionAvecLaPlanteProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MetropiaadditionMod.LOGGER
						.warn("Failed to load dependency world for procedure FireAuraFlowerQuandLeMobjoueurEntreEnCollisionAvecLaPlante!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MetropiaadditionMod.LOGGER
						.warn("Failed to load dependency x for procedure FireAuraFlowerQuandLeMobjoueurEntreEnCollisionAvecLaPlante!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MetropiaadditionMod.LOGGER
						.warn("Failed to load dependency y for procedure FireAuraFlowerQuandLeMobjoueurEntreEnCollisionAvecLaPlante!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MetropiaadditionMod.LOGGER
						.warn("Failed to load dependency z for procedure FireAuraFlowerQuandLeMobjoueurEntreEnCollisionAvecLaPlante!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				entityiterator.setFire((int) 2);
				if (world instanceof World && !world.isRemote()) {
					((World) world)
							.playSound(null, new BlockPos(x, y, z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("block.blastfurnace.fire_crackle")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("block.blastfurnace.fire_crackle")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, x, y, z, (int) 2, 3, 3, 3, 1);
				}
			}
		}
	}
}
