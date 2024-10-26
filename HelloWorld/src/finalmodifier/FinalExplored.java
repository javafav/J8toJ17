package finalmodifier;

import finalmodifier.consumer.sepcific.ChildClass;
import finalmodifier.consumer.sepcific.Logger;

public class FinalExplored {
    public static void main(String[] args) {
        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("----------------------------");
        childReferredAsBase.recommendedMethod();
        System.out.println("----------------------------");
        child.recommendedMethod();
        System.out.println("----------------------------");

        parent.recommendedStatic();
        System.out.println("----------------------------");
        childReferredAsBase.recommendedStatic();
        System.out.println("----------------------------");
        child.recommendedStatic();

        System.out.println("----------------------------");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();

        String xArgument = "This is all I've got to say about Section ";
       StringBuilder zArgument = new StringBuilder("only saying this section ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("After method call XArgument: " + xArgument);
        System.out.println("After method call zArgument: " + zArgument);

        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append(", Step 2 is xyz.");
        Logger.logToConsole(tracker.toString());
        System.out.println("After logging, tracker = " +tracker);


    }

    private static void doXYZ(String x, int y, final StringBuilder z){
        final String c = x + y;
        System.out.println("c = " + c);
        x = c;
        z.append(y);


    }
}
