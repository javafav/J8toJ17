package ifelse;

public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(1, 517));


    }

    public static String getDurationString(int seconds) {

        if (seconds < 0) {
            return "Seconds can not be the negative";
        }

        int minuets = seconds / 60;
        int hours = minuets / 60;

        minuets = minuets % 60;
        seconds = seconds % 60;


        return hours + "h " + minuets + "m " + seconds + "s";
    }

    public static String getDurationString(int minutes, int seconds) {

        if (minutes < 0) {
            return "Minutes can not be the negative";
        }

        if (seconds < 0 || seconds > 59) {
            return "Seconds should be in the range of 0 to 59";
        }


        int totalSeconds = (minutes * 60) + seconds;

        return getDurationString(totalSeconds);
    }
}
