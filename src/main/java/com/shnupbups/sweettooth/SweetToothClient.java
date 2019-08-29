package com.shnupbups.sweettooth;

import com.shnupbups.sweettooth.init.ModItems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;

import net.minecraft.item.DyeableItem;

@SuppressWarnings("unused")
public class SweetToothClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		ColorProviderRegistry.ITEM.register((stack, i) -> {
			return i > 0 ? ((DyeableItem)stack.getItem()).getColor(stack) : -1;
		}, ModItems.COTTON_CANDY);
	}
}
