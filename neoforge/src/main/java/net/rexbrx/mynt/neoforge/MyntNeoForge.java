package net.rexbrx.mynt.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.loading.FMLLoader;
import net.rexbrx.mynt.Mynt;
import net.rexbrx.mynt.athena.impl.client.DefaultModels;
import net.rexbrx.mynt.neoforge.client.AthenaNeoForgeClient;

@Mod(Mynt.ID)
public final class MyntNeoForge {
    public MyntNeoForge(IEventBus modEventBus) {
        // Run our common setup.
        Mynt.init();
        if (FMLLoader.getDist().isClient()) {
            DefaultModels.init();
            AthenaNeoForgeClient.init(modEventBus);
        }
    }
}
