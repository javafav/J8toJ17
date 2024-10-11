package comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Employee implements Comparable {
    private String employeeName;
     int employeeId;

    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("Sany"),
                new Employee("Khan"),
                new Employee("Fahad")
        };

        Employee[] employees1 = new Employee[]{
                new Employee("Ziya", 001),
                new Employee("Shahid", 002),
                new Employee("Hassan", 000)
        };

        Arrays.sort(employees);
        Arrays.sort(employees1, new EmployeeComparator());
        System.out.println(Arrays.toString(employees));

        System.out.println(Arrays.toString(employees1));

    }



    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee(String employeeName, int employeeId) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return employeeName + "\n";
    }

    @Override
    public int compareTo(Object o) {
       Employee e = (Employee) o;
       return this.employeeName.compareTo(e.employeeName);

    }
}
class EmployeeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
      return   Integer. valueOf(o1.employeeId) .compareTo (                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           Integer. valueOf(o2.employeeId));
    }
}