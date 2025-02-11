package debugging.junit;

public class BankAccount {
    private String firstname;
    private String lastName;
    private double balance;

    public BankAccount(String firstname, String lastName, double balance) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.balance = balance;
    }

    public double deposit(double amount, boolean branch){
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch){
        balance -= amount;
        return balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
