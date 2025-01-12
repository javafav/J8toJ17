package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryListing {
    public static void main(String[] args) {
        String filePath = "" ;
        Path path = Path.of(filePath);
        try (Stream<Path> paths = Files.list(path)) {
            paths
                    .map(DirectoryListing::listDir)
                    .forEach(System.out::println);
            listDir(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------------------------------");

        try (Stream<Path> paths = Files.walk(path , 2) ) {
            paths
                    .filter(Files::isRegularFile)
                    .map(DirectoryListing::listDir)
                    .forEach(System.out::println);
            listDir(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------------------------------");

        try (Stream<Path> paths = Files.find(path , 2,
                (p, attr) -> attr.isRegularFile() && attr.size() > 1000) ) {
            paths

                    .map(DirectoryListing::listDir)
                    .forEach(System.out::println);
            listDir(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===============Directory Stream==============");
        path = path.resolve(".idea");
        try(var dirs = Files.newDirectoryStream(path, "*.xml")){
            dirs.forEach( (d) -> System.out.println(DirectoryListing.listDir(d)));
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===============Directory Stream==============");

        try(var dirs = Files.newDirectoryStream(path,
                p -> p.getFileName().toString().endsWith(".xml") && Files.isRegularFile(p) && Files.size(p) > 1000
        )){
            dirs.forEach( (d) -> System.out.println(DirectoryListing.listDir(d)));
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String listDir(Path path) {

        try{
            boolean isDir = Files.isDirectory(path);
            FileTime dateFields = Files.getLastModifiedTime(path);
            LocalDateTime modDT = LocalDateTime.ofInstant(dateFields.toInstant(), ZoneId.systemDefault());

            return "%tD %tT %-5s %12s %s ".formatted(modDT,modDT,  (isDir ? "Dir" : ""),
                    (isDir ? "" : Files.size(path)), path);
        } catch (IOException e) {
            System.out.println("Some thing went wrong");
            return path.toString();
        }
    }

}
