package oop.inheritance;

public class Employee extends Worker {
   protected long employeeId;
    protected String hireDate;

    public Employee() {

    }

    public Employee(String name, String birthDate, String endDate, long employeeId, String hireDate) {
        super(name, birthDate);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }
}
