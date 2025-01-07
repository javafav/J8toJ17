package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileException {
    public static void main(String[] args) {



        String fileName = "/files/name.csv";


        File file = new File(new File(""),fileName);
        System.out.println(file.getAbsolutePath());
        System.out.println("Current working directory (cwd) " + new File("").getAbsolutePath());

        if (!file.exists()) {
            System.out.println("I can't run unless the file exists");
           // System.out.println("Quiting Application. go figure it out");
            return;
        }
        System.out.println("I'm good to go");

        for(File f : File.listRoots()){
            System.out.println(f);
        }


        Path path = Paths.get("files/name.csv");

        if (!Files.exists(path)) {
            System.out.println("2 .I can't run unless the file exists");
            // System.out.println("Quiting Application. go figure it out");
            return;
        }
        System.out.println("2 .I'm good to go");


    }

    private static void testFile(String fileName) {
        Path path = Paths.get(fileName);
        FileReader reader = null;
        try {
            //List<String> lines = Files.readAllLines(path);
            reader = new FileReader(fileName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way...");
        }

        System.out.println("File exists and able o use as a resource");
    }

    private static void testFile2(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
        } catch (FileNotFoundException e) {
            System.out.println("File '" + fileName + "' does not exist");
            throw new RuntimeException(e);


        }catch (NullPointerException | IllegalArgumentException badData){
            System.out.println("User has added bad data " + badData.getMessage());
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        } finally {
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists , and able to use as a resource");

    }
}
