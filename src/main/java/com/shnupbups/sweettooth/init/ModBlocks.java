package com.shnupbups.sweettooth.init;

import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.shnupbups.sweettooth.SweetTooth;
import com.shnupbups.sweettooth.blocks.ModCakeBlock;
import com.shnupbups.sweettooth.blocks.SugarBlock;
import com.shnupbups.sweettooth.blocks.SugarGlassBlock;
import com.shnupbups.sweettooth.blocks.SugarGlassPaneBlock;

public class ModBlocks {
	public static Block SUGAR_BLOCK = new SugarBlock(Block.Settings.copy(Blocks.SAND));
	public static Block SUGAR_GLASS = new SugarGlassBlock(Block.Settings.copy(Blocks.GLASS));
	public static Block SUGAR_GLASS_PANE = new SugarGlassPaneBlock(Block.Settings.copy(Blocks.GLASS_PANE));
	public static Block SUGAR_SAND = new ConcretePowderBlock(SUGAR_GLASS, Block.Settings.copy(Blocks.SAND));
	public static Block CHOCOLATE_CAKE = new ModCakeBlock(Block.Settings.copy(Blocks.CAKE));
	
	public static void init() {
		register("sugar_block", SUGAR_BLOCK);
		register("sugar_glass", SUGAR_GLASS);
		register("sugar_glass_pane", SUGAR_GLASS_PANE, new Item.Settings().group(ItemGroup.DECORATIONS));
		register("sugar_sand", SUGAR_SAND);
		register("chocolate_cake", CHOCOLATE_CAKE, new Item.Settings().group(ItemGroup.FOOD).maxCount(1));
	}
	
	public static BlockItem register(String name, Block block, Item.Settings settings) {
		Identifier id = SweetTooth.getId(name);
		Registry.register(Registry.BLOCK, id, block);
		BlockItem item = new BlockItem(block, settings);
		item.appendBlocks(Item.BLOCK_ITEMS, item);
		Registry.register(Registry.ITEM, id, item);
		return item;
	}
	
	public static BlockItem register(String name, Block block) {
		return register(name, block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	}
}
