package methods;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double first, double second) {

        long firstRounded = (long) (first * 1000);
        long secondRounded = (long) (second * 1000);
        return firstRounded == secondRounded;
    }
}