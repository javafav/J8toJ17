package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class FileListing {
    public static void main(String[] args) {
        Path path = Path.of("");
        System.out.println("cwd: " + path.toAbsolutePath());

        try (Stream<Path> paths = Files.list(path)) {
            paths
                    .map(FileListing::listDir)
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("------------------------------------------------");

        try (Stream<Path> paths = Files.walk(path, 2)) {
            paths
                    .filter(Files::isRegularFile)
                    .map(FileListing::listDir)
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        System.out.println("------------------------------------------------");

        try (Stream<Path> paths = Files.find(path, 2,
                (p, attr) -> Files.isRegularFile(p)
        )) {
            paths

                    .map(FileListing::listDir)
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    private static String listDir(Path path) {
        try {
            boolean isDir = Files.isDirectory(path);
            FileTime dateField = Files.getLastModifiedTime(path);
            LocalDateTime modDT = LocalDateTime.ofInstant(dateField.toInstant(), ZoneId.systemDefault());
            return "%tD %tT %-5s %12s %s".formatted(modDT, modDT, (isDir ? "<DIR>" : ""),
                    (isDir ? "" : Files.size(path) + " KB"),path);
        } catch (IOException e) {
            System.out.println("Whoops! Something went wrong this " + path);
            return path.toString();

        }
    }
}
