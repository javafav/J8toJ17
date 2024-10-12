package oop.generics;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {

        int studentCount = 10;

        List<Student> students = new ArrayList<>();

        for(int i = 0; i<studentCount; i++){
            Student  student= new Student();
            students.add(student);
        }

        students.add(new LpaStudent());
        printStudent(students);

        List<LpaStudent> lpaStudents = new ArrayList<>();

        for(int i = 0; i<studentCount; i++){
            lpaStudents.add( new LpaStudent());
        }

        printStudent(lpaStudents);

        var queryList = new QueryList<LpaStudent>(lpaStudents);
        var matches = queryList.getMatches(
                "Course", "Java"
        );
        printStudent(matches);

    }
    public static void printStudent(List<? extends Student> students){
        for(var student : students){
            System.out.println(student);
        }
        System.out.println();
    }
}
