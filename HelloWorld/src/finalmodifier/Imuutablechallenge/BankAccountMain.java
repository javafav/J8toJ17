package finalmodifier.Imuutablechallenge;

import java.util.List;

public class BankAccountMain {
    public static void main(String[] args) {

//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 5000);
//        System.out.println(account);

        BankCustomer joe = new BankCustomer("Joe", 500.00, 100000);
        System.out.println(joe);

        List<BankAccount> accounts = joe.getAccounts();
        accounts.clear();
        System.out.println(joe);

        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, 15000));
        System.out.println(joe);

    }
}
