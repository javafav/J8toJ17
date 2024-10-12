package oop.nested_classes;

import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {

        private String sortField;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortField) {
            this.sortField = sortField;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            if (sortField.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            } else {
                return o1.name.compareTo(o2.name);
            }


        }
    }



    private int employeeId;
    private String name;
    private int yearStarted;





    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }

    public String getName() {
        return name;
    }
}
