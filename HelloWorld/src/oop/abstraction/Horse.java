package oop.abstraction;

public class Horse extends Mammal{


    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void shedHair() {
        System.out.println(explicitType() + " sheds in the spring");
    }

    @Override
    public void move(String speed) {
        System.out.println(explicitType() + " ");
        System.out.println( (speed.equals("slow") ? "walking" : "running") );
    }

    @Override
    public void makeNoise() {
        System.out.println();
    }
}
