package com.shnupbups.sweettooth.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;

public class CottonCandyItem extends Item implements DyeableItem {
	public CottonCandyItem(Item.Settings settings) {
		super(settings);
	}
	
	@Override
	public ItemStack finishUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1) {
		super.finishUsing(itemStack_1, world_1, livingEntity_1);
		return new ItemStack(Items.STICK);
	}
	
	@Override
	public int getColor(ItemStack itemStack_1) {
		CompoundTag compoundTag_1 = itemStack_1.getSubTag("display");
		return compoundTag_1 != null && compoundTag_1.containsKey("color", 99) ? compoundTag_1.getInt("color") : 0xFFFFFF;
	}
}
