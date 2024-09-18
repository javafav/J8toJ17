package oop.encapsulation;

public class Customer {
    private String name;
    private  double creditLimit;
    private String email;

    public static void main(String[] args) {

        Customer customer1 = new Customer(); // no args constructor called
        System.out.println("Name: " + customer1.getName() + " Credit Limit: " + customer1.getCreditLimit() +
                " Email: " + customer1.getEmail());



        Customer customer2 = new Customer("Saira", "saira@gmail.com");
        System.out.println("Name: " + customer2.getName() + " Credit Limit: " + customer2.getCreditLimit() +
                " Email: " + customer2.getEmail());

        Customer customer3 = new Customer("Sana", 100, "Sana@gmail.com");
        System.out.println("Name: " + customer3.getName() + " Credit Limit: " + customer3.getCreditLimit() +
                " Email: " + customer3.getEmail());

    }

    public Customer() {
        this("Unknown",  "test@email.com");
    }

    public Customer(String name, String email) {
        this(name, 0.00, email);
    }

    public Customer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
