package net.rexbrx.mynt.morehitboxes.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.rexbrx.mynt.morehitboxes.MoreHitboxesMod;
import net.rexbrx.mynt.morehitboxes.api.HitboxData;
import net.rexbrx.mynt.morehitboxes.internal.HitboxDataLoader;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

@ApiStatus.Internal
public record SyncHitboxDataPayload(Map<ResourceLocation, List<HitboxData>> hitboxes) implements CustomPacketPayload {
    private static final StreamCodec<FriendlyByteBuf, Map<ResourceLocation, List<HitboxData>>> DATA = data();
    public static final Type<SyncHitboxDataPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreHitboxesMod.MOD_ID, "sync_hitbox_data"));

    public static final StreamCodec<FriendlyByteBuf, SyncHitboxDataPayload> STREAM_CODEC = StreamCodec.composite(
            DATA,
            SyncHitboxDataPayload::hitboxes,
            SyncHitboxDataPayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    static StreamCodec<FriendlyByteBuf, Map<ResourceLocation, List<HitboxData>>> data() {
        return new StreamCodec<>() {
            public @NotNull Map<ResourceLocation, List<HitboxData>> decode(FriendlyByteBuf buf) {
                return buf.readMap(FriendlyByteBuf::readResourceLocation, HitboxDataLoader::readBuf);
            }

            public void encode(FriendlyByteBuf buf, Map<ResourceLocation, List<HitboxData>> hitboxData) {
                HitboxDataLoader.writeBuf(buf, hitboxData);
            }
        };
    }
}
