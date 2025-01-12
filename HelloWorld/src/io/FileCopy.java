package io;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopy {
    public static void main(String[] args) {
        String source = "files/test.txt";
        String target = "files/newtest.txt";

        Path sourcePath = Path.of(source);
        Path targetPath = Path.of(target);
        try{
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
