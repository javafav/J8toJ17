package threads;

public class BankAccount {
    private double balance;
    private String name;

    private final Object lockName = new Object();
    private final Object lockBalance = new Object();

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized (lockName) {
            this.name = name;
            System.out.println("Updated name =  " + this.name);
        }

    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        try {
            System.out.println("Waiting 3 seconds before deposit!!!");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Double boxedBalance = balance;
        synchronized (lockBalance) {
            double origBalance = balance;
            balance += amount;//STARTING BALANCE: %.0f, DEPOSIT (%0.f) : NEW BALANCE = %.0f%n
            System.out.printf("STARTING BALANCE: %.0f DEPOSIT (%.0f) : NEW BALANCE = %.0f%n ", origBalance, amount, balance);
            addPromoDollars(amount);
        }


    }

    private void addPromoDollars(double amount) {
        if (amount >= 5000) {
            synchronized (lockBalance) {
                System.out.println("Congratulations, you earned a promotional deposit");
                balance += 25;
            }
        }
    }

    public synchronized void withdraw(double amount) {
        try {
            System.out.println("Waiting 2 seconds before withdraw!!!");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double origBalance = balance;

        if (amount <= balance) {
            balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f) : NEW BALANCE = %.0f%n", origBalance, amount, balance);
        } else {
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f) : INSUFFICIENT FUNDS ", origBalance, amount);
        }


    }


}

