package oop.abstraction;

public class Fish extends Animal{


    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if(speed.equalsIgnoreCase("slow")){
            System.out.println(explicitType() +  " lazily swimming");
        }else {

            System.out.println(explicitType() +   "  darting frantically");
        }
    }

    @Override
    public void makeNoise() {
      if(type.equals("GoldFish")){
          System.out.println("Swish!!!");
        }else {
          System.out.println(" Splash!!!");
      }
    }
}
