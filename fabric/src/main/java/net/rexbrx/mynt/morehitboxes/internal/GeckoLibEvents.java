package net.rexbrx.mynt.morehitboxes.internal;

import net.rexbrx.mynt.morehitboxes.internal.GeckoLibMultiPartMob;
import software.bernie.geckolib.event.GeoRenderEvent;

public class GeckoLibEvents {
    public static void init() {
        GeoRenderEvent.Entity.Post.EVENT.register(event -> {
            if (event.getEntity() instanceof GeckoLibMultiPartMob multiPartMob) {
                multiPartMob.moreHitboxes$updateRenderTick();
            }
        });
    }
}
