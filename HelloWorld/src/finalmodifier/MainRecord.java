package finalmodifier;



public class MainRecord {

    public static void main(String[] args) {

        PersonRecord jane = new PersonRecord("Jane", "01/01/1930");
        PersonRecord jim = new PersonRecord("Jim", "02/02/1932");
        PersonRecord joe = new PersonRecord("Joe", "03/03/1934");

        PersonRecord[] johnsKids = {jane, jim, joe};
        PersonRecord john = new PersonRecord("John", "05/05/1900", johnsKids);

        System.out.println(john);
        System.out.println("------------------");

        PersonRecord johnCopy = new PersonRecord("John", "05/05/1900");
        System.out.println(johnCopy);
        System.out.println("------------------");

        PersonRecord tim = new PersonRecord("Tim", "04/01/1974");

        PersonRecord[] kids = johnCopy.kids();
        kids[0] = jim;
        kids[1] = new PersonRecord("Ann", "04/04/1936");
        System.out.println(johnCopy);
        System.out.println("------------------");

        johnsKids[0] = new PersonRecord("Ann", "04/04/1936");
        johnsKids[1] = tim;
        System.out.println(john);

    }
}
