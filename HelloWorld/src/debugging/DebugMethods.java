package debugging;
public class DebugMethods {
    public static void main(String[] args) {
        int num = 5;
        int squared = square(num);
        int cubed = cube(num);
        System.out.println("Squared: " + squared + ", Cubed: " + cubed);
    }

    public static int square(int x) {
        return x * x;  //  Step Into here
    }

    public static int cube(int x) {
        return x * x * x;  //  Step Into here
    }
}

