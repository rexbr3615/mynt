package net.rexbrx.mynt;

import net.rexbrx.mynt.init.MyntCore;
import net.rexbrx.mynt.utils.myLogger;

public final class Mynt {
    public static final String ID = MyntConstants.MODID;

    public static void init() {
        MyntCore.init();
    }
}
