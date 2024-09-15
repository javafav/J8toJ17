package controlflow;

public class WhileLoopChallenge {
    public static void main(String[] args) {
        for(int i = 5; i<= 20; i++){
            if(isEven(i)){
                System.out.print(i + "_");
            }

        }

        int startNumber = 4;
        int endNumber = 20;
        int totalEvenNumber = 0;
        int totalOddNumber = 0;

        while (startNumber <= endNumber) {
            startNumber++;
            if (isEven(startNumber)) {
                // System.out.println("Even" + startNumber);
                totalEvenNumber++;
                if (endNumber == 5) break;
            } else {
                //  System.out.println("Odd:" + startNumber );\
                totalOddNumber++;
            }


        }
        System.out.println("Total Even Numbers: " + totalEvenNumber + " \tTotal Odd Numbers: " + totalOddNumber);
    }

    public static boolean isEven(int isEven) {
        return (isEven % 2 == 0);

    }
}
