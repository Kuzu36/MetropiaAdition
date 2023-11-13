
package net.metropia.addition.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.metropia.addition.item.LittleLeatherItem;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class MetropiaHandcraftItemGroup extends MetropiaadditionModElements.ModElement {
	public MetropiaHandcraftItemGroup(MetropiaadditionModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmetropia_handcraft") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LittleLeatherItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
