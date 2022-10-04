package day5;

public class QuestionFour {
    final static int DAYS_PER_YEAR = 365;
    final static int SECONDS_PER_YEAR = DAYS_PER_YEAR * 86400;
    final static double LIGHT_SPEED = 3 * Math.pow(10, 8); // Meters per second

    public static void main(String[] args) {
        double distanceTraveled = LIGHT_SPEED * SECONDS_PER_YEAR;

        System.out.println("Light travels " + distanceTraveled + " meters in " + DAYS_PER_YEAR + " days");
    }
}
