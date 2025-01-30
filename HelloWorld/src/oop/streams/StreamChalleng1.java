package oop.streams;

import java.util.*;
import java.util.stream.Collectors;

class ProductEntity {
    private String name;
    private String category;
    private double price;

    public ProductEntity(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + price + ")";
    }


}

class EmployeeClass {
    private String name;
    private String department;

    public EmployeeClass(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

public class StreamChalleng1 {
    public static void main(String[] args) {
        List<ProductEntity> products = Arrays.asList(
                new ProductEntity("Laptop", "Electronics", 1200),
                new ProductEntity("Phone", "Electronics", 800),
                new ProductEntity("TV", "Electronics", 1500),
                new ProductEntity("Sofa", "Furniture", 700),
                new ProductEntity("Chair", "Furniture", 200),
                new ProductEntity("Table", "Furniture", 450)
        );

        Map<String, Optional<ProductEntity>> collect = products.stream().collect(
                Collectors.groupingBy(ProductEntity::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(ProductEntity::getPrice))));

        collect.forEach((category, product) ->
                System.out.println(category + " -> " + product.orElse(null))
        );


        List<EmployeeClass> employees = Arrays.asList(
                new EmployeeClass("Alice", "HR"),
                new EmployeeClass("Bob", "IT"),
                new EmployeeClass("Charlie", "IT"),
                new EmployeeClass("David", "HR"),
                new EmployeeClass("Eve", "Finance"),
                new EmployeeClass("Frank", "Finance"),
                new EmployeeClass("Grace", "IT")
        );

        Map<String, Long> collect1 = employees.stream()
                .collect(
                        Collectors.groupingBy(EmployeeClass::getDepartment,
                                Collectors.counting()));



        collect1.forEach((key, value) ->
                System.out.println(key + " -> " + value)
        );


        String sentence = "Java is fun and Java is powerful but fun is relative";

        List<String> collect2 = Arrays.stream(sentence.split("\\\\s+\""))
                .map(String::toLowerCase)
                .distinct()
                .limit(3)
                .collect(Collectors.toList());
        collect2.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        //Convert a list of student names into a map where the key is the first letter of the name and the value is a list of names.
        List<String> students = List.of("Alice", "Bob", "Charlie", "David", "Anna");

     var result =   students.stream().collect(
             Collectors.groupingBy(
                     s -> s.charAt(0),
                     Collectors.joining(" | ", "{", "}")
             ));
     result.forEach((k, v) -> System.out.println(k +" : " + v));
    }





}
