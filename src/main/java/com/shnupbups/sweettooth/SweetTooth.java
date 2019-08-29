package com.shnupbups.sweettooth;

import com.shnupbups.sweettooth.init.ModBlocks;
import com.shnupbups.sweettooth.init.ModItems;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

public class SweetTooth implements ModInitializer {
	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
	}
	
	public static Identifier getId(String name) {
		return new Identifier("sweettooth", name);
	}
}
