package net.rexbrx.mynt.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.rexbrx.mynt.fabric.client.api.AthenaModelLoadingPlugin;

public final class MyntFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingPlugin.register(new AthenaModelLoadingPlugin());
    }
}
