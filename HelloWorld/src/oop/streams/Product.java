package oop.streams;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", "Electronics", 75000),
                new Product(2, "Smartphone", "Electronics", 50000),
                new Product(3, "Washing Machine", "Appliances", 25000),
                new Product(4, "Refrigerator", "Appliances", 30000),
                new Product(5, "Shoes", "Fashion", 2000),
                new Product(6, "T-shirt", "Fashion", 1000)
        );


       var expensiveProductByCategory = products.stream()
               .collect(Collectors.groupingBy(Product::getCategory, Collectors.maxBy(Comparator.comparing(Product::getPrice))));
   expensiveProductByCategory.forEach((cat , price) -> {
       System.out.println("Expensive Books by Category");
       System.out.println(cat + " : " + price);
   });
    }
}

