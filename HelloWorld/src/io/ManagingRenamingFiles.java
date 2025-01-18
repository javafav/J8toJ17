package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ManagingRenamingFiles {
    public static void main(String[] args) {

//        File oldFile = new File("files/student.json");
//        File newFile = new File("files/student-activity.json");
//
//        if (oldFile.exists()) {
//            oldFile.renameTo(newFile);
//            System.out.println("File renamed successfully!");
//        } else System.out.println("File does not exists");

//        Path oldPath = oldFile.toPath();
//        Path newPath = newFile.toPath();
//
//        try {
//            Files.move(newPath, oldPath); // rename file  method
//            System.out.println("Path/File renamed successfully!");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        Path oldPath = Path.of("files/student.json");
//        Path newPath = Path.of("files/student/student-activity.json");
//
//        try {
//            Files.createDirectory(newPath.subpath(0, newPath.getNameCount() - 1)); // first removing the file name from the path after that creating directories
//            Files.move(oldPath, newPath);  //                                                                                                  and then  rename file
//            System.out.println(oldPath  + " moved (renamed) to --> " + newPath);
//        } catch (IOException e) {
//            System.out.println("Files already exists or unable to copy");
//            e.printStackTrace();
//        }

        Path oldPath = Path.of("files");
        Path newPath = Path.of("resources");
        try{
            recurseCopy(oldPath, newPath); // shallow copy
            System.out.println("Directory name is changed!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void recurseCopy(Path source, Path target) throws IOException{
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        if(Files.isDirectory(source)){
            try(var children = Files.list(source)){
                children.toList().forEach(p -> {
                    try {
                        ManagingRenamingFiles.recurseCopy(
                                p, target.resolve(p.getFileName())
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }
}
