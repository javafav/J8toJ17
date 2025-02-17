package debugging.junit;

public class Utilities {


    // everyNthChar(new char[]{'x', 'y', 'z', 'a', 'b', 'c'}, 3);
    //Output : [z, c] because of Start picking from index 2, then 5.
    // Selected characters: z, c.

    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }


    // Removes pairs of the same character that are next
    // to each other, by removing on e occurrencd of the character.
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF" (the two B's aren't next to each other, so they
    // aren't removed.
    public String removePairs(String source) {
        if (source == null || source.length() < 2) {

            return source;
        }
        char[] string = source.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < source.length() - 1; i++) {

            if (string[i] != string[i + 1]) {
                sb.append(string[i]);
                System.out.println(string[i]);
            }
        }

        sb.append(string[string.length - 1]);
        return sb.toString();
    }

    // perform a conversion based on some internal
    // business rule.
    public int converter(int a, int b) {
        if(b == 0){
            throw new ArithmeticException(b + " divider is zero");
        }
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }
        return null;
    }
}
