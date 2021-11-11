package com.shnupbups.sweettooth.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class SugarBlock extends FallingBlock implements Waterloggable {
	
	public SugarBlock(Settings settings) {
		super(settings);
	}
	
	public BlockState dissolve(WorldAccess world, BlockPos pos) {
		world.breakBlock(pos, true);
		return world.getBlockState(pos);
	}

	@Override
	public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
		super.onLanding(world, pos, fallingBlockState, currentStateInPos, fallingBlockEntity);
		if (shouldDissolve(world, pos, currentStateInPos)) {
			this.dissolve(world, pos);
		}
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		super.onPlaced(world, pos, state, placer, stack);
		if(dissolvesOnAnySide(world, pos)) {
			this.dissolve(world, pos);
		}
	}

	private static boolean shouldDissolve(BlockView world, BlockPos pos, BlockState state) {
		return dissolvesIn(state) || dissolvesOnAnySide(world, pos);
	}

	private static boolean dissolvesOnAnySide(BlockView world, BlockPos pos) {
		boolean dissolve = false;
		BlockPos.Mutable mutable = pos.mutableCopy();

		for (Direction direction : Direction.values()) {
			BlockState state = world.getBlockState(mutable);
			if (direction != Direction.DOWN || dissolvesIn(state)) {
				mutable.set(pos, direction);
				state = world.getBlockState(mutable);
				if (dissolvesIn(state) && !state.isSideSolidFullSquare(world, pos, direction.getOpposite())) {
					dissolve = true;
					break;
				}
			}
		}

		return dissolve;
	}

	private static boolean dissolvesIn(BlockState state) {
		return state.getFluidState().isIn(FluidTags.WATER);
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		return dissolvesOnAnySide(world, pos) ? this.dissolve(world, pos) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
	}
}
