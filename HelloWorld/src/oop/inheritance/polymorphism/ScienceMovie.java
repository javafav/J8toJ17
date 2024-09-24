package oop.inheritance.polymorphism;

public class ScienceMovie extends Movie{
    public ScienceMovie(String name) {
        super(name);
    }

    @Override
    public void watch() {
        super.watch();
        System.out.printf("%s %n".repeat(3),
                "Science",
                "Fiction",
                "Movie");
    }
}
