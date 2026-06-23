package net.rexbrx.mynt.utils;

public class myGarbageUtils {
    public static void GarbageCollector() {
        System.gc();
    }
    public static void RuntimeGarbageCollector() {
        Runtime.getRuntime().gc();
    }
}
