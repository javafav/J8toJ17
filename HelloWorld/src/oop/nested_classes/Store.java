package oop.nested_classes;

public class Store {
    public static void main(String[] args) {
        Meal regularMeal = new Meal();
      regularMeal.addToppings("Ketchup", "Mayo", "Bacon", " Lettuce");
        System.out.println(regularMeal);

        Meal usRegularMeal = new Meal(0.68);

        System.out.println(usRegularMeal);



    }
}
