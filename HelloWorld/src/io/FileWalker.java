package io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FileWalker {
    public static void main(String[] args) {
        Path startingPath = Path.of(".");
        FileVisitor<Path> statsVisitor = new StatVisitor(1);
        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class StatVisitor extends SimpleFileVisitor<Path> {
        //private  int level;

        private Path intailPath = null;
        private Map<Path, Long> folderSizes = new LinkedHashMap<>();
        private int initialCount;
        private int printLevel;

        public StatVisitor(int printLevel) {
            this.printLevel = printLevel;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
           // System.out.println("\t".repeat(level + 1) + file.getFileName());

            folderSizes.merge(file.getParent(), 0L, (o, n) -> o+= attrs.size());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);
           // level++;
          //  System.out.println("\t".repeat(level) + dir.getFileName());

            if(intailPath == null){
                intailPath = dir;
                initialCount = dir.getNameCount();
            }else {
                int relativeLevel = dir.getNameCount() - initialCount;
                if(relativeLevel == 1){
                    folderSizes.clear();
                }
            }
            folderSizes.put(dir, 0L);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Objects.requireNonNull(dir);
//            if (exc != null)
//                throw exc;
         //   level--;

            if(dir.equals(intailPath)){
                return FileVisitResult.TERMINATE;
            }
            int relativeLevel = dir.getNameCount() - initialCount;
            if(relativeLevel == 1){
                folderSizes.forEach((key, value) -> {
                    int level = key.getNameCount() - initialCount -1;
                   if(level < printLevel){
                       System.out.printf("%s[%s] - %,d bytes %n", "\t".repeat(level), key.getFileName(), value);
                   }

                });
            }else {
                Long folderSize  = folderSizes.get(dir);
                folderSizes.merge(dir.getParent(), 0L, (o, n) -> o+=folderSize);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
