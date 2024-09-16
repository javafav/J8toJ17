package controlflow;

public class FactorPrinter {
    public static void main(String[] args) {
        printFactors(28);
    }

    public  static void printFactors(int number){
        if(number < 0){
            System.out.println("invalid Value");
            return;
        }
        int count = 1;

        while ( count <= number){

            if(number % count == 0){
                System.out.print(count + " ");
            }
            count++;

        }
    }


}
