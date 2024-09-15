package controlflow;

public class CalculateInterest {
    public static void main(String[] args) {
       // System.out.println("10,000 at 2% interest = " + calculateInterest(10000.0, 2.0));

        for(double counter = 2.0; counter<=5.0; counter++){
            System.out.println("10,000 at " + counter+ " % interest = " + calculateInterest(10000.0, counter));
        }

        for(double newCounter = 7.0; newCounter <= 10.0; newCounter += 0.25 ){
            System.out.println("100 at " + newCounter+ " % interest = " + calculateInterest(100.0, newCounter));
        }
    }
    public  static  double calculateInterest(double amount, double interestRate){
        return  (amount  * ( interestRate / 100 ));
    }
}
