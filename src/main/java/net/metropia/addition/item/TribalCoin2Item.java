
package net.metropia.addition.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.metropia.addition.itemgroup.MetropiaEconomyItemGroup;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class TribalCoin2Item extends MetropiaadditionModElements.ModElement {
	@ObjectHolder("metropiaaddition:tribal_coin_2")
	public static final Item block = null;

	public TribalCoin2Item(MetropiaadditionModElements instance) {
		super(instance, 69);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MetropiaEconomyItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("tribal_coin_2");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
