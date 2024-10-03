package autoboxing_and_unboxing;

public class CustomerAndBankTest {
    public static void main(String[] args) {
        Customer bob = new Customer("Bob", 500);
        System.out.println(bob);

        Customer marry = new Customer("Marry", 100);
        System.out.println(marry);

        Bank bank = new Bank("Home Bank");
        bank.addNewCustomer("Sara", 400);

        bank.addTransaction("Sara", -14.0);
        bank.addTransaction("Sara", 55.0);
        bank.pirntStatment("Sara");

    }
}
