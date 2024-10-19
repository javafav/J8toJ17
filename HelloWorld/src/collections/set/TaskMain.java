package collections.set;

import java.util.*;

public class TaskMain {
    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTaskData("all");

        sortAndPrint("All Tasks", tasks);
        System.out.println();
        Comparator<Task> sortedByPriority = Comparator.comparing(Task::getDescription);
        Set<Task> annsTaks = TaskData.getTaskData("ann");
        sortAndPrint("Ann's Tasks", annsTaks, sortedByPriority);

    }
    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header, collection, null);
    }

    public static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter){
        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println("%45s".formatted(header));
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }
}
