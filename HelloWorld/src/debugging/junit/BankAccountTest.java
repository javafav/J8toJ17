package debugging.junit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

 class BankAccountTest {
private BankAccount account;
private static int count;

@BeforeAll
public static void beforeClass(){
    System.out.println("This executes before any test cases. Count = " + count++);
}


    @BeforeEach
    public  void setup(){
        account = new BankAccount("Joe", "Doe", 1000.00);
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {

        double balance = account.deposit(200.00, true);

        assertEquals(1200.00, balance);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
      double balance = account.withdraw(500, true );
      assertEquals(500, balance);
    }

    @org.junit.jupiter.api.Test()
    void withdraw_notBranch() {

        assertThrows(IllegalArgumentException.class,  () -> account.withdraw(600, false));
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200, account.getBalance());
    }

    @AfterEach
     void afterEach(){
        System.out.println("Count = " + count++);
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("This executes after all tests. Count = " + count++);
    }

//    @org.junit.jupiter.api.Test
//    public void dummyTest(){
//        assertEquals(21,21);
//
//    }

}