package net.rexbrx.mynt.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.common.NeoForge;
import net.rexbrx.mynt.Mynt;
import net.rexbrx.mynt.athena.impl.client.DefaultModels;
import net.rexbrx.mynt.morehitboxes.MoreHitboxesMod;
import net.rexbrx.mynt.morehitboxes.internal.GeckoLibEvents;
import net.rexbrx.mynt.morehitboxes.network.NetworkRegistry;
import net.rexbrx.mynt.neoforge.client.MyntNeoForgeClient;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@Mod(Mynt.ID)
public final class MyntNeoForge {
    public MyntNeoForge(IEventBus modEventBus) {
        // Run our common setup.
        if (FMLLoader.getDist().isClient()) {
            DefaultModels.init();
            Mynt.init();
            MoreHitboxesMod.init();
            MyntNeoForgeClient.init(modEventBus);
        }
        if (ModList.get().isLoaded("geckolib") && FMLLoader.getDist() == Dist.CLIENT) {
            NeoForge.EVENT_BUS.addListener(GeckoLibEvents::incrementCurrentRenderTick);
        }
        modEventBus.addListener(NetworkRegistry::init);
    }
}
