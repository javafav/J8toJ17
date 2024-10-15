package oop.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class MethodReferenceChallenge {

    private static Random random = new Random();

    public static void main(String[] args) {
        String[] names =   {"Anna", "Saad", "Marry", "Bob", "Sara", "Taimur"};

        UnaryOperator<String> toLowerCase = String::  toLowerCase;
        List<String> backedArray = Arrays.asList(names);

        backedArray.replaceAll(toLowerCase);
        System.out.println(backedArray);

        UnaryOperator<String> addInitialForMiddleName = name -> name + " "+ addInitialForMiddleName('A','S') + ".";

        UnaryOperator<String> addLastNameFromReversingTheFirstName = name -> name + " " + reverseString(name);

        List<String> backedArray1 = Arrays.asList(names);
        backedArray1.replaceAll(addInitialForMiddleName);
        System.out.println(backedArray1);

        List<String> backedArray2 = Arrays.asList(names);
        backedArray2.replaceAll(addLastNameFromReversingTheFirstName );
        System.out.println(backedArray2);


        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase,
                name -> name += " " + addInitialForMiddleName('D', 'M') + ".",
                name -> name += " " + reverseString(name, 0, name.indexOf(" ") ),
                MethodReferenceChallenge::reverseString




        ));

        applyChanges(names, list);
    }

    public static String reverseString(String str){
       return reverseString(str, 0 ,str.length());
    }

    public static String reverseString(String str, int startIndex, int endIndex){
        return new StringBuilder(str.substring(startIndex, endIndex))
                                .reverse().toString();
    }



    public static char addInitialForMiddleName(char startChar, char endChar){
       return (char) random.nextInt((int)startChar, (int)endChar+ 1);
    }


    public static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions){
        List<String> backedArray = Arrays.asList(names);

        for(var function: stringFunctions  ){
            backedArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));

        }
    }
}
