package com.shnupbups.sweettooth.items;

import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ChocolateMilkBucketItem extends MilkBucketItem {
	public ChocolateMilkBucketItem(Item.Settings settings) {
		super(settings);
	}
	
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
			Criterions.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
			serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
		}
		
		if (user instanceof PlayerEntity && !((PlayerEntity)user).abilities.creativeMode) {
			stack.decrement(1);
		}
		
		if (!world.isClient) {
			ArrayList<StatusEffect> negativeEffects = new ArrayList<>();
			user.getActiveStatusEffects().forEach((effect, instance) -> {
				if(effect.getType().equals(StatusEffectType.HARMFUL)) {
					negativeEffects.add(effect);
				}
			});
			
			for(StatusEffect effect:negativeEffects) {
				user.tryRemoveStatusEffect(effect);
			}
		}
		
		return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
	}
}
