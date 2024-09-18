package oop.encapsulation;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
       this("1234", 100, "NoName","noemail@noemail.com", "(0300) 4098211");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber) {
        System.out.println("BankAccount constructor with parameters is called");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositInToAccount(double depositAmount){
        if(depositAmount < 0){
            System.out.println("Deposit can not be in -ve");
            return;
        }
        this.balance += depositAmount;
        System.out.println("Deposit of $" + depositAmount + " made. New balance is $" + balance);
    }

    public void withdrawFunds(double withdrawAmount){
        if(withdrawAmount > this.balance){
            System.out.println("Insufficient Funds! You only have $" + balance + " in your account.");
            return;

        }

        this.balance -= withdrawAmount;

        System.out.println("Withdraw of $" + withdrawAmount + " made. New balance is $" + balance);


    }
}
