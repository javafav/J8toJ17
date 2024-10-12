package oop.nested_classes;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ali", 2015 ),
                new Employee(10007, "Saad", 2011 ),
                new Employee(12004, "Sara", 2021 ),
                new Employee(13009, "Marry", 2020 ),
                new Employee(11001, "Tom", 2016 )

        ));

        employees.sort(new Employee.EmployeeComparator<>().reversed() );
        for(Employee e: employees){
            System.out.println(e);
        }
        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019,
                        "Target"),
                new StoreEmployee(10515, "Joe", 2021,
                        "Walmart"),
                new StoreEmployee(10105, "Tom", 2020,
                        "Macys"),
                new StoreEmployee(10215, "Marty", 2018,
                        "Walmart"),
                new StoreEmployee(10322, "Bud", 2016,
                        "Target")));

        StoreEmployee storeEmployee = new StoreEmployee();

        var comparator = storeEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator);

        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }

    }
}
