package com.shnupbups.sweettooth.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import java.util.Random;

public class SugarBlock extends FallingBlock implements Waterloggable {
	
	public SugarBlock(Settings settings) {
		super(settings);
	}
	
	private static boolean dissolvesOnAnySide(BlockView view, BlockPos pos) {
		boolean dissolves = false;
		BlockPos.Mutable mutablePos = new BlockPos.Mutable(pos);
		Direction[] var4 = Direction.values();
		int var5 = var4.length;
		
		for(int var6 = 0; var6 < var5; ++var6) {
			Direction dir = var4[var6];
			BlockState state = view.getBlockState(mutablePos);
			if (dir != Direction.DOWN || dissolvesIn(state)) {
				mutablePos.set(pos).setOffset(dir);
				state = view.getBlockState(mutablePos);
				if (dissolvesIn(state) && !state.isSideSolidFullSquare(view, pos, dir.getOpposite())) {
					dissolves = true;
					break;
				}
			}
		}
		
		return dissolves;
	}
	
	private static boolean dissolvesIn(BlockState state) {
		return state.getFluidState().matches(FluidTags.WATER);
	}
	
	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		super.scheduledTick(state, world, pos, random);
		if(dissolvesOnAnySide(world, pos)) {
			world.breakBlock(pos, true);
		}
	}
}
