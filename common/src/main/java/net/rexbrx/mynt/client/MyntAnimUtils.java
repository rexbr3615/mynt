package net.rexbrx.mynt.client;

public class MyntAnimUtils {
    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static float lerp(float start, float end, float progress) {
        return start + (end - start) * clamp(progress, 0.0F, 1.0F);
    }

    public static double lerp(double start, double end, double progress) {
        return start + (end - start) * clamp(progress, 0.0, 1.0);
    }

    public static float interpolatePartialTicks(float previous, float current, float partialTicks) {
        return lerp(previous, current, clamp(partialTicks, 0.0F, 1.0F));
    }

    public static float normalizeAngle(float angle) {
        float result = angle % 360.0F;
        if (result < -180.0F) {
            result += 360.0F;
        }
        if (result >= 180.0F) {
            result -= 360.0F;
        }
        return result;
    }

    public static float deltaAngle(float current, float target) {
        return normalizeAngle(target - current);
    }

    public static float animateAngle(float current, float target, float maxDelta) {
        float delta = deltaAngle(current, target);
        if (delta > maxDelta) {
            return current + maxDelta;
        }
        if (delta < -maxDelta) {
            return current - maxDelta;
        }
        return current + delta;
    }

    public static float animateValue(float current, float target, float speed) {
        if (current < target) {
            return Math.min(current + Math.abs(speed), target);
        }
        if (current > target) {
            return Math.max(current - Math.abs(speed), target);
        }
        return current;
    }

    public static float easeInOutQuad(float t) {
        t = clamp(t, 0.0F, 1.0F);
        return t < 0.5F ? 2.0F * t * t : -1.0F + (4.0F - 2.0F * t) * t;
    }

    public static float easeInOutCubic(float t) {
        t = clamp(t, 0.0F, 1.0F);
        return t < 0.5F ? 4.0F * t * t * t : (float) (1.0 - Math.pow(-2.0F * t + 2.0F, 3) / 2.0);
    }

    public static float smoothStep(float edge0, float edge1, float x) {
        if (edge0 == edge1) {
            return 0.0F;
        }
        float t = clamp((x - edge0) / (edge1 - edge0), 0.0F, 1.0F);
        return t * t * (3.0F - 2.0F * t);
    }

    public static float oscillate(float time, float period) {
        if (period <= 0.0F) {
            return 0.0F;
        }
        return (float) Math.sin((time / period) * Math.PI * 2.0F);
    }
}
