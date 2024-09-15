package controlflow;

public class NatoPhoneticAlphabet {
    public static void main(String[] args) {

        System.out.println( natoPhoneticAlphabet('A') );

        System.out.println( natoPhoneticAlphabet('B') );

        System.out.println( natoPhoneticAlphabet('C') );

        System.out.println( natoPhoneticAlphabet('D') );

        System.out.println( natoPhoneticAlphabet('K') );

    }

    public  static  String natoPhoneticAlphabet(char alphabet){
        switch (alphabet){
            case 'A':
                return "Able";

            case 'B':
                return "Baker";

            case 'C':
                return "Charlie";

            case 'D':
                return "Dog";

            case 'E':
                return "Easy";

            default:
                return "Letter " + alphabet + " was not found in the switch. " ;
        }
    }
}
