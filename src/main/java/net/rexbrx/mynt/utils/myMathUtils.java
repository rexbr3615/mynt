package net.rexbrx.mynt.utils;

import java.util.Random;

public class myMathUtils {
    public static boolean isIntegerOrDouble(String value) {
        try {
            if (value.contains(".")) {
                Double.parseDouble(value);
            } else {
                Integer.parseInt(value);
            }
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    public static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    public static boolean isLong(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    public static boolean isFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            return min;
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double getDelta(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }
}
