package oop.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{
 private static int LAST_ID = 100;
 private int id;


    public PlainOld() {
        id = LAST_ID++;
        System.out.println("Creating the PlainOld Object "+ id);
    }
}

public class MethodReference {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "ALi", "Bob", "Sara", "Marry", "Tom", "Zio"
        ));

        list.forEach(System.out::println);

        calculator(Integer::rotateLeft, 10, 5);

        Supplier<PlainOld> plainOldSupplier = PlainOld::new;

        PlainOld plainOldPojo = plainOldSupplier.get();

        System.out.println("Getting Array");
        seedArray(PlainOld::new, 10);

        calculator(String::concat, "Hello", " World");
        calculator((s1, s2) -> s1 +  s2, "Hello", " World");

        BiFunction<String, String, String> b1 = String::concat;
        BinaryOperator<String> b2 = String::concat;
        UnaryOperator<String> b3  = String::toUpperCase;


        System.out.println(b1.apply("Hello", " Wold"));
        System.out.println(b2.apply("Hello", " Wold"));

        System.out.println(b3.apply("Hello"));

        String transform = "hello".transform(b3);
        System.out.println(transform);
        transform = transform.transform(String::toLowerCase);
        System.out.println(transform);

        Function<String, Boolean> isEmpty =  String::isEmpty;
        Boolean apply = isEmpty.apply(transform);
        System.out.println(apply);





    }

    public static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of Operation: " + result);
    }

    public static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){

        PlainOld[] array = new PlainOld[10];
        Arrays.setAll(array, i -> reference.get());
        return array;


    }

}
