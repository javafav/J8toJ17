package hackerrank;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(  isAnagram("Test", "Easy"));
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function

        StringBuilder firstString = new StringBuilder(a);
        StringBuilder secondString = new StringBuilder(b);

        if (firstString.length() == secondString.length()) {
            StringBuilder replace = firstString.replace(0, a.length(), b);
            System.out.println(replace);
        }
        return false;
    }
}