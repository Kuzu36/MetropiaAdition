
package net.metropia.addition.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.metropia.addition.block.AmethystClusterMidBlock;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class MetropiaDepthItemGroup extends MetropiaadditionModElements.ModElement {
	public MetropiaDepthItemGroup(MetropiaadditionModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmetropia_depth") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AmethystClusterMidBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
