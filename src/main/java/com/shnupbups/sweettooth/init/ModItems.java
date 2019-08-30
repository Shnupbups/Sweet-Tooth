package com.shnupbups.sweettooth.init;

import com.shnupbups.sweettooth.SweetTooth;
import com.shnupbups.sweettooth.items.ChocolateMilkBucketItem;
import com.shnupbups.sweettooth.items.CottonCandyItem;
import com.shnupbups.sweettooth.items.FoodOnAStickItem;

import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static CottonCandyItem COTTON_CANDY = new CottonCandyItem(new Item.Settings().recipeRemainder(Items.STICK).group(ItemGroup.FOOD).maxCount(1).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).snack().build()));
	public static Item CARAMEL = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build()));
	public static Item APPLE_PIE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.3f).build()));
	public static ChocolateMilkBucketItem CHOCOLATE_MILK_BUCKET = new ChocolateMilkBucketItem(new Item.Settings().recipeRemainder(Items.BUCKET).group(ItemGroup.MISC).maxCount(1));
	public static Item SWEET_JAM = new Item(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).group(ItemGroup.FOOD).maxCount(1).food(new FoodComponent.Builder().hunger(6).saturationModifier(9.6f).build()));
	public static FoodOnAStickItem CARAMEL_APPLE = new FoodOnAStickItem(new Item.Settings().recipeRemainder(Items.STICK).group(ItemGroup.FOOD).maxCount(1).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build()));
	public static Item SUGAR_DUSTED_COAL = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static Item SUGAR_DUSTED_CHARCOAL = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	
	public static void init() {
		register("cotton_candy", COTTON_CANDY);
		register("caramel", CARAMEL);
		register("apple_pie", APPLE_PIE);
		register("chocolate_milk_bucket", CHOCOLATE_MILK_BUCKET);
		register("sweet_jam", SWEET_JAM);
		register("caramel_apple", CARAMEL_APPLE);
		register("sugar_dusted_coal", SUGAR_DUSTED_COAL);
		register("sugar_dusted_charcoal", SUGAR_DUSTED_CHARCOAL);
	}
	
	public static void register(String name, Item item) {
		Registry.register(Registry.ITEM, SweetTooth.getId(name), item);
	}
}
