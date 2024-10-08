package autoboxing_and_unboxing;

import java.util.ArrayList;

public record Customer(String name, ArrayList<Double> transactions) {
    public Customer(String name, double initialDeposit){
        this(name.toUpperCase(), new ArrayList<>(500) );
        transactions.add(initialDeposit);
    }


}