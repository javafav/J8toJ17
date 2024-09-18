package controlflow;

public class DiagonalStar {

    private static final String STAR = "*";
    private static final String SPACE = " ";

    public static void main(String[] args) {
     printSquareStar(8);
    }

    public static  void printSquareStar(int number){
        if(number < 5){
            System.out.println("Invalid Value");
            return;
        }

        for(int row = 1; row <= number; row++){
            for(int col = 1; col <= number; col++){
                boolean isFirstRowOrColumn = row == 1 || col == 1;
                boolean isLastRowOrColumn = row == number || col == number;
                boolean isDiagonal = (row == col) || (col == (number - row + 1));

                if(isFirstRowOrColumn || isLastRowOrColumn || isDiagonal){
                    System.out.print(STAR);
                } else  {
                    System.out.print(SPACE);
                }
            }
            System.out.println();
        }




    }
}
