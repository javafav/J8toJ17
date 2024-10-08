package oop.generics;

public class BaseBallTeamTest {
    public static void main(String[] args) {
        BaseBallTeam phillies = new BaseBallTeam("Philadelphia Phillies");
        BaseBallTeam astros = new BaseBallTeam("Houston Astros");
    }

    public static void scoreResult(BaseBallTeam team1, int t1_score,
                                   BaseBallTeam team2, int t2_socre){
        String message = team1.setScore(t1_score, t2_socre);
        team2.setScore();

    }
}
