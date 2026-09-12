package net.rexbrx.mynt.log;

public class MyntLog {
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

    public static void stastisticEntityGoal(String identifier, String x, String y, String z) {
        System.out.println("Entity goal is -> " + "x: " + x + "y: " + y + "z: " + z);
    }
}
