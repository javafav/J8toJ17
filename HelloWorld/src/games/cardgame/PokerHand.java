package games.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHand {
    private List<Card> hand;
    private List<Card> keepers;

    private List<Card> discards;

    private Ranking score = Ranking.NONE;

    private int playerNo;

    public PokerHand(int playerNo, List<Card> hand) {
        hand.sort(Card.sortRankReversedSuit());
        this.hand = hand;
        this.playerNo = playerNo;
        keepers = new ArrayList<>(hand.size());
        discards = new ArrayList<>(hand.size());
    }

    @Override
    public String toString() {
        return "%d. %-16s Rand:%d %40s %s".formatted(
                playerNo, score, score.ordinal(), hand,
                (discards.size() > 0) ? "Discard: " + discards : "");
    }

    private void setRank(int faceCount) {
        switch (faceCount) {
            case 4 -> score = Ranking.FOUR_OF_A_KIND;
            case 3 -> {
                if (score == Ranking.NONE) score = Ranking.THREE_OF_A_KIND;
                else score = Ranking.FULL_HOUSE;
            }
            case 2 -> {
                if (score == Ranking.NONE) score = Ranking.ONE_PAIR;
                else if (score == Ranking.THREE_OF_A_KIND) score = Ranking.FULL_HOUSE;
                else score = Ranking.TWO_PAIR;


            }


        }

    }

    public void evalHand(){
        List<String> faceList = new ArrayList<>(hand.size());
        hand.forEach(card -> faceList.add(card.face()));

        List<String> duplicateFaceCards = new ArrayList<>();
        faceList.forEach(face -> {
            if(!duplicateFaceCards.contains(face) && Collections.frequency(faceList, face) > 1){
                duplicateFaceCards.add(face);
            }
        });
        for(String duplicate : duplicateFaceCards){
            int start = faceList.indexOf(duplicate);
            int last = faceList.lastIndexOf(duplicate);
            setRank(last - start + 1);
            List<Card> sub = hand.subList(start, last + 1);
            keepers.addAll(sub);
        }
    }
}



