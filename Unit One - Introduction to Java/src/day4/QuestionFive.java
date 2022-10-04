package day4;

public class QuestionFive {
    public static void main(String[] args) {
        int pennies = 1;
        int nickels = 1;
        int dimes = 1;
        int quarters = 1;
        int loonies = 1;
        int toonies = 1;
        double totalChange = pennies * 0.01 + nickels * 0.05 + dimes * 0.1 + quarters * 0.25 + loonies + toonies * 2;

        System.out.println("The change totals $" + totalChange);

    }
}
