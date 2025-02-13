package debugging.junit;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<Integer> grades;

    // Constructor
    public Student(String name, int age) {
        if (age < 5 || age > 100) {
            throw new IllegalArgumentException("Age must be between 5 and 100.");
        }
        this.name = name;
        this.age = age;
        this.grades = new ArrayList<>();
    }

    // Method to add a grade
    public void addGrade(int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        grades.add(grade);
    }

    // Method to get the average grade
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            throw new IllegalStateException("No grades available.");
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to check if student has passed (average grade >= 50)
    public boolean hasPassed() {
        return getAverageGrade() >= 50;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades); // Return a copy to maintain encapsulation
    }
}
