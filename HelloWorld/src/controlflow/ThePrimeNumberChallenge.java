package controlflow;

public class ThePrimeNumberChallenge {
    public static void main(String[] args) {
        System.out.println("0 is " + ((isPrime(0) ? "" : "NOt") + " a prime number"));
        System.out.println("1 is " + ((isPrime(1) ? "" : "NOt") + " a prime number"));
        System.out.println("2 is " + ((isPrime(2)) ? "" : "NOt") + " a prime number");
        System.out.println("3 is " + ((isPrime(3)) ? "" : "NOt") + " a prime number");


        System.out.println("8 is " + ((isPrime(8)) ? "" : "NOt") + " a prime number");
        System.out.println("17 is " + ((isPrime(17)) ? "" : "NOt") + " a prime number");

        int primeNumberCounter = 0;

        for(int i= 70; i <= 1000; i++){

            if(isPrime(i)){
                System.out.println(i + " is " + ((isPrime(17)) ? "" : "NOt") + " a prime number");
                ++primeNumberCounter;
                if(primeNumberCounter == 3){
                    System.out.println("Found 3 -Exiting for loop");
                    break;
                }
            }
        }

    }

    public static boolean isPrime(int wholeNumber) {
        if (wholeNumber <= 2) {
            return (wholeNumber == 2);
        }

        //   Any divisor of a number greater than half of the number itself can't exist, except for the number itself. For example:
        //   If wholeNumber = 10, the divisors are 2 and 5.
        //   For wholeNumber = 100, with divisor <= 100, the loop runs 99 times.
        //         With divisor <= 100 / 2, the loop runs only 49 times, reducing the time complexity and making the code more efficient.


        for (int divisor = 2; divisor <= wholeNumber / 2; divisor++) {
            if (wholeNumber % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
