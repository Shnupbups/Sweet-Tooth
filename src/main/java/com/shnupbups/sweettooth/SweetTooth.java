package com.shnupbups.sweettooth;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import com.shnupbups.sweettooth.init.ModBlocks;
import com.shnupbups.sweettooth.init.ModItems;

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
