package com.shnupbups.sweettooth.init;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CandleCakeBlock;

import java.util.Map;

public class Cakes {
    public static final Map<CandleCake, Block> CANDLES_AND_CAKES_TO_CANDLE_CAKES = Maps.newHashMap();

    public static void init() {
        CandleCakeBlock.CANDLES_TO_CANDLE_CAKES.forEach((candle, candleCake) -> {
            registerCandleCake(candle, Blocks.CAKE, candleCake);
        });
    }

    public static void registerCandleCake(Block candle, Block cake, Block candleCake) {
        CANDLES_AND_CAKES_TO_CANDLE_CAKES.put(new CandleCake(candle, cake), candleCake);
    }

    public static Block getCandleCake(Block candle, Block cake) {
        return CANDLES_AND_CAKES_TO_CANDLE_CAKES.get(new CandleCake(candle, cake));
    }

    private record CandleCake(Block candle, Block cake) {
    }
}
