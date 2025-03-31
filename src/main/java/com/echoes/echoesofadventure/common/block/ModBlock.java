package com.echoes.echoesofadventure.common.block;

import com.echoes.echoesofadventure.EchoesOfAdventure;
import com.echoes.echoesofadventure.common.block.custom.EndGrass;
import com.echoes.echoesofadventure.common.item.ModItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EchoesOfAdventure.MOD_ID);

    // The End
    public static final DeferredBlock<Block> END_GRASS = register("end_grass", () -> new EndGrass(Blocks.END_STONE.properties()), true);

    public static void register(IEventBus event) {
        BLOCKS.register(event);
        EchoesOfAdventure.print("Registering blocks...");
    }

    public static <T extends Block> DeferredBlock<T> register(String id, Supplier<T> supplier, Boolean registerItem) {
        DeferredBlock<T> block = BLOCKS.register(id, supplier);

        if (registerItem) {
            ModItem.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        return block;
    }
}
