package com.shnupbups.sweettooth.items;

import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class CottonCandyItem extends FoodOnAStickItem implements DyeableItem {
	public CottonCandyItem(Item.Settings settings) {
		super(settings);
	}
	
	@Override
	public int getColor(ItemStack stack) {
		NbtCompound nbt = stack.getSubNbt("display");
		return nbt != null && nbt.contains("color", 99) ? nbt.getInt("color") : 0xFFFFFF;
	}
}
