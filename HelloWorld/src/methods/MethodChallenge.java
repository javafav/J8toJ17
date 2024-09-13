package methods;

public class MethodChallenge {
    public static void main(String[] args) {

        int position = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim", position );

         position = calculateHighScorePosition(1000);
        displayHighScorePosition("Bob", position );

        position = calculateHighScorePosition(500);
        displayHighScorePosition("Marry", position );

        position = calculateHighScorePosition(100);
        displayHighScorePosition("John", position );

        position = calculateHighScorePosition(25);
        displayHighScorePosition("Cynthia", position );
    }

    public static void displayHighScorePosition(String playerName, int playerPosition) {

        System.out.println(playerName + " managed to get into position " + playerPosition + " on the high score list.");
    }

    public static int calculateHighScorePosition(int playerScore) {
        int result = 0;

        if (playerScore >= 1000) {
            result = 1;
        } else if (playerScore >= 500 ) {
            result = 2;
        } else if (playerScore >= 100 ) {
            result = 3;
        } else {
            result = 4;
        }

        return result;
    }
}
