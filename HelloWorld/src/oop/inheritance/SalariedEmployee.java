package oop.inheritance;

import java.util.Date;

public class SalariedEmployee extends  Employee{
    private double annulSalary;
    boolean isRetired;

    public SalariedEmployee(){}

    public SalariedEmployee(String name, String birthDate, String endDate, long employeeId, String hireDate, double annulSalary, boolean isRetired) {
        super(name, birthDate, endDate, employeeId, hireDate);
        this.annulSalary = annulSalary;
        this.isRetired = isRetired;
    }

    public void retire(){
        Date hireDate = new Date(super.hireDate);
        Date endDate = new Date(super.endDate);

        Date month = endDate - hireDate;
    }
}
