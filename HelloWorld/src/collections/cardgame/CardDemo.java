package collections.cardgame;

import java.util.*;

public class CardDemo {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHeart = Card.getFaceCard(Card.Suit.HEART, 'A' );
       Arrays.fill(cardArray, aceOfHeart);
        Card.printDeck(Arrays.asList(cardArray), "Ace Of Hearts", 1 );

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHeart);
        System.out.println(cards);
        System.out.println(cards.size());

        List<Card> aceOfHearts = Collections.nCopies(13, aceOfHeart);
        Card.printDeck(aceOfHearts, "Aces of Hears", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "King of Clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with King copied", 2 );


        Collections.shuffle(cards);
        Card.printDeck(cards, "Shuffled Cards", 4);

        Collections.reverse(cards);
        Card.printDeck(cards, "Shuffled Cards that are Reversed", 4);

    }
}
