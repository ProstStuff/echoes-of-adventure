package com.echoes.eoa;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.Logging;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;

@EventBusSubscriber(modid = EchoesOfAdventure.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    static final ModConfigSpec clientSpec;
    public static final Config.Client CLIENT;
    static final ModConfigSpec commonSpec;
    public static final Config.Common COMMON;

    /*@SubscribeEvent
    public static void onLoad(ModConfigEvent.Loading configEvent) {

    }*/

    @SubscribeEvent
    public static void onFileChange(ModConfigEvent.Reloading configEvent) {
        LogManager.getLogger().debug(Logging.FORGEMOD, "NeoForge config just got changed on the file system!");

        if (configEvent.getConfig().getSpec() == clientSpec) {
            boolean debugLogging = COMMON.debugLogging.getAsBoolean();
            boolean holidayFeatures = CLIENT.holidayFeatures.getAsBoolean();

            if (debugLogging) {
                EchoesOfAdventure.LOGGER.info("Holiday features are set to: {}", holidayFeatures);
            }
        }

    }

    static {
        Pair<Object, ModConfigSpec> specPair = (new ModConfigSpec.Builder()).configure(Config.Client::new);
        clientSpec = specPair.getRight();
        CLIENT = (Config.Client) specPair.getLeft();

        specPair = (new ModConfigSpec.Builder()).configure(Config.Common::new);
        commonSpec = specPair.getRight();
        COMMON = (Config.Common) specPair.getLeft();
    }

    public static class Common {
        public final ModConfigSpec.BooleanValue debugLogging;

        Common(ModConfigSpec.Builder builder) {

            this.debugLogging = builder
                    .comment("Enable debug logging (Default: false)")
                    .translation("eoa.config.debug_logging")
                    .define("debugLogging", false);
        }
    }

    public static class Client {
        public final ModConfigSpec.BooleanValue holidayFeatures;

        Client(ModConfigSpec.Builder builder) {
            this.holidayFeatures = builder
                    .comment("Enable holiday features such as Christmas and Halloween (Default: true)")
                    .translation("eoa.config.holiday_features")
                    .define("holidayFeatures", true);
        }
    }
}
