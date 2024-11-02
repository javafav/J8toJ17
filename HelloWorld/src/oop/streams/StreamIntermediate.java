package oop.streams;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediate {
    public static void main(String[] args) {
        IntStream.iterate((int) 'A', i -> i <= 'z', i -> i + 1)
                .filter(i -> Character.isAlphabetic(i))
                //     .dropWhile(i -> i < 'E')
                .takeWhile(i -> i < 'a')
                //  .filter(i -> i > 'E')
                //    .skip(4)
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println();

        Random random = new Random();
        Stream.generate(() -> random.nextInt((int) 'A', (int) 'Z' + 1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));

        int maxSeat = 100;
        int seatsInRow = 10;
        var stream = Stream.iterate(0, i -> i <= maxSeat, i -> i + 1)
                .map(i -> new Seat((char) ('A' + i / seatsInRow),
                        i % seatsInRow + 1))
                .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString));
//                .mapToDouble(Seat::price)
//                .boxed()
//                .map("%0.2f"::formatted);

          stream.forEach(System.out::println);

    }


}
