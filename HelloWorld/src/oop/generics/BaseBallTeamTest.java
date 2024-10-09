package oop.generics;

public class BaseBallTeamTest {
    public static void main(String[] args) {
        BaseBallTeam phillies = new BaseBallTeam("Philadelphia Phillies");
        BaseBallTeam astros = new BaseBallTeam("Houston Astros");

        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseBallPlayer("B Harper", "Right Fielder");
        var marsh = new BaseBallPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();
    }

    public static void scoreResult(BaseBallTeam team1, int t1_score,
                                   BaseBallTeam team2, int t2_socre){
        String message = team1.setScore(t1_score, t2_socre);
        team2.setScore(t2_socre, t1_score);

        System.out.printf("%s %s %s %n", team1, message, team2);

    }
}
