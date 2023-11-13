
package net.metropia.addition.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.metropia.addition.item.PlatiniumCoinItem;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class MetropiaEconomyItemGroup extends MetropiaadditionModElements.ModElement {
	public MetropiaEconomyItemGroup(MetropiaadditionModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmetropia_economy") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PlatiniumCoinItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
