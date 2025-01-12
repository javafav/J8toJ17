package io;

import java.io.File;
import java.io.IOException;

public class CreatingFile {
    public static void main(String[] args) {
        useFile("test.txt");
    }
    public static void useFile(String fileName){
        File file = new File(fileName);

        boolean fileExists = file.exists();
        System.out.printf("File '%s' %s%n", fileName, fileExists ? "exists" : "does not exists.");
        if(fileExists){
            System.out.println("Deleting file " + fileName);
            fileExists = !file.delete();
        }

        if(!fileExists){

            try {

                file.createNewFile();
                System.out.printf("Creating the file '%s' " ,fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
