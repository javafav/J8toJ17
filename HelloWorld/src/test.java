import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        StringBuilder a =  new StringBuilder("abc");
        String b = "abc";
        a.append(b);
        System.out.println(a);

//        ['foo@a.com', 'bar@a.com', baz@b.com', 'qux@d.com'],
//
//        urls=['www.a.com', 'www.b.com', 'www.c.com']

        String[] keyURLs = {"www.a.com", "www.b.com", "www.c.com"};
        String[] valueEmails ={"foo@a.com", "bar@a.com", "baz@b.com", "qux@d.com"};

        Map<String, String> dictionary = new HashMap<>();
    }


}
