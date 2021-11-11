package com.shnupbups.sweettooth.misc;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent COTTON_CANDY = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).snack().build();
    public static final FoodComponent CARAMEL = new FoodComponent.Builder().hunger(1).saturationModifier(0.05f).build();
    public static final FoodComponent APPLE_PIE = new FoodComponent.Builder().hunger(8).saturationModifier(0.3f).build();
    public static final FoodComponent SWEET_JELLY = new FoodComponent.Builder().hunger(6).saturationModifier(9.6f).build();
    public static final FoodComponent GLOW_JELLY = new FoodComponent.Builder().hunger(6).saturationModifier(9.6f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0), 1.0f).build();
    public static final FoodComponent CARAMEL_APPLE = new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).build();
}
