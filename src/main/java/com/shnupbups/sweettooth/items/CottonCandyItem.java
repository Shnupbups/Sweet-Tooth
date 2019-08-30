package com.shnupbups.sweettooth.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;

public class CottonCandyItem extends FoodOnAStickItem implements DyeableItem {
	public CottonCandyItem(Item.Settings settings) {
		super(settings);
	}
	
	@Override
	public int getColor(ItemStack itemStack_1) {
		CompoundTag compoundTag_1 = itemStack_1.getSubTag("display");
		return compoundTag_1 != null && compoundTag_1.containsKey("color", 99) ? compoundTag_1.getInt("color") : 0xFFFFFF;
	}
}
