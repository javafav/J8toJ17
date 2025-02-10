package debugging;
public class DebugCondition {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) { //  Set a conditional breakpoint (i == 6)
                System.out.println("Found multiple of 3: " + i);
            }
        }
    }
}
