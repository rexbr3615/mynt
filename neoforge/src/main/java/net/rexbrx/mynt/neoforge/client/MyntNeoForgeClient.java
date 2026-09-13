package net.rexbrx.mynt.neoforge.client;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ModelEvent;

public class MyntNeoForgeClient {

    public static void init(IEventBus mobEventBus) {
        mobEventBus.addListener(MyntNeoForgeClient::onRegisterGeometryLoaders);
    }

    public static void onRegisterGeometryLoaders(ModelEvent.RegisterGeometryLoaders event) {
        event.register(ResourceLocation.fromNamespaceAndPath("mynt", "mynt"), new AthenaGeometryLoader());
    }
}