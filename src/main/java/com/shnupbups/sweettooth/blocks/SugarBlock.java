package com.shnupbups.sweettooth.blocks;

import net.minecraft.block.*;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class SugarBlock extends FallingBlock implements Waterloggable {
	
	public SugarBlock(Block.Settings settings) {
		super(settings);
	}
	
	/*@Override
	public void onLanding(World world, BlockPos pos, BlockState state1, BlockState state2) {
		if (dissolvesIn(state2)) {
			world.setBlockState(pos, state1, 3);
		}
	}*/
	
	private static boolean dissolvesOnAnySide(BlockView blockView_1, BlockPos blockPos_1) {
		boolean boolean_1 = false;
		BlockPos.Mutable blockPos$Mutable_1 = new BlockPos.Mutable(blockPos_1);
		Direction[] var4 = Direction.values();
		int var5 = var4.length;
		
		for(int var6 = 0; var6 < var5; ++var6) {
			Direction direction_1 = var4[var6];
			BlockState blockState_1 = blockView_1.getBlockState(blockPos$Mutable_1);
			if (direction_1 != Direction.DOWN || dissolvesIn(blockState_1)) {
				blockPos$Mutable_1.set((Vec3i)blockPos_1).setOffset(direction_1);
				blockState_1 = blockView_1.getBlockState(blockPos$Mutable_1);
				if (dissolvesIn(blockState_1) && !blockState_1.isSideSolidFullSquare(blockView_1, blockPos_1, direction_1.getOpposite())) {
					boolean_1 = true;
					break;
				}
			}
		}
		
		return boolean_1;
	}
	
	private static boolean dissolvesIn(BlockState blockState_1) {
		return blockState_1.getFluidState().matches(FluidTags.WATER);
	}
	
	@Override
	public void onScheduledTick(BlockState state, World world, BlockPos pos, Random random) {
		super.onScheduledTick(state, world, pos, random);
		if(dissolvesOnAnySide(world, pos)) {
			world.breakBlock(pos, true);
		}
	}
}
