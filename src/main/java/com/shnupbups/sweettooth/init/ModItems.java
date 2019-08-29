package com.shnupbups.sweettooth.init;

import com.shnupbups.sweettooth.SweetTooth;
import com.shnupbups.sweettooth.items.ChocolateMilkBucketItem;
import com.shnupbups.sweettooth.items.CottonCandyItem;

import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static CottonCandyItem COTTON_CANDY = new CottonCandyItem(new Item.Settings().group(ItemGroup.FOOD).maxCount(1).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).snack().build()));
	public static Item CARAMEL = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build()));
	public static Item APPLE_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.3f).build()));
	public static ChocolateMilkBucketItem CHOCOLATE_MILK_BUCKET = new ChocolateMilkBucketItem(new Item.Settings().recipeRemainder(Items.BUCKET).group(ItemGroup.MISC).maxCount(1));
	
	public static void init() {
		Registry.register(Registry.ITEM, SweetTooth.getId("cotton_candy"), COTTON_CANDY);
		Registry.register(Registry.ITEM, SweetTooth.getId("caramel"), CARAMEL);
		Registry.register(Registry.ITEM, SweetTooth.getId("apple_pie"), APPLE_PIE);
		Registry.register(Registry.ITEM, SweetTooth.getId("chocolate_milk_bucket"), CHOCOLATE_MILK_BUCKET);
	}
}
