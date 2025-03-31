package com.echoes.echoesofadventure.common.datagen;

import com.echoes.echoesofadventure.EchoesOfAdventure;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockModelProvider extends net.neoforged.neoforge.client.model.generators.BlockModelProvider {
    public BlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EchoesOfAdventure.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        cubeBottomTop("end_grass", ResourceLocation.withDefaultNamespace("block/grass_block_side"), ResourceLocation.withDefaultNamespace("block/grass_block_top"), ResourceLocation.withDefaultNamespace("block/dirt"));
    }
}
