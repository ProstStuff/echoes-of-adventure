package com.echoes.eoa.common.datagen;

import com.echoes.eoa.EchoesOfAdventure;
import com.echoes.eoa.common.block.ModBlock;
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
        add(ModBlock.CRACKED_BRICKS.get(), "Cracked Bricks");

        // Others
        add("itemGroup.echoesofadventure", "Echoes of Adventure");
    }
}
