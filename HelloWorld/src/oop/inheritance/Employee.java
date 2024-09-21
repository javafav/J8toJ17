package oop.inheritance;

public class Employee extends Worker {
   protected long employeeId;
    protected String hireDate;

    private static int employeNo = 1;
    public Employee() {

    }

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.employeeId = Employee.employeNo++;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}
