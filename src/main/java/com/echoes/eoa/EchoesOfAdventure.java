package com.echoes.eoa;

import com.echoes.eoa.common.block.ModBlocks;
import com.echoes.eoa.common.item.ModItemGroups;
import com.echoes.eoa.common.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(EchoesOfAdventure.MOD_ID)
public class EchoesOfAdventure {
    public static final String MOD_ID = "eoa";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EchoesOfAdventure(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModItemGroups.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.commonSpec);
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.clientSpec);
        //modEventBus.register(Config.class);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

    public static ResourceLocation getId(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
    public static ResourceLocation getId(String id, String suffix) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, suffix+ "/" +id);
    }
}
