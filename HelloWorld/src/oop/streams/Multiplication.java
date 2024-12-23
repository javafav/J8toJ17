package oop.streams;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // ToString method for printing
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + '}';
    }

    // Sample list of employees
    public static List<Employee> getEmployees() {
        return List.of(
                new Employee(1, "Alice", "IT", 60000),
                new Employee(2, "Bob", "HR", 50000),
                new Employee(3, "Charlie", "Finance", 70000),
                new Employee(4, "Diana", "IT", 80000),
                new Employee(5, "Edward", "Finance", 55000),
                new Employee(6, "Fiona", "HR", 45000),
                new Employee(7, "George", "IT", 90000)
        );
    }
}



public class Multiplication {
    public static void main(String[] args) {
//        int[] num = {5,7};
//        int prod = Arrays.stream(num).reduce(num[0], Integer::min);
//        System.out.println(prod);
//
//        List<String> combines = List.of("Ali", "Fahad", "Saad");
//        String string = combines.stream().reduce("", (a, b) -> a + b + " ");
//        System.out.println(string);
//
//
//        int reduce = Arrays.stream(num).map(n -> n * n).reduce(1, (n, m) -> n * m);
//        System.out.println(reduce);
//
//        List<String> phones = List.of("123-456-789", "789-456-134");
//        List<String> maskedNumbers = phones.stream().map(ph -> "XXX-XX" + ph.substring(5, 9)).toList();

        List<Employee> employees = Employee.getEmployees();


        // Example 1: Filter employees with salary > 60,000
        List<Employee> highestEmplyed = employees.stream().filter(emp -> emp.getSalary() > 60000).collect(Collectors.toList());

        // Example 2: Get names of all employees in the IT department

        employees.stream().filter(emp -> emp.getDepartment().equals("IT") ).map(e -> e.getName()).forEach(System.out::println);
// Example 3: Find the employee with the highest salary

        String s = employees.stream().max(Comparator.comparing(Employee::getSalary)).map(e -> e.getName()).orElse("No Empllyee found");

        // Example 4: Calculate the average salary of employees

        double avgsalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);

        // Example 5: Group employees by department
       var demartemts = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
       demartemts.forEach((de, em) -> System.out.println(de + " : " + em));
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
               Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
               ));



    }
}
