package io.student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WritingFiles {
    public static void main(String[] args) {

        String header = """
                Student Id,Country Code,Enrolled Year,Age,Gender,\
                Experienced,Course Code,Engagement Month,Engagement Year,\
                Engagement Type""";

        Course jmc = new Course("JMC", "Java Master Class");
        Course pymc = new Course("PYC", "Python Master Class");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(5)
                .toList();
//        System.out.println(header);
//        students.forEach(student -> student.getEngagementRecords().forEach(System.out::println));

        Path path = Path.of("students.csv");
//        try{
//            Files.writeString(path, header);
//            for(Student student : students){
//                Files.write(path, student.getEngagementRecords(), StandardOpenOption.APPEND);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            List<String> data = new ArrayList<>();
            data.add(header);
            for (Student student : students) {
                data.addAll(student.getEngagementRecords());
            }
            Files.write(path, data);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
