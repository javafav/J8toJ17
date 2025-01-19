package io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
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
           Thread.sleep(2000);
            System.out.println("Deleting the file");
            long now = System.currentTimeMillis();
            while (( (System.currentTimeMillis() - now ) /  100000 ) > 3){
                System.out.print(".");
                Thread.sleep(1000);
            }
            System.out.print(".");
            recurseDelete(newPath);

        } catch (IOException e) {
           e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        String urlString = "https://api.census.gov/data/2019/pep/charagegroups?get=NAME,POP&for=state:*";
        URI uri = URI.create(urlString);
        try (var urlInputStream = uri.toURL().openStream();
        ) {
            urlInputStream.transferTo(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Path jsonPath = Path.of("USPopulationByState.txt");
        try (var reader = new InputStreamReader(uri.toURL().openStream());
             var writer = Files.newBufferedWriter(jsonPath)) {
            reader.transferTo(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (var reader = new InputStreamReader(uri.toURL().openStream());
             PrintWriter writer = new PrintWriter("USPopulationByState.csv")) {
            reader.transferTo(new Writer() {
                @Override
                public void write(char[] cbuf, int off, int len) throws IOException {

                    String jsonString = new String(cbuf, off, len).trim();
                    jsonString = jsonString.replaceAll("\\[", " ").trim();
                    jsonString = jsonString.replaceAll("\\]", " ");
                    writer.write(jsonString);
                }

                @Override
                public void flush() throws IOException {
                    writer.flush();
                }

                @Override
                public void close() throws IOException {
                    writer.close();
                }
            });
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


    private static void recruiveCopy(Path source, Path target) throws  IOException{
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        try(var children = Files.list(source)){
          children.toList().forEach(path -> {
              try{
                  ManagingRenamingFiles.recruiveCopy(path, target.resolve(path.getFileName()));
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          });
        }
    }

    private static void recurseDelete(Path target) throws  IOException{
       if(Files.isDirectory(target)) {

           try (var children = Files.list(target)) {
               children.toList().forEach(path -> {
                   try {
                       ManagingRenamingFiles.recurseDelete(path);
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
               });
           }catch (IOException e){
               System.out.println("Unable to delete the directory");
           }
       }
       Files.delete(target);
    }



}
