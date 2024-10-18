package collections.set;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("Phone List", phones);
        printData("Emails List", emails);


    }
    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("_________________________________________");
        System.out.println(header);
        System.out.println("_________________________________________");

        contacts.forEach(System.out::println);
    }
}
