package com.echoes.echoesofadventure;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = EchoesOfAdventure.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.BooleanValue DEBUG_LOGGING_SPEC = BUILDER
            .comment("Enable debug logging.")
            .define("debug-logging", false);

    static final ModConfigSpec SPEC = BUILDER.build();
    public static boolean DEBUG_LOGGING;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        DEBUG_LOGGING = DEBUG_LOGGING_SPEC.get();
    }
}
