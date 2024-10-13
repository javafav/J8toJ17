package oop.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Alpha", "Bravo", "Charlie", "Delta"));

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------");
        list.forEach(s -> System.out.println(s));

        System.out.println("----------------");
        list.forEach(s -> {
            char first = s.charAt(0);
            System.out.println(s + " means " + first);
        });

        double result0 = calculator(new Operation<Double>() {  // usage of anonymous classes
            @Override
            public Double operate(Double value1, Double value2) {
                return value1 + value2;
            }
        }, 5.0, 7.0);

        var result1 = calculator((a, b) -> a * b, 14.0, 3.0);
        var result2 = calculator((a, b) -> a / b, 14, 3);
        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Fahad", "Khan");

        System.out.println("----------------");
        list.addAll(List.of("Echo", "Easy", "East"));
        list.forEach(s -> System.out.println(s));

        System.out.println("----------------");
        list.removeIf(s -> s.startsWith("Ea"));
        list.forEach(s -> System.out.println(s));

        System.out.println("----------------");
        list.replaceAll(s -> s.charAt(0) + " - for " + s.toUpperCase());
        list.forEach(s -> System.out.println(s));

        String[] emptyString = new String[10];
        System.out.println(Arrays.toString(emptyString));

        Arrays.fill(emptyString, "");
        System.out.println(Arrays.toString(emptyString));

        Arrays.setAll(emptyString, (i) -> "" + (i+1) + ".");
        System.out.println(Arrays.toString(emptyString));


    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of Operation: " + result);
        return result;
    }
}
