package oop.streams;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class ParallelStreamsAndMoreDemo {
    public static void main(String[] args) {
        var persons = Stream.generate(Person::new)
                .limit(10)
                .sorted(Comparator.comparing(Person::lastName))
                .toArray();
        // Arrays.asList(persons).forEach(System.out::println);

        for (var person : persons) {
            System.out.println(person);
        }
        System.out.println("------------------------------");


        Arrays.stream(persons).limit(10)
                .parallel()
                //   .sorted(Comparator.comparing(Person::lastName))
                .forEach(System.out::println);

        System.out.println("------------------------------");
        int sum = IntStream.range(1, 101).parallel().reduce(0, Integer::sum);
        System.out.println("The sum of the numbers from 1 to 100 is: " + sum);

        String humptyDumpty = """
                Humpty Dumpty sat on a wall.
                Humpty Dumpty had a great fall.
                All the king's horses and all the king's men
                couldn't put Humpty together again.
                """;

        System.out.println("------------------------------");
        var words = new Scanner(humptyDumpty).tokens().toList();
        words.forEach(System.out::println);
        System.out.println("------------------------------");

        // var backTogetherAgain = words.parallelStream().reduce("", (a, b) -> a + b + " ");

//
        var backTogetherAgain = words.parallelStream()
                .collect(Collectors.joining(" "));


        //       var backTogetherAgain = words.parallelStream().reduce("", (s1, s2) ->  s1.concat(s2).concat(" "));

        System.out.println(backTogetherAgain);


        Map<String, Long> lastNameCount = Stream.generate(Person::new)
                .limit(10000)
                .collect(Collectors.groupingByConcurrent(
                        Person::lastName,
                        Collectors.counting()));

        lastNameCount.entrySet().forEach(System.out::println);

        long total = 0;
        for (long count : lastNameCount.values()) {
            total += count;
        }
        System.out.println("Total person: " + total);

        System.out.println(lastNameCount.getClass().getName());
        var lastsCount =Collections.synchronizedMap(    // another way to maintain the order new ConcurrentSkipListMap<String, Long>();
                new TreeMap<String, Long>());

        Stream.generate(Person::new)
                .limit(10000)
                .parallel()
                .forEach(person -> lastsCount.merge(person.lastName(), 1L, Long::sum) );

        System.out.println(lastsCount);

        total = 0;
        for (long count : lastsCount.values()) {
            total += count;
        }
        System.out.println("Total person: " + total);

        System.out.println(lastsCount.getClass().getName());




    }
}
