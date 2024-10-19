package collections.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("Phone List", phones);
        System.out.println(phones.size());
        printData("Emails List", emails);


        Contact contact = new Contact("Ali Saad", "alisadd@test.com");
        System.out.println(contact);

        Contact contact1 = new Contact("Marry Tom", "marry@test.com");
        System.out.println(contact1);

        System.out.println("_________________________________________");
        System.out.println("Email list");
        contact.mergeContactData(contact1);
        System.out.println(contact);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);

        printData("Phone List", phoneContacts);
        System.out.println(phoneContacts.size());
        printData("Emails List", emailContacts);

        int index = emails.indexOf(new Contact("Marry Anna"));
        Contact marry = emails.get(index);
        marry.addEmail("Shoe Bill");
        marry.addEmail("Shoe Bill");
        marry.replaceEmail("MAnna@shoebill.com", "MAnna@shoebill.org ");
        System.out.println(marry);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A ∪ B ) Union of email (A) with phones (B)", unionAB);

        Set<Contact> intersectAB = new HashSet<>(emails);
        intersectAB.retainAll(phoneContacts);

        printData("(A \u2229 B ) intersection of email (A) with phones (B)", intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emails);

        printData("(B \u2229 A ) intersection of phones (B) with email (A)", intersectBA);

        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);

        printData("(A - B )   email (A) - phones (B)", AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);

        printData("(B - A ) phones (B)      -    email (A)  ", BMinusA);


    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("_________________________________________");
        System.out.println(header);
        System.out.println("_________________________________________");

        contacts.forEach(System.out::println);
    }
}
