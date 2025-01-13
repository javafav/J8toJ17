package io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class StreamChallenge {
    public static void main(String[] args) {
        Path startingPath = Path.of(".");
        int index = startingPath.getNameCount();
        try(var paths = Files.walk(startingPath, Integer.MAX_VALUE)){
            paths
                    .filter(Files::isRegularFile)
                    .collect(Collectors.groupingBy(p -> p.subpath(index, index + 1))),
                    Collectors.summarizingLong(
                            (p -> {

                            })
                    )
        }
    }
}
