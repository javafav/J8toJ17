package debugging.junit;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount account = new BankAccount("Joe", "Doe", 1000.00);
        double balance = account.deposit(200.00, true);

        assertEquals(1200.00, balance);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        fail("The method is not implemented");
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        fail("The method is not implemented");
    }

//    @org.junit.jupiter.api.Test
//    public void dummyTest(){
//        assertEquals(21,21);
//
//    }

}