package io;

import java.io.*;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class ScannerProject {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(
                new BufferedReader(new FileReader("files/fixedWidth.txt"))) ) {  //   try (Scanner scanner = new Scanner(new File("files/fixedWidth.txt"))) another way
//            while (scanner.hasNextLine()){                                                  //    try (Scanner scanner = new Scanner(Path.of("files/fixedWidth.txt")))
//                System.out.println(scanner.nextLine());                                    //   try (Scanner scanner = new Scanner(new FileReader("files/fixedWidth.txt")))
//            }

//            System.out.println(scanner.delimiter());
//            scanner.useDelimiter("$");
//            scanner.tokens().forEach(System.out::println);

//            scanner.findAll("[A-za-z]{10,}")
//                    .map(MatchResult::group)
//                    .distinct()
//                    .sorted()
//                    .forEach(System.out::println);

            var results = scanner
                    .findAll("(.{15})(.{3})(.{12})(.{8})(.{2}).*")
                    .skip(1)
                    .map(m -> m.group(3).trim())
                   .distinct()
                    .sorted().toArray(String[]::new);
            System.out.println(Arrays.toString(results));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
