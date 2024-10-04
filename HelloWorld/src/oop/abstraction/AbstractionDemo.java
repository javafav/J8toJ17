package oop.abstraction;

import java.util.ArrayList;

public class AbstractionDemo {
    public static void main(String[] args) {
        Dog tomy = new Dog("Bulter", "small", 12 );
        doAnimalStuff(tomy);


        Dog wolf = new Dog("Wolf", "Medium", 12 );

        doAnimalStuff(wolf);
        wolf.makeNoise();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(tomy);
        animals.add(wolf);

        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Gold Fish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 175));
        animals.add(new Horse("Clydesdale", "large", 1000));

        for(Animal animal : animals){
            doAnimalStuff(animal);

            if(animal instanceof Mammal currentMammal){
                currentMammal.shedHair();
            }
        }
    }

    public static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("slow");

    }
}
