package com.echoes.echoesofadventure.common.datagen;

import com.echoes.echoesofadventure.EchoesOfAdventure;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = EchoesOfAdventure.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerationCore {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput pack = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new TranslationProvider(pack, "en_us"));
        generator.addProvider(event.includeServer(), new BlockModelProvider(pack, fileHelper));
        generator.addProvider(event.includeServer(), new ItemModelProvider(pack, fileHelper));
    }
}
