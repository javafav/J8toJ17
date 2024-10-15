package collections.cardgame;

import java.util.List;

public class CardDemo {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
    }
}
