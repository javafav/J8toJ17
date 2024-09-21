package oop.inheritance;

public class WorkerTest {
    public static void main(String[] args) {
     Employee timy = new Employee("Tim", "11/11/1985",  "01/01/2020");

        System.out.println(timy);
        System.out.println("Age = "+ timy.getAge());
        System.out.println("Pay = " + timy.collectPay());

        SalariedEmployee john = new SalariedEmployee("Tim", "11/11/1990",  "01/01/2021", 35000);

        System.out.println(john);
        System.out.println("Age = "+ john.getAge());
        System.out.println("John Pay Check =  $" + john.collectPay());
        john.retire();
        System.out.println("John Pension's Check =  $" + john.collectPay());


        HourlyEmployee mary = new HourlyEmployee("Mary", "01/01/2000", " 01/01/2022", 15);

        System.out.println(mary);
        System.out.println("Age = "+ mary.getAge());
        System.out.println("John Pay Check =  $" + mary.collectPay());

        System.out.println("John Pension's Check =  $" + mary.getDoublePay());


    }
}
