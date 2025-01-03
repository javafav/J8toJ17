package oop.streams;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

record Person(String firstName, String lastName, int age) {

    private final static String[] firsts =
            {"Able", "Bob", "Charlie", "Donna", "Eve", "Fred"};
    private final static String[] lasts =
            {"Norton", "OHara", "Petersen", "Quincy", "Richardson", "Smith"};

    private final static Random random = new Random();

    public Person() {
        this(firsts[random.nextInt(firsts.length)],
                lasts[random.nextInt(lasts.length)],
                random.nextInt(18, 100));
    }

    @Override
    public String toString() {
        return "%s, %s (%d)".formatted(lastName, firstName, age);
    }
}

public class ParallelStreamsAndMore {
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
                .parallel()
                .collect(Collectors.groupingBy(
                        Person::lastName,
                        Collectors.counting()) ) ;

        lastNameCount.entrySet().forEach(System.out::println);

        long total =0;
        for(long count : lastNameCount.values()){
            total += count;
        }
        System.out.println("Total person: " + total);





    }
}
