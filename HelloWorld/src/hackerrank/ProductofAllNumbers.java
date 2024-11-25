package hackerrank;

import java.util.Arrays;

public class ProductofAllNumbers {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 7, 9};

        long product = Arrays.stream(numbers).asLongStream().reduce(1, (a, b) -> a * b);
        System.out.println(product);
    }
}
