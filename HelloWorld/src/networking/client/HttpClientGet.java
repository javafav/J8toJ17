package networking.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.net.HttpURLConnection.HTTP_OK;

public class HttpClientGet {
    public static void main(String[] args) {
        try {

            URL url = new URL("http://localhost:8080");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(url.toURI())
                    .header("User-Agent", "Chrome")
                    .headers("Accept", "application/json", "Accept", "text/html")
                    .timeout(Duration.ofSeconds(30))
                    .build();



            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != HTTP_OK){
                System.out.println("Error reading web page: " + url);
                return;
            }
            System.out.println(response.body());


        } catch (IOException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
