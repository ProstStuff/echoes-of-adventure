package com.echoes.echoesofadventure.common.datagen;

import com.echoes.echoesofadventure.EchoesOfAdventure;
import com.echoes.echoesofadventure.common.block.ModBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TranslationProvider extends LanguageProvider {
    public TranslationProvider(PackOutput output, String locale) {
        super(output, EchoesOfAdventure.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        add(ModBlock.END_GRASS.get(), "End Grass");

        // Others
        add("itemGroup.echoesofadventure", "Echoes of Adventure");
    }
}
