package com.echoes.eoa.common.block.custom;

import com.echoes.eoa.common.block.ModBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

public class SimpleBlock extends Block {
    // (remove it later)

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<SimpleBlock>> CODEC = ModBlock.MAP_CODECS.register(
            "simple",
            () -> simpleCodec(SimpleBlock::new)
    );

    public SimpleBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends Block> codec() {
        return CODEC.value();
    }
}
