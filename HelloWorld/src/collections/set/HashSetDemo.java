package collections.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);

        hellos.forEach(s -> System.out.println(s + " " + s.hashCode()));

        Set<String> mySet = new HashSet<>(hellos);
        mySet.forEach(System.out::println);
        System.out.println("Size of the set  "+mySet.size());

        for(String setValue : mySet){
            System.out.print(setValue + " : ");
            for(int i = 0; i< hellos.size(); i++){
                if(setValue ==  hellos.get(i)){
                    System.out.print(i+ ". ");
                }
            }
            System.out.println();

        }


        PlayingCard aceOfHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceOfHearts, kingClubs, queenSpades);

        cards.forEach(s -> System.out.println(s + " : " + s.hashCode()));


        Set<PlayingCard>  deck = new HashSet<>();
        for(PlayingCard card : cards){
            if(!deck.add(card)){
                System.out.println("Found a duplicate: " +card);
            }


        }
        System.out.println(deck);
    }
}
