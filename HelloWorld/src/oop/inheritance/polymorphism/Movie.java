package oop.inheritance.polymorphism;

public class Movie {
    private String title;

    public Movie(String name) {
        this.title = name;
    }

    public void watch(){

        String movieType = this.getClass().getSimpleName();
        System.out.println(title + " is a type of " + movieType);
    }

    public static Movie getMovie(String movieType, String title){
        return switch (movieType.toUpperCase().charAt(0)){
            case 'A' -> new AdventureMovie(title);
            case 'C' -> new ComedyMovie(title);
            case 'M' -> new ScienceMovie(title);
            default -> new Movie(title);
        };
    }
}
