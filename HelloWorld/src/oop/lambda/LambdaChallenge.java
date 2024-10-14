package oop.lambda;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaChallenge {
    public static void main(String[] args) {


        Consumer<String> printTheParts = new Consumer<String>() {  // using anonymous classes
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for(String part : parts){
                    System.out.println(part);
                }
            }
        };


        Consumer<String> lambdaParts = sentence -> {
            String[] parts = sentence.split(" ");
            for(String part : parts){
                System.out.println(part);
            }
        };

        Consumer<String> printLambdaWord = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(part -> System.out.println(part));
        };

        Consumer<String> printLambdaWordConcise = sentence -> {
           Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };

        printTheParts.accept("Let's split this up into an array");
        lambdaParts.accept("Let's split this up into an array");
        printLambdaWord.accept("Let's split this up into an array");
        printLambdaWordConcise.accept("Let's split this up into an array");

     UnaryOperator<String> testString = source -> {
         StringBuilder returnVal = new StringBuilder();
         for(int i = 0; i < source.length(); i++){
             if(i % 2 == 1 ){
                 returnVal.append(source.charAt(i));
             }
         }
         return returnVal.toString();
     };

        System.out.println( testString.apply("1234567890") );
        System.out.println(everySecondChar(testString,"1234567890" ));

        String ILOVEC = String.valueOf(new Supplier<String>() {
            @Override
            public String get() {
                return "i love java";
            }
        });

        Supplier<String> ILOVEJAVA = () -> "i love java";
        String supplierResult = ILOVEJAVA.get();
        System.out.println(supplierResult);

    }
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < source.length(); i++){
            if(i % 2 == 1 ){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondChar(UnaryOperator<String> values, String hello ){
       return  values.apply(hello);
    }

}
