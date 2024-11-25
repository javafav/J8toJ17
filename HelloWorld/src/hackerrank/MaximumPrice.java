package hackerrank;

import java.util.Arrays;

public class MaximumPrice {
    public static void main(String[] args) {
        double[] prices = {1.5, 7.7,55.4,78.0,56.0};
        double maxPrice = Arrays.stream(prices).reduce(0, Double::max);
        System.out.println(maxPrice);
    }
}
