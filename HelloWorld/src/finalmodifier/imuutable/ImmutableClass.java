package finalmodifier.imuutable;

public class ImmutableClass {
    public static void main(String[] args) {

//        PersonImmutable jane = new PersonImmutable();
//        jane.setName("Jane");
//        PersonImmutable jim = new PersonImmutable();
//        jim.setName("Jim");
//        PersonImmutable joe = new PersonImmutable();
//        joe.setName("Joe");
//        PersonImmutable john = new PersonImmutable();
//        john.setName("John");
//        john.setDob("05/05/1900");
//        john.setKids(new PersonImmutable[]{jane, jim, joe});
//        System.out.println(john);
//
//        john.setName("Jacob");
//        john.setKids(new PersonImmutable[]{new PersonImmutable(), new PersonImmutable()});
//        System.out.println(john);

        PersonImmutable jane = new PersonImmutable("Jane", "01/01/1930");
        PersonImmutable jim = new PersonImmutable("Jim", "02/02/1932");
        PersonImmutable joe = new PersonImmutable("Joe", "03/03/1934");

        PersonImmutable[] johnKids = {jane, jim, joe};
        PersonImmutable john = new PersonImmutable("John", "05/05/1990", johnKids);
        System.out.println(john);

        PersonImmutable[] kids = john.getKids();
        kids[0] = jim;
        System.out.println(john);

        kids = null;
        System.out.println(john);

      LivingPerson johnLiving = new LivingPerson(john.getName(), john.getKids());
        System.out.println(johnLiving);

        LivingPerson anne = new LivingPerson("Ann", null);
        johnLiving.addKid(anne);

        System.out.println(johnLiving);

        PersonOfInterest johnCopy = new PersonOfInterest(john);
        System.out.println(johnCopy);

        kids = johnCopy.getKids();
        kids[1] = anne;
        System.out.println(john);


    }
}
