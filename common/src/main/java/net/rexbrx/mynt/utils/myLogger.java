package net.rexbrx.mynt.utils;

public class myLogger {
    public static void myPrint (String Input) {
        System.out.println("[MYNT]" + Input);
    }

    public static void myDebug (String Input) {
        System.out.println("[DEBUG]:" + Input);
    }

    public static void myInfo (String Input) {
        System.out.println("[INFO]:" + Input);
    }

    public static void myWarn (String Input) {
        System.out.println("[WARN]:" + Input);
    }

    public static void myError (String Input) {
        System.err.println("[ERROR]:" + Input);
    }
}
