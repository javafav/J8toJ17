package finalmodifier.consumer.sepcific;

import finalmodifier.BaseClass;

public class ChildClass extends BaseClass {
    @Override
    protected void optionalMethod() {
        System.out.println("[Child:optionalMethod]: EXTRA Stuff Here");
        super.optionalMethod();

    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[Child:optionalMethod]: I'll do things my way");
//        optionalMethod();
//    }

        private void mandatoryMethod() {
        System.out.println("[Child:mandatoryMethod]: My important stuff");
        optionalMethod();
    }



    public static void recommendedStatic(){
        System.out.println("[Child.recommendedStatic]: BEST Way to Do it");
        optionalStatic();
      //  mandatoryStatic();
    }

}
