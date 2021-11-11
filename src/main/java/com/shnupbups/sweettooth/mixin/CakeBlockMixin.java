package com.shnupbups.sweettooth.mixin;

import com.shnupbups.sweettooth.init.Cakes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CakeBlock.class)
public class CakeBlockMixin extends Block {
    private CakeBlockMixin(Settings settings) {
        super(settings);
    }

    @Redirect(method = "onUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/CandleCakeBlock;getCandleCakeFromCandle(Lnet/minecraft/block/Block;)Lnet/minecraft/block/BlockState;"))
    private BlockState getCandleCakeRedirect(Block candle) {
        return Cakes.getCandleCake(candle, this).getDefaultState();
    }
}
