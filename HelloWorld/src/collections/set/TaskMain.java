package collections.set;

import java.util.*;

public class TaskMain {
    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTaskData("all");

        sortAndPrint("All Tasks", tasks);
        System.out.println();
        Comparator<Task> sortedByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTaskData("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortedByPriority);

        Set<Task> bobsTask = TaskData.getTaskData("Bob");
        Set<Task> carolsTask = TaskData.getTaskData("Carol");

        List<Set<Task>> sets = List.of(annsTasks, bobsTask, carolsTask);
        Set<Task> assignedTasks = TaskMain.getUnion(sets);
        sortAndPrint("Assigned Task", assignedTasks);
        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("The True All Tasks", everyTask);

        Set<Task> missingTask = getDifference(everyTask, tasks);
        sortAndPrint("Missing Tasks", missingTask);

        Set<Task> unAssignedToAnyOne = getDifference(tasks, assignedTasks);
        sortAndPrint("Un Assigned Tasks", unAssignedToAnyOne, sortedByPriority);

        Set<Task> overlap = getUnion(List.of(
                getIntersect(annsTasks, bobsTask),
                getIntersect(carolsTask, bobsTask ),
                getIntersect(annsTasks, carolsTask)
        ));

        sortAndPrint("Assigned to Multiples", overlap);

//        Contact marry = new Contact("Marry");
//        Contact john = new Contact("John");
//        Contact lisa = new Contact("Lisa");
//        Contact daffy = new Contact("Daffy Duck,");





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

    private static Set<Task> getUnion(List<Set<Task>> sets){
        Set<Task> union = new HashSet<>();
       for( var tasks : sets){
           union.addAll(tasks);
       }

        return  union;
    }


    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b){
        Set<Task> intersection = new HashSet<>();
        intersection.addAll(b);
        intersection.retainAll(a);
        return intersection;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b){
        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;


    }
}
