package oop.inheritance.polymorphism;

public class MyCar {
   private String description;

    public MyCar(String description) {
        this.description = description;
    }

    public void startEngine(){
       System.out.println("Car -> startEngine");
   }
   public void drive(){
       System.out.println("Car -> driving, type is "  + this.getClass().getSimpleName());
       runEngine();

   }
   protected void runEngine(){
       System.out.println("Car -> runEngine");
   }
}
