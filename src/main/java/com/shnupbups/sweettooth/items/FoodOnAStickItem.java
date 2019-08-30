package com.shnupbups.sweettooth.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class FoodOnAStickItem extends Item {
	public FoodOnAStickItem(Item.Settings settings) {
		super(settings);
	}
	
	@Override
	public ItemStack finishUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1) {
		super.finishUsing(itemStack_1, world_1, livingEntity_1);
		return new ItemStack(Items.STICK);
	}
}
