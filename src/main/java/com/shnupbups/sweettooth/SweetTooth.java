package com.shnupbups.sweettooth;

import com.shnupbups.sweettooth.init.ModBlocks;
import com.shnupbups.sweettooth.init.ModItems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.impl.registry.FuelRegistryImpl;

import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class SweetTooth implements ModInitializer {
	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
		FuelRegistryImpl.INSTANCE.add(new Tag<>(getId("sugar_dusted_coals")), 2000);
	}
	
	public static Identifier getId(String name) {
		return new Identifier("sweettooth", name);
	}
}
