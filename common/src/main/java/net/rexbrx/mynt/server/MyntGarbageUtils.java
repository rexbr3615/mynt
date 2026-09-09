package net.rexbrx.mynt.server;

public class MyntGarbageUtils {
    public static void GarbageCollector() {
        System.gc();
    }
    public static void RuntimeGarbageCollector() {
        Runtime.getRuntime().gc();
    }
}
