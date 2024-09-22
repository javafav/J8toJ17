package oop.inheritance;

public class Circle {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
       double PI = Math.PI;
        return (PI * radius * radius);
    }
}
