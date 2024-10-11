package oop.generics;

public class LpaStudent extends Student{
  private   double percentComplete;

    public LpaStudent() {
        percentComplete = random.nextDouble(0,100.001) ;
    }

    @Override
    public String toString() {
        return "%s %9.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
