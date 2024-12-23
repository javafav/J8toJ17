package oop.streams;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String name;
    private String subject;
    private int marks;

    public Student(int id, String name, String subject, int marks) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                '}';
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "John", "Math", 85),
                new Student(2, "Alice", "Math", 92),
                new Student(3, "Bob", "Science", 78),
                new Student(4, "Eve", "Science", 88),
                new Student(5, "Charlie", "English", 76),
                new Student(6, "David", "English", 80)
        );

       var minMarksBySubjectsOfStudents = students.stream().collect(Collectors.groupingBy(Student::getSubject,
                Collectors.minBy(Comparator.comparing(Student::getMarks))));
       minMarksBySubjectsOfStudents.forEach((marks, std) -> System.out.println(marks + " : "+ std ));

    }
}

