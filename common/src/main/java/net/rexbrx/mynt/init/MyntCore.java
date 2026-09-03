package net.rexbrx.mynt.init;

import net.rexbrx.mynt.utils.myLogger;

public class MyntCore {
    public static void init() {
        myLogger.myDebug("|-----------------------------|");
        myLogger.myDebug("|                             |");
        myLogger.myDebug("| Hello World, from Mynt4! ;) |");
        myLogger.myDebug("|                             |");
        myLogger.myDebug("| v3.6.2 | release |  RexBRX  |");
        myLogger.myDebug("|                             |");
        myLogger.myDebug("|-----------------------------|");
    }

    public static void ModWarn(String modid) {
        myLogger.myDebug("Mynt Inilialized for: " + modid);
    }
}
