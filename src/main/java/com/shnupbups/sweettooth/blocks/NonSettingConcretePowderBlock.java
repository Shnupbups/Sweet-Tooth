package com.shnupbups.sweettooth.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class NonSettingConcretePowderBlock extends FallingBlock {
	public NonSettingConcretePowderBlock(Settings settings) {
		super(settings);
	}

	public int getColor(BlockState state, BlockView world, BlockPos pos) {
		return state.getMapColor(world, pos).color;
	}
}
