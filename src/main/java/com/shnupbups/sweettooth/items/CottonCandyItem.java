package com.shnupbups.sweettooth.items;

import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public class CottonCandyItem extends FoodOnAStickItem implements DyeableItem {
	public CottonCandyItem(Item.Settings settings) {
		super(settings);
	}
	
	@Override
	public int getColor(ItemStack stack) {
		CompoundTag tag = stack.getSubTag("display");
		return tag != null && tag.contains("color", 99) ? tag.getInt("color") : 0xFFFFFF;
	}
}
