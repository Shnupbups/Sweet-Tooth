package com.shnupbups.sweettooth.init;

import com.shnupbups.sweettooth.SweetTooth;
import com.shnupbups.sweettooth.blocks.SugarBlock;
import com.shnupbups.sweettooth.blocks.SugarGlassBlock;
import com.shnupbups.sweettooth.blocks.SugarGlassPaneBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	public static SugarBlock SUGAR_BLOCK = new SugarBlock(Block.Settings.copy(Blocks.SAND));
	public static SugarGlassBlock SUGAR_GLASS = new SugarGlassBlock(Block.Settings.copy(Blocks.GLASS));
	public static SugarGlassPaneBlock SUGAR_GLASS_PANE = new SugarGlassPaneBlock(Block.Settings.copy(Blocks.GLASS_PANE));
	public static ConcretePowderBlock SUGAR_SAND = new ConcretePowderBlock(SUGAR_GLASS, Block.Settings.copy(Blocks.SAND));
	
	public static void init() {
		register("sugar_block", SUGAR_BLOCK);
		register("sugar_glass", SUGAR_GLASS);
		register("sugar_glass_pane", SUGAR_GLASS_PANE);
		register("sugar_sand", SUGAR_SAND);
	}
	
	public static void register(String name, Block block) {
		Identifier id = SweetTooth.getId(name);
		Registry.register(Registry.BLOCK, id, block);
		BlockItem item = new BlockItem(block, (new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		item.appendBlocks(Item.BLOCK_ITEMS, item);
		Registry.register(Registry.ITEM, id, item);
	}
}
