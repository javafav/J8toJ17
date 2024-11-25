package hackerrank;

import java.util.Arrays;

public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] testString = {"Hello", "World"};
        String hello = Arrays.stream(testString).reduce("", (a, b) -> a + " " + b);
        System.out.println(hello);
    }
}
