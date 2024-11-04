package oop.streams.student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .collect(Collectors.toList());

        Set<Student> australianStudents = students.stream()
                .filter(std -> std.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());

        System.out.println(" # of Aus Student " + australianStudents.size());


        Set<Student> underThirty = students.stream()
                // .filter(std -> std.getCountryCode().equals("AU"))
                .filter(std -> std.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());

        System.out.println(" # of Aus  Student of Age < 30 =  " + underThirty.size());

        Set<Student> youngAussies1 = new TreeSet<>(Comparator.comparing(
                Student::getStudentId));

        youngAussies1.addAll(australianStudents);
        youngAussies1.retainAll(underThirty);
        youngAussies1.forEach(s -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        var youngAussies2 = students.stream()
                // .filter(std -> std.getCountryCode().equals("AU"))
                .filter(std -> std.getAgeEnrolled() < 30)
                .filter(std -> std.getCountryCode().equals("AU"))
                .collect(() -> new TreeSet(Comparator.comparing(
                        Student::getStudentId)), TreeSet::add, TreeSet::addAll);

        // youngAussies2.forEach( (s) -> System.out.print(s.getStudentId() + " "));

//youngAussies2.forEach((Student) s -> System.out.println(s.getStudentId() + " "));

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (countryList1,nextCountry) -> countryList1 + " " + nextCountry );
        //"" + Au
        //Au  + US
        System.out.println(countryList);

        List<Integer> numbers = Arrays.asList(5, 10, 15);
        int sum = numbers.stream()
                .reduce(0, (total, num) -> total + num);
        System.out.println("Sum: " + sum);  // Output: Sum: 30

    }
}
