package day5;

public class QuestionFive {
    public static void main(String[] args) {
        int gamesWon = 110;
        int gamesLost = 44;
        int totalGames = gamesWon + gamesLost;
        double winPercentage = Math.round(((double) gamesWon / totalGames * 100d) * 1000.0) / 1000.0;

        System.out.println("In 1927, the New York Yankees won " + winPercentage + "% of their games");
    }
}
