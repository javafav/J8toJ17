package regularexpression;

import java.util.Arrays;

public class RegularExpressionDemo {
    public static void main(String[] args) {
        String helloWorld = "%s %s".formatted("Hello", "World");
        String helloWorld2 = String.format("%s %s", "Hello", "World");
        System.out.println("Using string's formatted method: " + helloWorld);
        System.out.println("Using String.format: " + helloWorld2);

        String helloWorld3 = format("%s %s", "Hello", "world");
        System.out.println(helloWorld3);
        String testString = "Anyone can Learn abc's, 123's, any any regular expression";
        String replaceString = "(-)";

        String[] patterns = {
                "[abc]",
                "[123]",
                "[A] "
        };

        for(String pattern : patterns){
            String output = testString.replaceFirst(pattern, replaceString);
            System.out.println("Patterns: " + pattern + " => " + output);
        }
    }

    public static String format(String regex, String... args) {

        int index = 0;
        while (regex.matches(".*%s")){
          regex =  regex.replaceFirst("%s", args[index++]);
        }
        return regex;
    }
}
