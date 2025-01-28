package oop.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PersonEntity {
    private String firstName;
    private String lastName;
    private CityEntity city;

    // Constructor
    public PersonEntity(String firstName, String lastName, CityEntity city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CityEntity getCity() {
        return city;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " from " + city.getName();
    }
}

class CityEntity {
    private String name;

    // Constructor
    public CityEntity(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class EmployeeEntity {
    String department;
    String role;
    String name;

    EmployeeEntity(String department, String role, String name) {
        this.department = department;
        this.role = role;
        this.name = name;
    }
}

public class StreamPractise {
    public static void main(String[] args) {
        // Example 1: Grouping names by their first letter and collecting uppercase versions
        List<String> names = List.of("Alice", "Anna", "Bob", "Brian", "Charlie");
        Map<Character, List<String>> collect = names.stream().collect(
                Collectors.groupingBy(name -> name.charAt(0),
                        Collectors.mapping(String::toUpperCase, Collectors.toList())));

        collect.forEach((key, val) -> System.out.println(key + " : " + val));

        // Example 2: Grouping names by their first letter and counting them
        Map<Character, Long> collect1 = names.stream().collect(
                Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));

        collect1.forEach((key, val) -> System.out.println(key + " : " + val));

        // Example 3: Grouping names by their first letter and concatenating names
        Map<String, String> collect2 = names.stream().collect(
                Collectors.groupingBy(name -> name.charAt(0) + " For ->",
                        Collectors.joining(" | ", "", "")));

        collect2.forEach((key, val) -> System.out.println(key + " : " + val));

        // Example 4: Grouping names by their first letter, transforming to uppercase, and concatenating
        Map<Character, String> collect3 = names.stream().collect(
                Collectors.groupingBy(name -> name.charAt(0),
                        Collectors.mapping(String::toUpperCase, Collectors.joining(" | "))));

        collect3.forEach((key, val) -> System.out.println(key + " : " + val));

        // Example 5: Grouping employees by department and role, collecting names
        List<EmployeeEntity> employees = List.of(
                new EmployeeEntity("IT", "Developer", "Alice"),
                new EmployeeEntity("IT", "Tester", "Bob"),
                new EmployeeEntity("HR", "Recruiter", "Charlie"),
                new EmployeeEntity("HR", "Recruiter", "Diana")
        );

        Map<String, Map<String, List<String>>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.department,                             // Group by department
                        Collectors.groupingBy(
                                emp -> emp.role,                          // Further group by role
                                Collectors.mapping(emp -> emp.name, Collectors.toList()) // Collect names
                        )
                ));

        grouped.forEach((dept, roles) -> {
            System.out.println(dept);
            roles.forEach((role, namess) -> System.out.println("  " + role + " : " + namess));
        });

        // Example 6: Grouping people by city and collecting last names
        List<PersonEntity> people = List.of(
                new PersonEntity("Alice", "Smith", new CityEntity("London")),
                new PersonEntity("Bob", "Johnson", new CityEntity("London")),
                new PersonEntity("Charlie", "Brown", new CityEntity("Paris")),
                new PersonEntity("David", "Smith", new CityEntity("Paris")),
                new PersonEntity("Emily", "Clark", new CityEntity("Tokyo"))
        );

        Map<CityEntity, List<String>> peopleGroupedByCity = people.stream()
                .collect(Collectors.groupingBy(
                        PersonEntity::getCity, HashMap::new,
                        Collectors.mapping(PersonEntity::getLastName, Collectors.toList())));

        peopleGroupedByCity.forEach((city, lastNames) ->
                System.out.println(city.getName() + " : " + lastNames));
    }
}
