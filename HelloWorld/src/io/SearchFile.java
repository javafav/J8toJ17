package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchFile {
    public static void main(String[] args) {
        Path startDir = Paths.get("files");
        String fileNameToFind = "test.txt";

        try {
            Files.walk(startDir)
                    .filter(path -> path.getFileName().toString().equals(fileNameToFind))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
