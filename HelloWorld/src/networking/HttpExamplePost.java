package networking;

import oop.encapsulation.ComplexNumber;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.getFollowRedirects;

public class HttpExamplePost {
    public static void main(String[] args) {
        try {
           // URL url = new URL(("http://example.com/extra"));
            URL url = new URL("http://localhost:8080");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User_Agent", "Java-app");
            connection.setRequestProperty("Accept",  "application/json , text/html");
            connection.setReadTimeout(30000);

            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form.urlencoded");
            String parameters = "first=Joe&last=Smith";
            int length = parameters.length();
            connection.setRequestProperty("Content-Length", String.valueOf(length));

            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
            output.writeBytes(parameters);
            output.flush();
            output.close();

            int responseCode = connection.getResponseCode();
            System.out.printf("Response code: %d%n", responseCode);
            if(responseCode != HTTP_OK){
                System.out.println("Error reading web page: " + url);
                System.out.printf("Error: %s ", connection.getResponseMessage());
                return;
            }
            printContents(connection.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printContents(InputStream is){
        try(BufferedReader inputStream = new BufferedReader(new InputStreamReader(is))){
            String line;
            while ((line = inputStream.readLine() ) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
