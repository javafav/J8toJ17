package oop.encapsulation;

public class Carpet {
    private double cost;

    public Carpet() {
    }

    public Carpet(double cost) {
        setCost(cost);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
       if(cost < 0){
           cost = 0;
       }

        this.cost = cost;
    }
}