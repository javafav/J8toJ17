package oop.inheritance.polymorphism;

public class GasPoweredCar extends MyCar {
    private double avgKmPerLiter;
    private int cylinders;

    public GasPoweredCar(String description, double avgKmPerLiter) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
    }
}
