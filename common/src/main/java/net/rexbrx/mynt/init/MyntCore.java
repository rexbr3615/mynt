package net.rexbrx.mynt.init;

import net.rexbrx.mynt.log.MyntLog;

public class MyntCore {
    public static void init() {
        MyntLog.myDebug("|-----------------------------|");
        MyntLog.myDebug("|                             |");
        MyntLog.myDebug("| Hello World, from Mynt4! ;) |");
        MyntLog.myDebug("|                             |");
        MyntLog.myDebug("| v3.7.2 | release |  RexBRX  |");
        MyntLog.myDebug("|                             |");
        MyntLog.myDebug("|-----------------------------|");
    }

    public static void ModWarn(String modid) {
        MyntLog.myWarn("Mynt Inilialized for: " + modid);
    }
}
