package net.rexbrx.mynt.morehitboxes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.rexbrx.mynt.morehitboxes.internal.HitboxDataLoader;
import net.rexbrx.mynt.morehitboxes.network.SyncHitboxDataPayload;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class FabricMoreHitboxesMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        MoreHitboxesMod.init();
        PayloadTypeRegistry.playS2C().register(SyncHitboxDataPayload.TYPE, SyncHitboxDataPayload.STREAM_CODEC);
        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player, joined) -> {
            ServerPlayNetworking.send(player, new SyncHitboxDataPayload(HitboxDataLoader.HITBOX_DATA.getHitboxData()));
        });
    }
}
