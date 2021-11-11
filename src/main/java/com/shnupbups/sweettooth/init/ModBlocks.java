package com.shnupbups.sweettooth.init;

import com.shnupbups.sweettooth.SweetTooth;
import com.shnupbups.sweettooth.blocks.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	public static final Block SUGAR_BLOCK = new SugarBlock(FabricBlockSettings.copyOf(Blocks.SAND));
	public static final Block SUGAR_GLASS = new SugarGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS));
	public static final Block SUGAR_GLASS_PANE = new SugarGlassPaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS_PANE));
	public static final Block CHOCOLATE_CAKE = new ModCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE));
	public static final Block CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(Blocks.CANDLE_CAKE));
	public static final Block WHITE_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.WHITE_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block ORANGE_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.ORANGE_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block MAGENTA_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.MAGENTA_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.LIGHT_BLUE_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block YELLOW_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.YELLOW_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block LIME_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.LIME_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block PINK_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.PINK_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block GRAY_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.GRAY_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.LIGHT_GRAY_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block CYAN_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.CYAN_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block PURPLE_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.PURPLE_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block BLUE_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.BLUE_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block BROWN_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.BROWN_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block GREEN_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.GREEN_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block RED_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.RED_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	public static final Block BLACK_CANDLE_CHOCOLATE_CAKE = new ModCandleCakeBlock(Blocks.BLACK_CANDLE, CHOCOLATE_CAKE, FabricBlockSettings.copyOf(CANDLE_CHOCOLATE_CAKE));
	
	public static void init() {
		register("sugar_block", SUGAR_BLOCK);
		register("sugar_glass", SUGAR_GLASS);
		register("sugar_glass_pane", SUGAR_GLASS_PANE, new FabricItemSettings().group(ItemGroup.DECORATIONS));
		register("chocolate_cake", CHOCOLATE_CAKE, new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1));
		register("candle_chocolate_cake", CANDLE_CHOCOLATE_CAKE, false);
		register("white_candle_chocolate_cake", WHITE_CANDLE_CHOCOLATE_CAKE, false);
		register("orange_candle_chocolate_cake", ORANGE_CANDLE_CHOCOLATE_CAKE, false);
		register("magenta_candle_chocolate_cake", MAGENTA_CANDLE_CHOCOLATE_CAKE, false);
		register("light_blue_candle_chocolate_cake", LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE, false);
		register("yellow_candle_chocolate_cake", YELLOW_CANDLE_CHOCOLATE_CAKE, false);
		register("lime_candle_chocolate_cake", LIME_CANDLE_CHOCOLATE_CAKE, false);
		register("pink_candle_chocolate_cake", PINK_CANDLE_CHOCOLATE_CAKE, false);
		register("gray_candle_chocolate_cake", GRAY_CANDLE_CHOCOLATE_CAKE, false);
		register("light_gray_candle_chocolate_cake", LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE, false);
		register("cyan_candle_chocolate_cake", CYAN_CANDLE_CHOCOLATE_CAKE, false);
		register("purple_candle_chocolate_cake", PURPLE_CANDLE_CHOCOLATE_CAKE, false);
		register("blue_candle_chocolate_cake", BLUE_CANDLE_CHOCOLATE_CAKE, false);
		register("brown_candle_chocolate_cake", BROWN_CANDLE_CHOCOLATE_CAKE, false);
		register("green_candle_chocolate_cake", GREEN_CANDLE_CHOCOLATE_CAKE, false);
		register("red_candle_chocolate_cake", RED_CANDLE_CHOCOLATE_CAKE, false);
		register("black_candle_chocolate_cake", BLACK_CANDLE_CHOCOLATE_CAKE, false);
	}
	
	public static void register(String name, Block block, Item.Settings settings) {
		register(name, block, new BlockItem(block, settings));
	}

	public static void register(String name, Block block, BlockItem item) {
		Registry.register(Registry.BLOCK, SweetTooth.id(name), block);
		if(item != null) {
			item.appendBlocks(Item.BLOCK_ITEMS, item);
			ModItems.register(name, item);
		}
	}
	
	public static void register(String name, Block block, boolean item) {
		if(item) register(name, block, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
		else register(name, block, (BlockItem)null);
	}

	public static void register(String name, Block block) {
		register(name, block, true);
	}
}
