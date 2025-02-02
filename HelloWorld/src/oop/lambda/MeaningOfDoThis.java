package oop.lambda;

public class MeaningOfDoThis {
    public final int value = 4;
    public void doIt(){
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfDoThis m = new MeaningOfDoThis();
        m.doIt();
    }
}
