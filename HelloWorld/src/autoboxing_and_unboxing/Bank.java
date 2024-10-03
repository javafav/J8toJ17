package autoboxing_and_unboxing;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Customer> customers = new ArrayList<>(5000);;

     public Bank(String name) {
        this.name = name;
    }
    public void addNewCustomer(String customerName, double initialDeposit){
       if(getCustomer(customerName) == null){
           Customer customer = new Customer(customerName, initialDeposit);
           customers.add(customer);
           System.out.println("New Customer %s is created "  + customerName);

       }
    }

    private Customer getCustomer(String customerName) {

        for (var customer : customers) {
            if (customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        System.out.printf("Customer (%s) wasn't found %n", customerName);

        return null;
    }

    public void addTransaction(String name, double transactionAMount ){
        Customer customer = getCustomer(name);
        if(customer  != null){
            customer.transactions().add(transactionAMount);
        }
    }



    public void pirntStatment(String customerName){
        Customer customer = getCustomer(customerName);
        if(customer == null){
            return;
        }

        System.out.println("_".repeat(30));
        System.out.println("Customer Name: " + customer.name());
        System.out.println("Transaction: ");
        for(double d : customer.transactions()){
            System.out.printf("$%10.2f (%s) %n", d , d < 0 ? "debit" : "credit");
        }

    }
}
