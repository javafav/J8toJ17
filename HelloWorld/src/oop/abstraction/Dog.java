package oop.abstraction;

public class Dog  extends Animal{


    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if(speed.equalsIgnoreCase("slow")){
            System.out.println(explicitType() +  " is walking");
        }else {

            System.out.println(explicitType() +  " is running");
        }
    }

    @Override
    public void makeNoise() {
      if(type.equals("Wolf")){
          System.out.print("Howling!!!");
        }else {
          System.out.print("Woof!!!");
      }
    }
}
