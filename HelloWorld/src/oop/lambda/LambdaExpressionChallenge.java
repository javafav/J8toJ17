package oop.lambda;

import java.util.Arrays;
import java.util.Random;

public class LambdaExpressionChallenge {
    public static void main(String[] args) {
        String[] firstName = {"Anna", "Saad", "Marry", "Bob", "Sara", "Taimur"};
        Arrays.asList(firstName).forEach(fName -> {
                    System.out.print(fName.toUpperCase() + " ");
        });
        System.out.println();
        System.out.println(Arrays.toString(firstName));


        Arrays.asList(firstName).forEach(name -> {
            char randomIndex = (char) new Random().nextInt(65,91);
            name = name + " " + randomIndex + ".";
            System.out.println(name);
        });

        System.out.println();
        System.out.println(Arrays.toString(firstName));

        Arrays.asList(firstName).forEach(name -> {
           StringBuilder reverseName =   new StringBuilder(name);

           name = name + " " + reverseName.charAt(0) + reverseName.substring(1, reverseName.length());

        });
      //  System.out.println();
       // System.out.println(Arrays.toString(firstName));
    }



}
