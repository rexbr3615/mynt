package net.rexbrx.mynt.morehitboxes.network;

import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.rexbrx.mynt.morehitboxes.internal.HitboxDataLoader;
import org.jetbrains.annotations.ApiStatus;

import java.util.Map;

@ApiStatus.Internal
public class ClientPayloadHandler {

    public static void handle(SyncHitboxDataPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> HitboxDataLoader.HITBOX_DATA.replaceData(payload.hitboxes()))
                .exceptionally(e -> {
                    // Handle exception
                    context.disconnect(Component.literal(e.getMessage()));
                    return null;
                })
                .thenAccept(v -> context.reply(new SyncHitboxDataPayload(Map.of())));
    }
}
