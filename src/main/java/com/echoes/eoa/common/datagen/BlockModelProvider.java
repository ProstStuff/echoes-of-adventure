package com.echoes.eoa.common.datagen;

import com.echoes.eoa.EchoesOfAdventure;
import com.echoes.eoa.common.block.ModBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockModelProvider extends net.neoforged.neoforge.client.model.generators.BlockModelProvider {
    public BlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EchoesOfAdventure.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        cubeBottomTop("end_grass", ResourceLocation.withDefaultNamespace("block/cobblestone"), ResourceLocation.withDefaultNamespace("block/end_stone"), ResourceLocation.withDefaultNamespace("block/stone"));
        cubeAll(ModBlock.CRACKED_BRICKS.getRegisteredName(), ResourceLocation.fromNamespaceAndPath(EchoesOfAdventure.MOD_ID,"block/cracked_bricks"));
    }


}
