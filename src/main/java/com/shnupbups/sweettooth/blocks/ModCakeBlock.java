package com.shnupbups.sweettooth.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public class ModCakeBlock extends CakeBlock {
	public ModCakeBlock(Settings settings) {
		super(settings);
	}

	public static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
		return CakeBlock.tryEat(world, pos, state, player);
	}
}
