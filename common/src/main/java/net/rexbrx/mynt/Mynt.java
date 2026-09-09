package net.rexbrx.mynt;

import net.rexbrx.mynt.init.MyntCore;

public final class Mynt {
    public static final String ID = MyntConstants.MODID;

    public static void init() {
        MyntCore.init();
        MyntCore.ModWarn(MyntConstants.MOD_NAME);
    }
}
