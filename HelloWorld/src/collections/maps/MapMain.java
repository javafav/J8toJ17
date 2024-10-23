package collections.maps;

import collections.set.Contact;
import collections.set.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);

        fullList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        Map<String, Contact> contacts = new HashMap<>();

        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }

        contacts.forEach((k, v) -> System.out.println("Key =   " + k + " Value = " + v));

        System.out.println("-------------------------------------");
        System.out.println(contacts.get("Abdul Salam"));
        System.out.println(contacts.get("Abdul Sala"));

        Contact defaultContact = new Contact("Abdul Wahid");
        System.out.println(contacts.getOrDefault("Abdul Sala", defaultContact));

        System.out.println("-------------------------------------");

        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);

            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);

                contacts.put(contact.getName(), contact.mergeContactData(duplicate));


            }

        }
        System.out.println("-------------------------------------");
        contacts.forEach((k, v) -> System.out.println("Key =   " + k + " Value = " + v));

        System.out.println("-------------------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);
        }

        contacts.forEach((k, v) -> System.out.println("Key =   " + k + " Value = " + v));
        contacts.clear();

        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
            contacts.forEach((k, v) -> System.out.println("Key =   " + k + " Value = " + v));
        }
        System.out.println("--------------------------------------------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData
                ));

        contacts.forEach((k, v) -> System.out.println("Key =   " + k + " Value = " + v));

        System.out.println("-------------------------------------");
        for(String contactName : new String[]{"Daisy Malik", "Daffy Duck", "Scrooge McDuck"}){
            contacts.computeIfAbsent(contactName, Contact::new);
        }

        contacts.forEach((k, v) -> System.out.println("Key =   " + k + " Value = " + v));



        System.out.println("-------------------------------------");
        for(String contactName : new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
            contacts.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun Place");
                return v; });
        }

        contacts.forEach((k, v) -> System.out.println("Key =   " + k + " Value = " + v));

        System.out.println("-------------------------------------");



    }


}
