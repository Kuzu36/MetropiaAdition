
package net.metropia.addition.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.state.BooleanProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.metropia.addition.itemgroup.MetropiaPlantItemGroup;
import net.metropia.addition.MetropiaadditionModElements;

import java.util.List;
import java.util.Collections;

@MetropiaadditionModElements.ModElement.Tag
public class FlowerbedBlock extends MetropiaadditionModElements.ModElement {
	@ObjectHolder("metropiaaddition:flowerbed")
	public static final Block block = null;

	public FlowerbedBlock(MetropiaadditionModElements instance) {
		super(instance, 74);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(MetropiaPlantItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends PressurePlateBlock implements IWaterLoggable {
		public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

		public CustomBlock() {
			super(Sensitivity.MOBS, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(1f, 10f)
					.setLightLevel(s -> 0).doesNotBlockMovement());
			this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false));
			setRegistryName("flowerbed");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			boolean flag = context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER;
			return this.getDefaultState().with(WATERLOGGED, flag);
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(WATERLOGGED);
		}

		@Override
		public FluidState getFluidState(BlockState state) {
			return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		}

		@Override
		public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos,
				BlockPos facingPos) {
			if (state.get(WATERLOGGED)) {
				world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}
			return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
