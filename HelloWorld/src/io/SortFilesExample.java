package io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortFilesExample {
    public static void main(String[] args) {
        Path dir = Paths.get("HelloWorld");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            List<Path> files = new ArrayList<>();
            for (Path entry : stream) {
                files.add(entry);
            }
            files.sort(Comparator.comparingLong(p -> {
                try {
                    return Files.size(p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
            for (Path file : files) {
                System.out.println(file.getFileName() + " - " + Files.size(file) + " bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}