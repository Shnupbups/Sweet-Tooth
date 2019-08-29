package com.shnupbups.sweettooth.items;

import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

import java.util.Iterator;

public class ChocolateMilkBucketItem extends MilkBucketItem {
	public ChocolateMilkBucketItem(Item.Settings settings) {
		super(settings);
	}
	
	public ItemStack finishUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1) {
		if (livingEntity_1 instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayerEntity_1 = (ServerPlayerEntity)livingEntity_1;
			Criterions.CONSUME_ITEM.handle(serverPlayerEntity_1, itemStack_1);
			serverPlayerEntity_1.incrementStat(Stats.USED.getOrCreateStat(this));
		}
		
		if (livingEntity_1 instanceof PlayerEntity && !((PlayerEntity)livingEntity_1).abilities.creativeMode) {
			itemStack_1.decrement(1);
		}
		
		if (!world_1.isClient) {
			Iterator<StatusEffect> iterator_1 = livingEntity_1.getActiveStatusEffects().keySet().iterator();
			
			while(iterator_1.hasNext()) {
				StatusEffect se = iterator_1.next();
				if(se.getType() == StatusEffectType.HARMFUL) {
					livingEntity_1.removeStatusEffect(se);
				}
			}
		}
		
		return itemStack_1.isEmpty() ? new ItemStack(Items.BUCKET) : itemStack_1;
	}
}
