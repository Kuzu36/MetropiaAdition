
package net.metropia.addition.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.metropia.addition.itemgroup.MetropiaWeaponItemGroup;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class SabreAcierNoirItem extends MetropiaadditionModElements.ModElement {
	@ObjectHolder("metropiaaddition:black_steel_saber")
	public static final Item block = null;

	public SabreAcierNoirItem(MetropiaadditionModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 4.5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.3f, new Item.Properties().group(MetropiaWeaponItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("black_steel_saber"));
	}
}
