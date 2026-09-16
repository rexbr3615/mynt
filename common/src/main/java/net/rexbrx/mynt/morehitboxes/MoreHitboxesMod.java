package net.rexbrx.mynt.morehitboxes;

import net.minecraft.server.packs.PackType;
import net.rexbrx.mynt.MyntConstants;
import net.rexbrx.mynt.morehitboxes.internal.HitboxDataLoader;
import net.rexbrx.mynt.morehitboxes.platform.Services;
import org.jetbrains.annotations.ApiStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApiStatus.Internal

public class MoreHitboxesMod {
    public static final String MOD_ID = MyntConstants.MODID;
    public static final String MOD_NAME = "More Hitboxes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        Services.RESOURCE_PACK_PROVIDER.register(PackType.SERVER_DATA, HitboxDataLoader.HITBOX_DATA);
    }
}
