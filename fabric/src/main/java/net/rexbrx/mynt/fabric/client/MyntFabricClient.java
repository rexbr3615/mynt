package net.rexbrx.mynt.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.rexbrx.mynt.athena.api.client.fabric.AthenaModelLoadingPlugin;
import net.rexbrx.mynt.geckolib.GeckoLibConstants;
import net.rexbrx.mynt.geckolib.cache.GeckoLibCache;
import net.rexbrx.mynt.geckolib.network.packet.MultiloaderPacket;
import net.rexbrx.mynt.geckolib.service.GeckoLibNetworking;
import net.rexbrx.mynt.morehitboxes.internal.GeckoLibEvents;
import net.rexbrx.mynt.morehitboxes.internal.HitboxDataLoader;
import net.rexbrx.mynt.morehitboxes.network.SyncHitboxDataPayload;
import org.jetbrains.annotations.ApiStatus;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

//@ApiStatus.Internal
public final class MyntFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingPlugin.register(new AthenaModelLoadingPlugin());

        ResourceManagerHelper.get(PackType.CLIENT_RESOURCES)
                .registerReloadListener(new IdentifiableResourceReloadListener() {
                    @Override
                    public ResourceLocation getFabricId() {
                        return GeckoLibConstants.id("models_animations");
                    }

                    @Override
                    public CompletableFuture<Void> reload(PreparationBarrier synchronizer, ResourceManager manager,
                                                          ProfilerFiller prepareProfiler, ProfilerFiller applyProfiler, Executor prepareExecutor,
                                                          Executor applyExecutor) {
                        return GeckoLibCache.reload(synchronizer, manager, prepareProfiler, applyProfiler, prepareExecutor, applyExecutor);
                    }
                });


        //ClientPlayNetworking.registerGlobalReceiver(SyncHitboxDataPayload.TYPE, (payload, context) -> {
        //    context.client().execute(() -> HitboxDataLoader.HITBOX_DATA.replaceData(payload.hitboxes()));
        //});
        //if (FabricLoader.getInstance().isModLoaded("geckolib")) {
        //    GeckoLibEvents.init();
        //}
    }

    @ApiStatus.Internal
    public static <P extends MultiloaderPacket> void registerPacket(CustomPacketPayload.Type<P> packetType) {
        ClientPlayNetworking.registerGlobalReceiver(packetType, (packet, context) -> packet.receiveMessage(context.player(), context.client()::execute));
    }
}
