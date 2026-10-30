package net.rexbrx.mynt.morehitboxes.internal;

import net.rexbrx.mynt.geckolib.event.GeoRenderEvent;

public class GeckoLibEvents {

    public static void incrementCurrentRenderTick(GeoRenderEvent.Entity.Post event) {
        if (event.getEntity() instanceof GeckoLibMultiPartMob multiPartMob) {
            multiPartMob.moreHitboxes$updateRenderTick();
        }
    }
}
