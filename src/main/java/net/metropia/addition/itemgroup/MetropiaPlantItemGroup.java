
package net.metropia.addition.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.metropia.addition.block.BigAzaleaBlock;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class MetropiaPlantItemGroup extends MetropiaadditionModElements.ModElement {
	public MetropiaPlantItemGroup(MetropiaadditionModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmetropia_plant") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BigAzaleaBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
