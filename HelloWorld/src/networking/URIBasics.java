package networking;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIBasics {
    public static void main(String[] args) {
        URI baseSite = URI.create("https://sastaybrands.com");

        URI sastayBrands  = URI.create(
                "/c/computer_memory");
        print(sastayBrands);

        try {
            URI uri = new URI("" +
                    "http://user:pw@store.com:5000/products/phone?os=android#samsung");
            print(uri);
           URI masterClass = baseSite.resolve(sastayBrands);
            URL url = masterClass.toURL();
            System.out.println(url);
            print(url );
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void  print(URI uri){
        System.out.printf("""
                -----------------------------------------
                [scheme:]scheme-specific-part[#fragment]
                ------------------------------------------
                Scheme: %s
                Scheme-specific part: %s
                    Authority: %s
                    User Info: %s
                    Host: %s,
                    Port: %s
                    Path: %s
                    Query:%s
                Fragment: %s
           """,
                uri.getScheme(),
                uri.getSchemeSpecificPart(),
                uri.getAuthority(),
                uri.getUserInfo(),
                uri.getHost(),
                uri.getPort(),
                uri.getPath(),
                uri.getQuery(),
                uri.getFragment());
    }


    private static void  print(URL url){
        System.out.printf("""
           -----------------------------------------
           
            Authority: %s
                User Info: %s
                Host: %s,
                Port: %s
                Path: %s
                Query:%s
          
           """,

                url.getAuthority(),
                url.getUserInfo(),
                url.getHost(),
                url.getPort(),
                url.getPath(),
                url.getQuery());

    }
}
