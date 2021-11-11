package com.shnupbups.sweettooth;

import com.shnupbups.sweettooth.init.Cakes;
import com.shnupbups.sweettooth.init.ModBlocks;
import com.shnupbups.sweettooth.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class SweetTooth implements ModInitializer {
	public static final String MOD_ID = "sweettooth";

	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
		Cakes.init();
	}
	
	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
}
