package controlflow;

import java.util.Scanner;

public class GetInputFromConsole {
    public static void main(String[] args) {
        int currentYear = 2024;
        try{
            System.out.println(   getInputFromConsole(currentYear) );
        } catch (NullPointerException ex){
            System.out.println(   getInputFromScanner(currentYear) );
        }

    }

    private static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi , What is Your Name  ");

        String name = scanner.nextLine();

        System.out.println("Welcome " + name + " to Java ");

        System.out.println("What year you were born?");
        String dateOfBirth = scanner.nextLine();
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "Your Age is " + age;
    }

    public static String getInputFromConsole(int currentYear){

        String name = System.console().readLine("Hi , What is Your Name ");

        System.out.println("Welcome " + name + " to Java ");

        String dateOfBirth = System.console().readLine("What year you were born?");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "Your Age is " + age;
    }
}
