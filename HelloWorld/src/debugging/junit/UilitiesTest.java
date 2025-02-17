package debugging.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UilitiesTest {
private Utilities uilities;
    @BeforeEach
    void setup(){
        uilities = new Utilities();
    }

    @Test
    void everyNthChar() {
        char[] output = uilities.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] { 'e', 'l'}, output);
        char[] output2 = uilities.everyNthChar(new  char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @Test
    void removePairs() {
        String input = "AABCDDEFF";
        String output = uilities.removePairs(input);
       String expectedOutput = "ABCDEF";
        assertEquals(expectedOutput, output);

        assertNull(null, uilities.removePairs(null));
        assertEquals("A", uilities.removePairs("A"));
        assertEquals("", uilities.removePairs(""));

        assertEquals("ABCABDEF", uilities.removePairs("ABCCABDEEF"));

    }

    @Test
    void converter() {
        assertEquals(300, uilities.converter(10, 5));
        int a = 10;
        int b=0;
        assertThrows(ArithmeticException.class, () -> uilities.converter(a, b) );
    }

    @Test
    void nullIfOddLengths() {
        assertNull(uilities.nullIfOddLength("odd"));
        assertNotNull(uilities.nullIfOddLength("even"));
    }
}