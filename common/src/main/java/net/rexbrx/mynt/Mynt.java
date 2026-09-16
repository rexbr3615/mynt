package net.rexbrx.mynt;

import net.rexbrx.mynt.athena.impl.client.DefaultModels;
import net.rexbrx.mynt.init.MyntCore;
import net.rexbrx.mynt.morehitboxes.MoreHitboxesMod;

public final class Mynt {
    public static final String ID = MyntConstants.MODID;

    public static void init() {
        MyntCore.init();
        MyntCore.ModWarn(MyntConstants.MOD_NAME);
        //MoreHitboxesMod.init();
        //DefaultModels.init();
    }

}
