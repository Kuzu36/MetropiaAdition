package net.metropia.addition.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.metropia.addition.potion.EuphoriaEffectPotionEffect;
import net.metropia.addition.MetropiaadditionMod;

import java.util.Map;
import java.util.Collection;

public class EuphoriaOverlayAfficherLoverlayEnJeuProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MetropiaadditionMod.LOGGER.warn("Failed to load dependency entity for procedure EuphoriaOverlayAfficherLoverlayEnJeu!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == EuphoriaEffectPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity);
	}
}
