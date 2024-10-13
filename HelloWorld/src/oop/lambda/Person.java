package oop.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "%s".formatted(name);
    }



    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Khan"),
                new Person("Abif"),
                new Person("Ali"),
                new Person("Abdul Salam")
        ));
        System.out.println(persons);

        persons.removeIf(p -> p.name.startsWith("Ab"));
       // System.out.println(persons);
        persons.forEach(p -> System.out.println(p));
        String[] names = new String[]{"Ali", "Babar", "Cathy", "Dolly", "Marry", "Sara"};
        String[] randomlySelected = randomlySelected(20, names, () -> new Random().nextInt(0, names.length));

        System.out.println(Arrays.toString(randomlySelected));


    }

    public static String[] randomlySelected(int count, String[] names, Supplier<Integer> supplier){
        String[] selectedNames = new String[count];
        for(int i = 0; i< count; i++){
           selectedNames[i] = names[supplier.get()];
        }
        return selectedNames;
    }

}
