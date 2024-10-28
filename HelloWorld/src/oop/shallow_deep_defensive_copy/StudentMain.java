package oop.shallow_deep_defensive_copy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        StringBuilder bobNotes = new StringBuilder();
        StringBuilder timNotes = new StringBuilder("Tim Struggles with generics");

        Student bob = new Student("Bob", bobNotes);

        Student tim = new Student("Tim", timNotes);


        List<Student> students = new ArrayList<>(List.of(bob, tim));
        List<Student> studentsFirstCopy = new ArrayList<>(students);
        List<Student> studentsSecondCopy = List.copyOf(students);

        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
        //studentsSecondCopy.add(new Student("Bonnie", new StringBuilder()));
       studentsFirstCopy.sort(Comparator.comparing(student -> student.getNotes()  ));
        bobNotes.append(" Bob was one of my first student");

        StringBuilder bonnieNotes = studentsFirstCopy.get(2).getNotes();
        bonnieNotes.append("Bonnie is taking 3 of my courses");

        students.forEach(System.out::println);
        System.out.println("----------------------------------");

        studentsFirstCopy.forEach(System.out::println);
        System.out.println("----------------------------------");

        studentsSecondCopy.forEach(System.out::println);
        System.out.println("----------------------------------");

    }
}
