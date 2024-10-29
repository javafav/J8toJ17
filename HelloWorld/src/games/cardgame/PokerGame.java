package games.cardgame;

import java.util.*;
import java.util.function.Consumer;

public class PokerGame {

    private final List<Card> deck = Card.getStandardDeck();
    private int playerCount;
    private int cardsInHand;

    private List<PokerHand> pokerHands;
    private List<Card> remainingCard;

    public PokerGame(int playerCount, int cardsInHand) {
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }
    public void startPlay(){
        int randomMiddle = new Random().nextInt(15, 35);
        Collections.shuffle(deck);
        Card.printDeck(deck);
        Collections.rotate(deck, randomMiddle);
        Card.printDeck(deck);
        deal();
        System.out.println("______________________________________________");
        Consumer<PokerHand>  checkHand = PokerHand::evalHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));


        int cardsDealt = playerCount * cardsInHand;
        int cardsRemaining = deck.size() - cardsDealt;


        remainingCard = new ArrayList<>(Collections.nCopies(cardsRemaining, null));
        remainingCard.replaceAll(c -> deck.get(cardsDealt + remainingCard.indexOf(c)));
        Card.printDeck(remainingCard,  "Remaining Card", 2);
    }

    private void deal(){
        Card[][] hands = new Card[playerCount][cardsInHand];
        for(int deckIndex = 0, i = 0; i< cardsInHand; i++){
            for(int j = 0; j < playerCount; j++){
                hands[j][i] = deck.get(deckIndex++);
            }
        }
        int playerNo = 1;
        for(Card[] hand : hands){
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }
    }

}
