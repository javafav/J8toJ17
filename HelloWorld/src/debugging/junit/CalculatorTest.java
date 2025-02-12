package debugging.junit;


import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @org.junit.jupiter.api.Test
    void testAddition() {
        assertEquals(10, calculator.add(7, 3));
    }

    @org.junit.jupiter.api.Test
    void testSubtraction() {
        assertEquals(4, calculator.subtract(9, 5));
    }

    @org.junit.jupiter.api.Test
    void testMultiplication() {
        assertEquals(12, calculator.multiply(4, 3));
    }

    @org.junit.jupiter.api.Test
    void testDivision() {
        assertEquals(2.5, calculator.divide(5, 2), 0.01);
    }

    @org.junit.jupiter.api.Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}

