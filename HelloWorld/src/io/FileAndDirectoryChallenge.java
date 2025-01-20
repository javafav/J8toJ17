package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAndDirectoryChallenge {
    public static void main(String[] args) {
        Path deepestFolder = Path.of("public", "assets", "icon");
        try {
            Files.createDirectories(deepestFolder);
            generateIndexFIle(deepestFolder.getName(0) );
            logTxtFiles(deepestFolder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void generateIndexFIle(Path startingPath) throws IOException{
        Path indexFile = startingPath.resolve("index.txt");
        try(Stream<Path> contents = Files.find(startingPath, Integer.MAX_VALUE,
                (path, attr) -> true)){
            String fineContents = contents
                    .map( (path -> path.toAbsolutePath().toString()) )
                    .collect(Collectors.joining(
                            System.lineSeparator(),
                            "Directory Content: " + System.lineSeparator(),
                            System.lineSeparator() + "Generated: " + LocalDateTime.now()
                    ));
            Files.writeString(indexFile, fineContents, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void logTxtFiles(Path startingPath) throws IOException {
        Path logFile = startingPath.resolve("txt_files_log.txt");
        try (Stream<Path> files = Files.find(startingPath, Integer.MAX_VALUE,
                (path, attr) -> path.toString().endsWith(".txt"))) {

            String logContents = files
                    .map(path -> path.toAbsolutePath().toString())
                    .collect(Collectors.joining(
                            System.lineSeparator(),
                            "List of .txt Files: " + System.lineSeparator(),
                            System.lineSeparator() + "Logged At: " + LocalDateTime.now()
                    ));

            Files.writeString(logFile, logContents, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error while generating log file: " + e.getMessage());
        }
    }

}
