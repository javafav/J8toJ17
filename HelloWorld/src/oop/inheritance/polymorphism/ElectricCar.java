package oop.inheritance.polymorphism;

public class ElectricCar  extends MyCar {
    private double avgKmPerLiter;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerLiter) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
    }
}
