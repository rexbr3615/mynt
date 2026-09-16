package net.rexbrx.mynt.morehitboxes.network;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.network.ConfigurationTask;
import net.neoforged.neoforge.network.configuration.ICustomConfigurationTask;
import net.rexbrx.mynt.morehitboxes.MoreHitboxesMod;
import net.rexbrx.mynt.morehitboxes.internal.HitboxDataLoader;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

@ApiStatus.Internal
public record SyncHitboxDataTask() implements ICustomConfigurationTask {
    public static final Type TYPE = new Type(ResourceLocation.fromNamespaceAndPath(MoreHitboxesMod.MOD_ID, "sync_hitbox_data"));

    @Override
    public void run(Consumer<CustomPacketPayload> sender) {
        SyncHitboxDataPayload payload = new SyncHitboxDataPayload(HitboxDataLoader.HITBOX_DATA.getHitboxData());
        sender.accept(payload);
    }

    @Override
    public @NotNull Type type() {
        return TYPE;
    }
}
