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

        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit is reverse", 13);

        List<Card> kings = deck.subList(4,8);
        Card.printDeck(kings, "Just King Deck", 1);

        List<Card> tens = deck.subList(16,20);
        Card.printDeck(tens, "Just King Deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        int subListLastIndex = Collections.lastIndexOfSubList( tens, deck);
        System.out.println("sublist index of tens = " + subListIndex);
        System.out.println("sublist last index of tens = " + subListLastIndex);
        System.out.println("Contains= " + deck.containsAll(tens));

        Card.cardsInPlayerHand(deck,4);

     List<Card> cards1 = Card.shuffleCardsToPlayTheGame(deck, 14);

     Card.printDeck(cards1, "Just Random Deck", 4);


    }
}
