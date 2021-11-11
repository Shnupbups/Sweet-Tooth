package com.shnupbups.sweettooth.misc;

import net.minecraft.state.property.IntProperty;

public class ModProperties {
	public static final int MAX_CRACKS = 15;
	public static final IntProperty CRACKS = IntProperty.of("cracks", 0, MAX_CRACKS);
}
