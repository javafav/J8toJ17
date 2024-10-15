package collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Mango", "Grapes", "Watermelon"};
        List<String> list = List.of(fruits);
        System.out.println(list);
        System.out.println(list.getClass().getName());

        List<String> groceries = new ArrayList<>(List.of("Pickle", "Cheese", "Mustard"));

        ArrayList<String> listOfFruits = new ArrayList<>(list);

        listOfFruits.add("Banana");
        System.out.println(listOfFruits);
        System.out.println(listOfFruits.getClass().getName());

        listOfFruits.addAll(groceries);

        System.out.println(listOfFruits);

        listOfFruits.add(0, "Cucumber");
        System.out.println(listOfFruits);

        //  System.out.println("Fruit list on index 2 is: " + listOfFruits.get(1)); //in ArrayList getting the element with the function  get() is used instead of [] operator

        //listOfFruits.remove("Cucumber");

        System.out.println(listOfFruits);

        if (listOfFruits.contains("Apple")) {
            System.out.println("Fruit list contains the apple ");
        }

        listOfFruits.add("Cucumber");

        System.out.println("Cucumber index is " + listOfFruits.indexOf("Cucumber"));

        System.out.println("Cucumber index is " + listOfFruits.lastIndexOf("Cucumber"));

        System.out.println(listOfFruits);

        boolean test = listOfFruits.removeAll(List.of("Cucumber", "Mango"));
        System.out.println(test);

        System.out.println(listOfFruits);

        listOfFruits.retainAll(List.of("Grapes", "Apple"));

        System.out.println(listOfFruits);

        listOfFruits.clear();
        System.out.println(listOfFruits);
        System.out.println(" Fruit list is empty " + listOfFruits.isEmpty());

        listOfFruits.addAll(List.of("Apple", "Mango", "Grapes", "Watermelon"));
        listOfFruits.addAll(Arrays.asList("Pickle", "Cheese", "Mustard"));

        System.out.println(listOfFruits);
        listOfFruits.sort(Comparator.naturalOrder());
        System.out.println(listOfFruits);

        listOfFruits.sort(Comparator.reverseOrder());
        System.out.println(listOfFruits);
       var newFruitList = listOfFruits.toArray(new String[listOfFruits.size()]);
        System.out.println(Arrays.toString(newFruitList));





    }
}
