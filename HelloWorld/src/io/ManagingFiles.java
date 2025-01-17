package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ManagingFiles {
    public static void main(String[] args) {
        File oldFile = new File("files/student.json");
        File newFile = new File("files/student-activity.json");

        if(oldFile.exists()){
            oldFile.renameTo(newFile);
            System.out.println("File renamed successfully!");
        }else System.out.println("File does not exists");

        Path oldPath = oldFile.toPath();
        Path newPath = newFile.toPath();
        try{
            Files.move(newPath, oldPath); // rename file name method
            System.out.println("Path renamed successfully!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
