package com.echoes.eoa.common.item;

import com.echoes.eoa.EchoesOfAdventure;
import com.echoes.eoa.common.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItemGroup {
    public static final DeferredRegister<CreativeModeTab> ITEM_GROUP = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EchoesOfAdventure.MOD_ID);

    public static final Supplier<CreativeModeTab> EOA_ITEM_GROUP = ITEM_GROUP.register("end",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlock.CRACKED_BRICKS))
                    .title(Component.translatable("itemGroup.echoesofadventure"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlock.END_GRASS);
                        output.accept(ModBlock.CRACKED_BRICKS);
                    }))

                    .build());

    public static void register(IEventBus event) {
        ITEM_GROUP.register(event);
    }
}
