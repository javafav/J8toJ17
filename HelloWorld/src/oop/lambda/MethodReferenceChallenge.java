package oop.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class MethodReferenceChallenge {
    public static void main(String[] args) {
        String[] names =   {"Anna", "Saad", "Marry", "Bob", "Sara", "Taimur"};

        UnaryOperator<String> toLowerCase = name -> name.toLowerCase();
        List<String> backedArray = Arrays.asList(names);

        backedArray.replaceAll(toLowerCase);
        System.out.println(backedArray);
    }
}
