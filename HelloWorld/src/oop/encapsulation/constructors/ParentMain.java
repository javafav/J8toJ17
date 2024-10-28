package oop.encapsulation.constructors;

import methods.Child;

public class ParentMain {
    public static void main(String[] args) {


            Parent parent = new Parent("Jane Doe", "01/01/1950", 4);
            Child child = new Child();

            System.out.println("Parent: " + parent);
            System.out.println("Child: " + child);

    }
}
