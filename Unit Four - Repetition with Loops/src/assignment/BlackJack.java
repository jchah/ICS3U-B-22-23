package assignment;

import java.util.Scanner;

public class BlackJack {
    static Scanner in = new Scanner(System.in);

    private static final int NUM_FACE = 13;
    private static final int NUM_SUITS = 4;
    static final int STARTING_WALLET = 500;
    static final int MIN_BET = 5;

    public static void main(String[] args) {
        String playerHand; // ex. AC 5D JS
        String dealerHand; // 7C (single card until player plays)

        boolean isPlaying = true;

        int wallet = STARTING_WALLET;
        while (isPlaying) {
            int bet = getBet(MIN_BET, wallet);
            playerHand = getCard() + " " + getCard();
            dealerHand = getCard();
            displayHand(playerHand, true);
            displayHand(dealerHand, false);

            wallet += playHand(playerHand, dealerHand, bet);

            if (wallet < MIN_BET) {
                System.out.println("Sorry you cannot play!");
                isPlaying = false;
            } else {
                isPlaying = promptPlayAgain();
            }
        }
    }

    private static boolean promptPlayAgain() {
        return false;
    }

    /* Returns the amount the player won, negative value if they lost */
    private static int playHand(String playerHand, String dealerHand, int bet) {
        return 0;
    }

    private static void displayHand(String cards, boolean isPlayer) {
        if (isPlayer)
            System.out.println("Player Cards: " + cards);
        else
            System.out.println("Dealer Cards: XX " + cards);
    }

    private static String getCard() {
        return getFace() + getSuit();
    }

    private static String getSuit() {
        int rand = (int) (Math.random() * NUM_SUITS) + 1;

        if(rand == 1)
            return "H"; // hearts
        else if (rand == 2)
            return "C"; // clubs
        else if (rand == 3)
            return "S"; // spades
        else
            return "D"; // diamonds
    }

    private static String getFace() {
        int rand = (int) (Math.random() * NUM_FACE) + 1;
        if(rand == 1)
            return "A"; // ace
        else if (rand == 11)
            return "J"; // jack
        else if (rand == 12)
            return "Q"; // queen
        else if (rand == 13)
            return "K"; // king
        else
            return rand + ""; // 2 - 10
    }

    private static int getBet(int minBet, int maxBet) {
        int bet = 0;
        boolean validBet = false;
        while(!validBet) {
            System.out.printf("Please enter a bet (Min: %d): ", minBet);
            try {
                bet = Integer.parseInt(in.nextLine());
                if (bet >= minBet && bet <= maxBet)
                    validBet = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
        return bet;
    }
}
