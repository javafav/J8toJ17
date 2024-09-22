package methods;

public class RomanNumbers {
    public static void main(String[] args) {
     romanNUmber("ivxlmcd");
    }
    public static void romanNUmber(String number){
        String convertedRomanInString = "";
       if(number.length() > 1){
           for(int i = 0; i< number.length(); i++){
               String letterAsSubstring = number.substring(i, i + 1);
               System.out.print(letterAsSubstring + "\t");

           }
       }

    }
}
