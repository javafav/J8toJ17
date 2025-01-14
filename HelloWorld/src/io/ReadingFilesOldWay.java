package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFilesOldWay {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("files/file.txt")){
          char[] block = new char[500];
            int data;
            while ((data = reader.read(block) ) != -1){
                String content = new String(block, 0, data);
                System.out.printf("----> [%d chars] %s%n", data, content);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
           e.printStackTrace();
        }

        System.out.println("--------------------------------------------------");
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("files/file.txt"))){

//            String line;
//            while (bufferedReader.readLine() != null){  // old way to read line
//                line = bufferedReader.readLine();
//                System.out.println(line);

          //  }

            bufferedReader.lines().forEach(System.out::println); // another way to read line from file

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
