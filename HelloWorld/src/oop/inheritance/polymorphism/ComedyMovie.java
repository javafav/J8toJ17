package oop.inheritance.polymorphism;

public class ComedyMovie extends Movie{
    public ComedyMovie(String name) {
        super(name);
    }

    @Override
    public void watch() {
        super.watch();
        System.out.printf("%s %n".repeat(3),
                "Funny",
                "More Funny",
                "Extra pro funny:");
    }
}
