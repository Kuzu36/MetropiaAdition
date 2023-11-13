
package net.metropia.addition.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.metropia.addition.item.MagicPowderItem;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class MetropiaMagicItemGroup extends MetropiaadditionModElements.ModElement {
	public MetropiaMagicItemGroup(MetropiaadditionModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmetropia_magic") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MagicPowderItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
