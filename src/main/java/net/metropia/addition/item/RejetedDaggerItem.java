
package net.metropia.addition.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.metropia.addition.itemgroup.MetropiaWeaponItemGroup;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class RejetedDaggerItem extends MetropiaadditionModElements.ModElement {
	@ObjectHolder("metropiaaddition:rejeted_dagger")
	public static final Item block = null;

	public RejetedDaggerItem(MetropiaadditionModElements instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 750;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2f, new Item.Properties().group(MetropiaWeaponItemGroup.tab)) {
		}.setRegistryName("rejeted_dagger"));
	}
}
