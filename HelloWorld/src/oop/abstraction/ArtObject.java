package oop.abstraction;

public class ArtObject extends ProductForSale{

    public ArtObject(String type,  double price,  String description) {
        super(type, description, price);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + type + " is a beautiful reproduction");
        System.out.printf("The Price is $%6.2f %n", price);
        System.out.println(description);
    }
}
