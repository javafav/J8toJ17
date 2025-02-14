package debugging.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTestParameterized {
    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount("Taimur", "Ali Khan", 1200.00);
        System.out.println("Running a test...");
    }

    // Method to provide test data
    static Stream<Object[]> bankAccountProvider() {
        return Stream.of(
                new Object[]{100.0, true, 1300.0},  // Expected balance = initial 1200 + deposit 100
                new Object[]{200.0, false, 1400.0}, // Expected balance = initial 1200 + deposit 200
                new Object[]{300.0, true, 1500.0}   // Expected balance = initial 1200 + deposit 300
        );
    }

    @ParameterizedTest
    @MethodSource("bankAccountProvider")
    void testDeposit(double amount, boolean branch, double expectedBalance) {
        account.deposit(amount, branch);
        assertEquals(expectedBalance, account.getBalance(), 1); // Allowing minor floating-point differences
    }
}
