package com.shnupbups.sweettooth.items;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
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
		if (user instanceof ServerPlayerEntity player) {
			Criteria.CONSUME_ITEM.trigger(player, stack);
			player.incrementStat(Stats.USED.getOrCreateStat(this));
		}
		
		if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
			stack.decrement(1);
		}
		
		if (!world.isClient) {
			ArrayList<StatusEffect> negativeEffects = new ArrayList<>();
			user.getActiveStatusEffects().forEach((effect, instance) -> {
				if(effect.getCategory().equals(StatusEffectCategory.HARMFUL)) {
					negativeEffects.add(effect);
				}
			});
			
			for(StatusEffect effect:negativeEffects) {
				user.removeStatusEffect(effect);
			}
		}
		
		return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
	}
}
