package oop.inheritance.polymorphism;

public class MovieTest {
    public static void main(String[] args) {
        Movie theMovie = Movie.getMovie("Adventure", "Stars Wars");
        theMovie.watch();
        System.out.println();

        Movie comdeyMovie = Movie.getMovie("Comedy", "Sorry To Bother You");
        comdeyMovie.watch();
    }
}
