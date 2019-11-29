package com.shnupbups.sweettooth.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.shnupbups.sweettooth.ModProperties;

public class SugarGlassPaneBlock extends PaneBlock {
	public static final IntProperty CRACKS;
	
	public SugarGlassPaneBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getStateManager().getDefaultState().with(CRACKS, 0));
	}
	
	@Override
	public void onSteppedOn(World world, BlockPos pos, Entity entity) {
		super.onSteppedOn(world, pos, entity);
		if(world.random.nextInt(63)==0) {
			this.crack(world, pos);
		}
	}
	
	@Override
	public void onLandedUpon(World world, BlockPos pos, Entity entity, float float1) {
		super.onLandedUpon(world, pos, entity, float1);
		this.crack(world, pos);
	}
	
	@Override
	public void onProjectileHit(World world, BlockState state, BlockHitResult bhr, Entity entity) {
		super.onProjectileHit(world, state, bhr, entity);
		this.crack(world, bhr.getBlockPos());
	}
	
	public boolean crack(World world, BlockPos pos) {
		if(!world.isClient()) {
			BlockState state = world.getBlockState(pos);
			int cracks = state.get(CRACKS);
			if (cracks < 3) {
				world.setBlockState(pos, state.with(CRACKS, cracks + 1), 2);
				return false;
			} else {
				world.breakBlock(pos, false);
				return true;
			}
		} return false;
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		super.appendProperties(stateManager);
		stateManager.add(CRACKS);
	}
	
	static {
		CRACKS = ModProperties.CRACKS;
	}
}
