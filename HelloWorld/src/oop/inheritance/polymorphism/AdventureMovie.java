package oop.inheritance.polymorphism;

public class AdventureMovie  extends Movie{
    public AdventureMovie(String name) {
        super(name);
    }

    @Override
    public void watch() {
        super.watch();
        System.out.printf("%s %n".repeat(3),
                "Classic good versus evil conflict",
                "The sounds, visuals, and score",
                "The Star Wars mythology ");
    }
}
