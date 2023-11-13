
package net.metropia.addition.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.metropia.addition.itemgroup.MetropiaMagicItemGroup;
import net.metropia.addition.MetropiaadditionModElements;

@MetropiaadditionModElements.ModElement.Tag
public class AncientParchmentItem extends MetropiaadditionModElements.ModElement {
	@ObjectHolder("metropiaaddition:ancient_parchment")
	public static final Item block = null;

	public AncientParchmentItem(MetropiaadditionModElements instance) {
		super(instance, 54);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MetropiaMagicItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("ancient_parchment");
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
