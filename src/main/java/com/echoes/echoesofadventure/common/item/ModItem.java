package com.echoes.echoesofadventure.common.item;

import com.echoes.echoesofadventure.EchoesOfAdventure;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EchoesOfAdventure.MOD_ID);

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
