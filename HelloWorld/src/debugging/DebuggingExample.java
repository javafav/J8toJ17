package debugging;

public class DebuggingExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int sum = addNumbers(a, b);
        System.out.println("Sum: " + sum);
    }

    public static int addNumbers(int x, int y) {
        return x + y;
    }
}
