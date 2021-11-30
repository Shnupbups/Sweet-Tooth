package com.shnupbups.sweettooth.items;

import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtTypes;

public class CottonCandyItem extends FoodOnAStickItem implements DyeableItem {
	public CottonCandyItem(Item.Settings settings) {
		super(settings);
	}
	
	@Override
	public int getColor(ItemStack stack) {
		NbtCompound nbt = stack.getSubNbt("display");
		return nbt != null && nbt.contains("color", NbtElement.INT_TYPE) ? nbt.getInt("color") : 0xFFFFFF;
	}
}
