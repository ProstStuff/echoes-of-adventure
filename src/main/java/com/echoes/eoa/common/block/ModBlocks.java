package com.echoes.eoa.common.block;

import com.echoes.eoa.EchoesOfAdventure;
import com.echoes.eoa.common.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EchoesOfAdventure.MOD_ID);
    public static final DeferredRegister<MapCodec<? extends Block>> MAP_CODECS = DeferredRegister.create(BuiltInRegistries.BLOCK_TYPE, EchoesOfAdventure.MOD_ID);

    // The End
    //public static final DeferredBlock<Block> END_GRASS = register("end_grass", () -> new EndGrass(Blocks.END_STONE.properties()));

    // Cracked Variant
    private static final BlockBehaviour.Properties brick_property = Blocks.BRICKS.properties();

    public static final DeferredBlock<Block> CRACKED_BRICKS = register("cracked_bricks", () -> new Block(brick_property));
    public static final DeferredBlock<SlabBlock> CRACKED_BRICK_SLAB = register("cracked_brick_slab", () -> new SlabBlock(Blocks.BRICK_SLAB.properties()));
    public static final DeferredBlock<StairBlock> CRACKED_BRICK_STAIRS = register("cracked_brick_stairs", () -> new StairBlock(Blocks.BRICK_STAIRS.defaultBlockState(), Blocks.BRICK_STAIRS.properties()));
    public static final DeferredBlock<WallBlock> CRACKED_BRICK_WALL = register("cracked_brick_wall", () -> new WallBlock(Blocks.BRICK_WALL.properties()));

    public static final DeferredBlock<SlabBlock> CRACKED_STONE_BRICK_SLAB = register("cracked_stone_brick_slab", () -> new SlabBlock(Blocks.STONE_SLAB.properties()));
    public static final DeferredBlock<StairBlock> CRACKED_STONE_BRICK_STAIRS = register("cracked_stone_brick_stairs", () -> new StairBlock(Blocks.STONE_STAIRS.defaultBlockState(), Blocks.BRICK_STAIRS.properties()));
    public static final DeferredBlock<WallBlock> CRACKED_STONE_BRICK_WALL = register("cracked_stone_brick_wall", () -> new WallBlock(Blocks.STONE_BRICK_WALL.properties()));


    public static void register(IEventBus event) {
        BLOCKS.register(event);
        EchoesOfAdventure.print("Registering blocks...");
    }

    public static <T extends Block> DeferredBlock<T> register(String id, Supplier<T> supplier) {
        DeferredBlock<T> block = BLOCKS.register(id, supplier);
        ModItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));

        return block;
    }
}
