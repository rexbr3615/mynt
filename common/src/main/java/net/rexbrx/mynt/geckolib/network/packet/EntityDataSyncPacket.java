package net.rexbrx.mynt.geckolib.network.packet;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import net.rexbrx.mynt.geckolib.GeckoLibConstants;
import net.rexbrx.mynt.geckolib.animatable.GeoEntity;
import net.rexbrx.mynt.geckolib.animatable.GeoReplacedEntity;
import net.rexbrx.mynt.geckolib.constant.dataticket.SerializableDataTicket;
import net.rexbrx.mynt.geckolib.util.ClientUtil;
import net.rexbrx.mynt.geckolib.util.RenderUtil;

import java.util.function.Consumer;

public record EntityDataSyncPacket<D>(int entityId, boolean isReplacedEntity, SerializableDataTicket<D> dataTicket, D data) implements MultiloaderPacket {
    public static final CustomPacketPayload.Type<EntityDataSyncPacket<?>> TYPE = new Type<>(GeckoLibConstants.id("entity_data_sync"));
    public static final StreamCodec<RegistryFriendlyByteBuf, EntityDataSyncPacket<?>> CODEC = StreamCodec.of((buf, packet) -> {
        SerializableDataTicket.STREAM_CODEC.encode(buf, packet.dataTicket);
        buf.writeVarInt(packet.entityId);
        buf.writeBoolean(packet.isReplacedEntity);
        ((StreamCodec)packet.dataTicket.streamCodec()).encode(buf, packet.data);
    }, buf -> {
        final SerializableDataTicket dataTicket = SerializableDataTicket.STREAM_CODEC.decode(buf);

        return new EntityDataSyncPacket<>(buf.readVarInt(), buf.readBoolean(), dataTicket, dataTicket.streamCodec().decode(buf));
    });

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @Override
    public void receiveMessage(@Nullable Player sender, Consumer<Runnable> workQueue) {
        workQueue.accept(() -> {
            Entity entity = ClientUtil.getLevel().getEntity(this.entityId);

            if (entity == null)
                return;

            if (!this.isReplacedEntity) {
                if (entity instanceof GeoEntity geoEntity)
                    geoEntity.setAnimData(this.dataTicket, this.data);

                return;
            }

            if (RenderUtil.getReplacedAnimatable(entity.getType()) instanceof GeoReplacedEntity replacedEntity)
                replacedEntity.setAnimData(entity, this.dataTicket, this.data);
        });
    }
}
