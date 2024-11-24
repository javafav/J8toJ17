package hackerrank;

public class ProductOfCharacterOccurrence2 {
    public static void main(String[] args) {
        String s = "aabcdddaaa";
        System.out.println(    productOfCharacterOccurrence( s) );
    }
    public static int productOfCharacterOccurrence( String s){
        s = s.toLowerCase();
        int[] countOfS = new int[26];

        for(char c : s.toCharArray()){
            countOfS[c - 'a']++;
        }
int product = 1;
        for(int j = 0; j < 26; j++){

            if(countOfS[j] > 0){

                product *= countOfS[j];
            }
        }

        return product;
    }
}
