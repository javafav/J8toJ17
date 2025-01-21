package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

record Employee(int employeeId, String firstName, String lastName, double salary) {

};

public class RandomFileAccessChallenge {

    private static final Map<Integer, Long> indexedIds = new HashMap<>();

    static {
        int recordInFiles = 0;
        try (RandomAccessFile ra =
                     new RandomAccessFile("files/employees.dat", "r")) {
            recordInFiles = ra.readInt();
            System.out.println(recordInFiles + " records in file");
            for (int i = 0; i < recordInFiles; i++) {
                indexedIds.put(ra.readInt(), ra.readLong());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try(RandomAccessFile ra =
                new RandomAccessFile("files/employees.dat", "rw")){
            Scanner scanner  = new Scanner(System.in);
            List<Integer> ids = new ArrayList<>(indexedIds.keySet());
            Collections.sort(ids);
            while (true){
                System.out.println(ids);
                System.out.println("Enter an Employee id or 0 to quit");
                if(!scanner.hasNext()) break;
                int employeeId = Integer.parseInt(scanner.nextLine());
                if(employeeId < 1){
                    break;
                }
                if(!ids.contains(employeeId)){
                    System.out.println("Ids not in the system ");
                    continue;
                }
                Employee e = readRecord(ra, employeeId);
                System.out.println("Enter new salary, nothing if no change");
                try{
                    double salary = Double.parseDouble(scanner.nextLine());
                    ra.seek(indexedIds.get(employeeId) + 4);
                    ra.writeDouble(salary);
                    readRecord(ra, employeeId);

                }catch (NumberFormatException ex){
                    System.out.println("Please Enter a number form employee ids");
                }
            }

        }catch (IOException e){
            throw new RuntimeException();
        }

    }

    private static Employee readRecord(RandomAccessFile ra, int employeeId) throws IOException{
       ra.seek(indexedIds.get(employeeId));
       int id = ra.readInt();
       double salary = ra.readDouble();
       String first = ra.readUTF();
        String last = ra.readUTF();

        Employee e = new Employee(id, first, last, salary);
        System.out.println(e);
        return e;
    }
}
