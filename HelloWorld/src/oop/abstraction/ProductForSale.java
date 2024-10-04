package oop.abstraction;

public abstract class ProductForSale {
    protected String type;
    protected String description;
    protected double price;

    public ProductForSale(String type, String description, double price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public abstract void showDetails();

    public double getSalePrice(int quantity){
        return quantity * price;
    }

    public void printPricedItem(int qty) {

        System.out.printf("%2d qty at $%8.2f each,  %-15s %-35s %n",
                qty, price, type, description);
    }

//    public void printPricedItem(int quantity ){
//        System.out.printf("%s --> %s %10.2f x %2d %8.2f%n ", type, description, price, quantity, getSalePrice(quantity));
//    }
}
