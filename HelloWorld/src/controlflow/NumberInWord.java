package controlflow;

public class NumberInWord {
    public static void main(String[] args) {
        printNumberInWord(0);
        printNumberInWord(01);
        printNumberInWord(02);
        printNumberInWord(03);
        printNumberInWord(04);
        printNumberInWord(05);
        printNumberInWord(06);
        printNumberInWord(07);
        printNumberInWord(8);
        printNumberInWord(9);


    }
    public static void printNumberInWord(int number){
         String numberInWords = switch(number){
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "OTHER";
        };
        System.out.println(number + " : " + numberInWords);
    }
}
