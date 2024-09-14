package methods;

public class AreaCalculator {
    public static void main(String[] args) {
        System.out.println("Area of Circle, Radius is 5 = " + area(5));
        System.out.println("Area of  Rectangle, Width  is 5  and Height is 7 = " + area(5, 7));

        System.out.println("Area of Circle, Radius is 5 = " + area(-7));
    }
    private static final double PI = 3.141592653589793d;

    public static double area(double radius){

        if(radius < 0){
            return -1.0;
        }

        return   PI * radius * radius;
    }

    public static double area(double x, double y){
        if(x < 0 || y < 0){
            return -1.0;
        }

        return x * y;
    }
}
