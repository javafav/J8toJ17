package oop.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenOddStream {
    public static void main(String[] args) {
        List<Integer> evenOdd = List.of(1,5,7,88,12,54,356,11,14,25,24,58,90);

        Map<String, List<Integer>> groupByEvenOdd = new HashMap<>();

        groupByEvenOdd =  evenOdd.parallelStream().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        List<Integer> even = groupByEvenOdd.getOrDefault("Even", List.of(0));

    }
}
