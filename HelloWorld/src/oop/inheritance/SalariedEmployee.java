package oop.inheritance;

public class SalariedEmployee extends Employee {
    private double annulSalary;
    private boolean isRetired;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, String birthDate, String hireDate, double annulSalary) {
        super(name, birthDate,  hireDate);
        this.annulSalary = annulSalary;
        this.isRetired = isRetired;
    }

    @Override
    public double collectPay() {
        double payCheck =  annulSalary / 26;
        double adjustedPay = (isRetired) ? 0.9 * payCheck : payCheck;
    return (int) adjustedPay;
    }

    public void retire() {
        terminate("01/01/2022");
        isRetired = true;


    }
}
