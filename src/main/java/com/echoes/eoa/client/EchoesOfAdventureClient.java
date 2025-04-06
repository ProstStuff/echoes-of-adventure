package com.echoes.eoa.client;

import com.echoes.eoa.EchoesOfAdventure;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = EchoesOfAdventure.MOD_ID, dist = Dist.CLIENT)
public class EchoesOfAdventureClient {
    public EchoesOfAdventureClient(IEventBus modBus, ModContainer modContainer) {
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}