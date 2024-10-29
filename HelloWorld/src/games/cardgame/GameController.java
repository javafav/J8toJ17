package games.cardgame;

public class GameController {
    public static void main(String[] args) {
        PokerGame pokerGame = new PokerGame(8, 5);
        pokerGame.startPlay();
    }

}
