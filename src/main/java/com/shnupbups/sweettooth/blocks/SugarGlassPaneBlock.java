package com.shnupbups.sweettooth.blocks;

import com.shnupbups.sweettooth.misc.ModProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SugarGlassPaneBlock extends PaneBlock implements SugarGlass {
	public static final IntProperty CRACKS = ModProperties.CRACKS;
	
	public SugarGlassPaneBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getStateManager().getDefaultState().with(CRACKS, 0));
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		super.onSteppedOn(world, pos, state, entity);
		this.crackOnSteppedOn(world, pos, state, entity);
	}

	@Override
	public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		super.onLandedUpon(world, state, pos, entity, fallDistance);
		this.crackOnLandedUpon(world, pos, state, fallDistance);
	}

	@Override
	public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
		super.onProjectileHit(world, state, hit, projectile);
		this.crackOnProjectile(world, hit.getBlockPos(), state);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
		super.appendProperties(stateManager);
		stateManager.add(CRACKS);
	}
}
