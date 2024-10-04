package oop.abstraction;

import java.util.ArrayList;

public class Store {

    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();


    public static void main(String[] args) {


//        ProductForSale product1 = new ProductForSale("Grocery", "Oil", 450 );
//        productForSales.add(product1);

//        System.out.println("Welcome        to   Home       Grocery");
//        System.out.println("*".repeat(40));
//        System.out.println();
//        System.out.println("Type  Description  Price  Quantity  Total");
//        System.out.println("_".repeat(40));
        //product1.printPricedItem(2 );

        storeProducts.add(new ArtObject("Oil Painting", 1350,
                "Impressionistic work by ABF painted in 2010"));

        storeProducts.add(new ArtObject("Sculpture", 2000,
                "Bronze work by JKF, produced in 1950"));

        storeProducts.add(new FurnitureObject("Desk", 200,
                "Best Selling Desk by IKEA"));

        storeProducts.add(new FurnitureObject("Lamp", 400,
                "Romantic Lamp like candle by IKEA"));

        listProducts(storeProducts);

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 2, 1);
        addItemToOrder(order1, 1, 0);
        printOrder(order1);

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 2, 3);
        addItemToOrder(order2, 2, 2);
        addItemToOrder(order2, 1, 1);
        printOrder(order2);

    }

    private static void listProducts(ArrayList<ProductForSale> storeProducts) {
        for (var product : storeProducts) {
            System.out.println("-".repeat(30));
            product.showDetails();
        }
    }


    public static void addItemToOrder(ArrayList<OrderItem> order, int qty, int orderIndex) {
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){
        double salesTotal = 0;
        for(var item : order ){
            item.products().printPricedItem(item.qty());
            salesTotal += item.products().getSalePrice(item.qty());
        }
        System.out.printf("Sales Total =  $%6.2f %n", salesTotal);
    }
}
