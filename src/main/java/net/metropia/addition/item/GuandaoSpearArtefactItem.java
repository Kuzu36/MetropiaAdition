
package net.metropia.addition.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.metropia.addition.itemgroup.MetropiaWeaponItemGroup;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class GuandaoSpearArtefactItem extends MetropiaadditionModElements.ModElement {
	@ObjectHolder("metropiaaddition:guandao_spear_artefact")
	public static final Item block = null;

	public GuandaoSpearArtefactItem(MetropiaadditionModElements instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
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
		}, 3, -3f, new Item.Properties().group(MetropiaWeaponItemGroup.tab)) {
		}.setRegistryName("guandao_spear_artefact"));
	}
}
