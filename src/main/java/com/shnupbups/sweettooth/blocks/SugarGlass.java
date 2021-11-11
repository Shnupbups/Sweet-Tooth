package com.shnupbups.sweettooth.blocks;

import com.shnupbups.sweettooth.misc.ModProperties;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface SugarGlass {
    default boolean crack(World world, BlockPos pos, BlockState state, int amount) {
        if(!world.isClient()) {
            int cracks = state.get(ModProperties.CRACKS);
            int newCracks = cracks + amount;
            boolean breaks = newCracks > ModProperties.MAX_CRACKS;

            if (!breaks) {
                world.setBlockState(pos, state.with(ModProperties.CRACKS, newCracks), 2);
                return false;
            } else {
                world.breakBlock(pos, false);
                return true;
            }
        } return false;
    }

    default void crackOnProjectile(World world, BlockPos pos, BlockState state) {
        this.crack(world, pos, state, 5);
    }

    default void crackOnLandedUpon(World world, BlockPos pos, BlockState state, float fallDistance) {
        this.crack(world, pos, state, (int) (fallDistance / 2) + 1);
    }

    default void crackOnSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!entity.isSpectator()) {
            int chance = 10;

            if (entity.isSneaky()) chance *= 2;
            else if (entity.isSprinting()) chance /= 2;

            if (world.getRandom().nextInt(chance) == 0) {
                this.crack(world, pos, state, 1);
            }
        }
    }
}
