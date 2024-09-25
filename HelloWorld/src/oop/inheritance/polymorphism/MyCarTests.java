package oop.inheritance.polymorphism;

public class MyCarTests {
    public static void main(String[] args) {
     MyCar car = new MyCar("2022 Blue Ferrari 296 GTS");
     runRace(car);
    }
    public static void runRace(MyCar car){
        car.startEngine();
        car.drive();
    }
}
