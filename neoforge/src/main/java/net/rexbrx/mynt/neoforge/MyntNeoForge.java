package net.rexbrx.mynt.neoforge;

import net.minecraft.core.registries.Registries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rexbrx.mynt.Mynt;
import net.rexbrx.mynt.athena.impl.client.DefaultModels;
import net.rexbrx.mynt.geckolib.GeckoLibConstants;
import net.rexbrx.mynt.geckolib.network.GeckoLibNetworkingNeoForge;
import net.rexbrx.mynt.morehitboxes.MoreHitboxesMod;
import net.rexbrx.mynt.morehitboxes.internal.GeckoLibEvents;
import net.rexbrx.mynt.morehitboxes.network.NetworkRegistry;
import net.rexbrx.mynt.neoforge.client.MyntNeoForgeClient;
import net.rexbrx.mynt.terrablender.config.TerraBlenderConfig;
import net.rexbrx.mynt.terrablender.core.TerraBlender;
import net.rexbrx.mynt.terrablender.handler.InitializationHandler;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@Mod(Mynt.ID)
public final class MyntNeoForge {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS_REGISTER =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Mynt.ID);

    private static final TerraBlenderConfig CONFIG = new TerraBlenderConfig(FMLPaths.CONFIGDIR.get().resolve("myntfied_terrablender" + ".toml"));


    public MyntNeoForge(IEventBus modEventBus) {
        // --- GeckoLib (antigo construtor de GeckoLib) ---
        GeckoLibNetworkingNeoForge.init(modEventBus);
        DATA_COMPONENTS_REGISTER.register(modEventBus);
        GeckoLibConstants.init();

        // --- Mynt ---
        if (FMLLoader.getDist().isClient()) {
            DefaultModels.init();
            Mynt.init();
            MoreHitboxesMod.init();
            MyntNeoForgeClient.init(modEventBus);

            NeoForge.EVENT_BUS.addListener(GeckoLibEvents::incrementCurrentRenderTick);
        }
//        if (ModList.get().isLoaded("geckolib") && FMLLoader.getDist() == Dist.CLIENT) {
//            NeoForge.EVENT_BUS.addListener(GeckoLibEvents::incrementCurrentRenderTick);
//        }

        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, InitializationHandler::onServerAboutToStart);
        TerraBlender.setConfig(CONFIG);
        modEventBus.addListener(NetworkRegistry::init);
    }
}
