package com.echoes.echoesofadventure.common.datagen;

import com.echoes.echoesofadventure.EchoesOfAdventure;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EchoesOfAdventure.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // basicItem[ITEM_ID])
    }
}
