package com.shnupbups.sweettooth.init;

import com.shnupbups.sweettooth.SweetTooth;
import com.shnupbups.sweettooth.items.ChocolateMilkBucketItem;
import com.shnupbups.sweettooth.items.CottonCandyItem;
import com.shnupbups.sweettooth.items.FoodOnAStickItem;
import com.shnupbups.sweettooth.misc.ModFoodComponents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final Item COTTON_CANDY = new CottonCandyItem(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1).food(ModFoodComponents.COTTON_CANDY));
	public static final Item CARAMEL = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.CARAMEL));
	public static final Item APPLE_PIE = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(ModFoodComponents.APPLE_PIE));
	public static final Item CHOCOLATE_MILK_BUCKET = new ChocolateMilkBucketItem(new FabricItemSettings().recipeRemainder(Items.BUCKET).group(ItemGroup.MISC).maxCount(1));
	public static final Item SWEET_JELLY = new HoneyBottleItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).group(ItemGroup.FOOD).maxCount(1).food(ModFoodComponents.SWEET_JELLY));
	public static final Item GLOW_JELLY = new HoneyBottleItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).group(ItemGroup.FOOD).maxCount(1).food(ModFoodComponents.GLOW_JELLY));
	public static final Item CARAMEL_APPLE = new FoodOnAStickItem(new FabricItemSettings().recipeRemainder(Items.STICK).group(ItemGroup.FOOD).maxCount(1).food(ModFoodComponents.CARAMEL_APPLE));
	public static final Item SUGAR_DUSTED_COAL = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
	public static final Item SUGAR_DUSTED_CHARCOAL = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
	
	public static void init() {
		register("cotton_candy", COTTON_CANDY);
		register("caramel", CARAMEL);
		register("apple_pie", APPLE_PIE);
		register("chocolate_milk_bucket", CHOCOLATE_MILK_BUCKET);
		register("sweet_jelly", SWEET_JELLY);
		register("glow_jelly", GLOW_JELLY);
		register("caramel_apple", CARAMEL_APPLE);
		register("sugar_dusted_coal", SUGAR_DUSTED_COAL);
		register("sugar_dusted_charcoal", SUGAR_DUSTED_CHARCOAL);

		FuelRegistryImpl.INSTANCE.add(SUGAR_DUSTED_COAL, 2000);
		FuelRegistryImpl.INSTANCE.add(SUGAR_DUSTED_CHARCOAL, 2000);
	}
	
	public static void register(String name, Item item) {
		Registry.register(Registry.ITEM, SweetTooth.id(name), item);
	}
}
