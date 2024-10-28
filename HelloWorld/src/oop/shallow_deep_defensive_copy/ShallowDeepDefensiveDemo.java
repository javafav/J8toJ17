package oop.shallow_deep_defensive_copy;

import java.util.Arrays;

record Person(String name, String dob, Person[] kids){

    public Person(Person p){
        this(p.name, p.dob,
                p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }


}

public class ShallowDeepDefensiveDemo {
    public static void main(String[] args) {

        Person joe = new Person("Joe", "01/01/1961", null);
        Person jim = new Person("Jim", "02/02/1962", null);
        Person jack = new Person("Jack", "03/03/1963", new Person[]{joe, jim});
        Person jane = new Person("Jane", "04/04/1964", null);
        Person jill = new Person("Jill", "05/05/1965", new Person[]{joe, jim});

        Person[] persons = {joe, jim, jack, jane, jill};

      //  Person[] shallowCopy = Arrays.copyOf(persons, persons.length);

//          Person[] shallowCopy = new Person[persons.length];
        Person[] shallowCopy = persons.clone();

//          for(int i=0; i < persons.length; i++){
//
//              shallowCopy[i] = new Person(persons[i]);
//          }
//        Arrays.setAll(shallowCopy, i -> new Person(persons[i]) );

        var jillsKids = shallowCopy[4].kids();
        jillsKids[1] = jane;



        for(int i = 0; i < persons.length; i++){
            if(persons[i] == shallowCopy[i]){
                System.out.println("Equal Reference "+ shallowCopy[i]);
            }
        }

        System.out.println(persons[4]);
        System.out.println(shallowCopy[4]);
    }
}
