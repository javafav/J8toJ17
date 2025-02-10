package debugging;

public class DebugLoop {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i <= 5; i++) {  // Set a breakpoint
            total += i;
        }
        System.out.println("Total Sum: " + total);
    }
}
