package collections.maps;

import collections.set.Contact;
import collections.set.ContactData;

import java.util.*;

public class MapViewsMain {
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        Set<String> keysViews = contacts.keySet();
        NavigableSet<String> sortedKeysViews = new TreeSet<>(contacts.keySet());

        System.out.println(keysViews);
        System.out.println(sortedKeysViews);
        System.out.println(keysViews);

        if(contacts.containsKey("Linus Van Pelt")){
            System.out.println("Linus and I go wat back, so of course I have info");
        }

        keysViews.remove("Daffy Duck");
        System.out.println(keysViews);
        contacts.forEach((k, v) -> System.out.println("Key = " + k + " Value =   " + v));

        System.out.println("---------------------------------------------");

        sortedKeysViews.remove("Linus Van Pelt");
        System.out.println(keysViews);
        contacts.forEach((k, v) -> System.out.println("Key = " + k + " Value =   " + v));

        System.out.println("---------------------------------------------");
        keysViews.retainAll(List.of("Linus Van Pelt", "Maid Marion", "Charlie Brown" ));
        System.out.println(keysViews);
        contacts.forEach((k, v) -> System.out.println("Key = " + k + " Value =   " + v));

        System.out.println("---------------------------------------------");
        keysViews.clear();

        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        System.out.println(keysViews);
        System.out.println("---------------------------------------------");

        var values = contacts.values();
        values.forEach(System.out::println);

        System.out.println("---------------------------------------------");
        values.retainAll(ContactData.getData("email"));
        System.out.println(keysViews);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("---------------------------------------------");
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));
        System.out.println("---------------------------------------------");

        System.out.println("---------------------------------------------");
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysViews.forEach(System.out::println);

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if(set.size() < contacts.keySet().size()){
            System.out.println("Duplicate Values in my map");
        }

        var nodeSet = contacts.entrySet();
        for(var node : nodeSet){
            System.out.println(node.getClass().getName());
            if(!node.getKey().equals(node.getValue().getName())){
                System.out.println(node.getClass().getName());
                System.out.println("Key doesn't match name: " +  node.getKey() + ": " + node.getValue());
            }
        }


    }


}
