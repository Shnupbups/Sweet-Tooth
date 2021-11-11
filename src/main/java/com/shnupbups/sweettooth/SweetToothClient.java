package com.shnupbups.sweettooth;

import com.shnupbups.sweettooth.init.ModBlocks;
import com.shnupbups.sweettooth.init.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.DyeableItem;

@SuppressWarnings("unused")
public class SweetToothClient implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		ColorProviderRegistry.ITEM.register((stack, i) -> i > 0 ? ((DyeableItem)stack.getItem()).getColor(stack) : -1, ModItems.COTTON_CANDY);
		BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderLayer.getTranslucent(), ModBlocks.SUGAR_GLASS, ModBlocks.SUGAR_GLASS_PANE);
	}
}