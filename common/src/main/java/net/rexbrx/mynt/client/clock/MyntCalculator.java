package net.rexbrx.mynt.client.clock;

public class MyntCalculator
{
    public static float Seconds(float seconds) {
        return 20 * seconds;
    }
    public static int Seconds(int seconds) {
        return 20 * seconds;
    }

    public static float Minutes(float minutes) {
        return 20 * (60 * minutes);
    }
    public static int Minutes(int minutes) {
        return 20 * (60 * minutes);
    }

    public static float Hours(float hours) {
        return 20 * (60 * (hours * 60));
    }
    public static int Hours(int hours) {
        return 20 * (60 * (hours * 60));
    }

    public static int Days(int days) {
        return Minutes(20) * days;
    }
    public static float Days(float days) {
        return Minutes(20) * days;
    }

    public static float CalcSizeByTimeInMinutes(float initSize, float finalSize, float time) {
        return (initSize - finalSize) * Minutes(time);
    }
    public static float CalcSizeByTimeInMinutes(float initSize, float finalSize, int time) {
        return (initSize - finalSize) * Minutes(time);
    }
}
