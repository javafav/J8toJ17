package controlflow;

public class FlourPacker {
    public static void main(String[] args) {
        System.out.println((canPack (1, 0, 4)));
        System.out.println(canPack (1, 0, 5));
        System.out.println(  canPack (0, 5, 4) );

        System.out.println(canPack (1, 4, 13));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        // Validation for negative inputs
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int bigBagToUse = goal / 5;

        if(bigBagToUse > bigCount){
            bigBagToUse = bigCount;
        }

        int reamingGoals = goal - (bigBagToUse * 5 );

        return reamingGoals <= smallCount;

    }
}
