package oop.lambda;

public class UpperCaseChallenge {

    public static void main(String[] args) {
        String test = "abcdefghijklmnopqrstuvwxyz";

        UpperCase<String>  myfunction = str -> str.toUpperCase();
        System.out.println(myfunction.upperCase(test));

        String result =  changeToUpperCase(myfunction, "hello world");
        System.out.println(result);

    }

    public static String changeToUpperCase(UpperCase<String> values, String test){
      return   values.upperCase(test);
    }

}
