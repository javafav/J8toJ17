package methods;

public class ConvertToCentimeters {
    public static void main(String[] args) {
        System.out.println("5 ft, 8 in = " + convertToCentimeters(5, 8) + " cm");

        System.out.println("68 in = " + convertToCentimeters( 68) + " cm");


    }

    //method overloading
    public static  double convertToCentimeters(int heightInInches){
        return heightInInches * 2.54;
    }

    public static  double convertToCentimeters(int heightInFeet, int remainingHeightInInches){
        int personTotalHeightInInches = (heightInFeet * 12 ) + remainingHeightInInches;
       return  convertToCentimeters(personTotalHeightInInches);
    }
}
