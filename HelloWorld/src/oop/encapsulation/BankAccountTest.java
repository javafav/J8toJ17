package oop.encapsulation;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.setAccountNumber("154");
        account.setCustomerName("Marry");
        account.setEmail("test@test.com");
        account.setPhoneNumber("+92-300-1234567");
        account.setBalance(190);


        System.out.println("Your Banking Details are Name: " + account.getCustomerName() + " \t  Account Number: "+ account.getAccountNumber() +
                           "\t Your balance is $:" +account.getBalance() );

        System.out.println();

        System.out.println("Now testing  depositing the amount functionality");

        account.depositInToAccount(-10);

        account.depositInToAccount(14);

        System.out.println();

        System.out.println("Now testing  withdraw the amount functionality");

        System.out.println();

        account.withdrawFunds(205);
        account.withdrawFunds(14);

    }
}
