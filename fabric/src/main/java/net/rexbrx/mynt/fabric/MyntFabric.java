package net.rexbrx.mynt.fabric;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.rexbrx.mynt.Mynt;
import net.rexbrx.mynt.morehitboxes.MoreHitboxesMod;
import net.rexbrx.mynt.morehitboxes.internal.HitboxDataLoader;
import net.rexbrx.mynt.morehitboxes.network.SyncHitboxDataPayload;
import org.jetbrains.annotations.ApiStatus;

//@ApiStatus.Internal
public final class MyntFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // more hitboxes code
        //MoreHitboxesMod.init();
        //PayloadTypeRegistry.playS2C().register(SyncHitboxDataPayload.TYPE, SyncHitboxDataPayload.STREAM_CODEC);
        //ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player, joined) -> {
        //    ServerPlayNetworking.send(player, new SyncHitboxDataPayload(HitboxDataLoader.HITBOX_DATA.getHitboxData()));
        //});



        // Run our common setup.
        Mynt.init();
    }
}
