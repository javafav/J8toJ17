package oop.shallow_deep_defensive_copy;

public class Student {
    private final String name;
    private final StringBuilder notes;

    public Student(String name, StringBuilder notes) {
        this.name = name;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", notes=" + notes +
                '}';
    }
}
