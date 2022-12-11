package assignment;

import java.util.Scanner;

public class GoFish {
    private static final int NUM_FACE = 13;
    private static final int NUM_SUITS = 4;
    private static final int RESET_CARDS = -2;
    static final Scanner in  = new Scanner(System.in);

    public static void main(String[] args) {
        String cards1, cards2, cards3, cards4;
        int score1, score2, score3, score4;
        String temp;
        cards1 = getHand();
        cards2 = getHand();
        cards3 = getHand();
        cards4 = getHand();
        System.out.println("ORIGINAL DRAW: " + cards1);
        temp = checkPairs(cards1);
        cards1 = parseHand(temp);
        score1 = parseScore(temp);
        temp = checkPairs(cards2);
        cards2 = parseHand(temp);
        score2 = parseScore(temp);
        temp = checkPairs(cards3);
        cards3 = parseHand(temp);
        score3 = parseScore(temp);
        temp = checkPairs(cards4);
        cards4 = parseHand(temp);
        score4 = parseScore(temp);
        System.out.println("PAIR ADJUSTED: " + cards1);
        System.out.println("PLAYER SCORE: " + score1);
        System.out.println("COMP1 SCORE: " + score2);
        System.out.println("COMP2 SCORE: " + score3);
        System.out.println("COMP3 SCORE: " + score4);

        /* Prompt what card to ask for (must be a card already in hand) and which player to ask.
        If the computer has the card, take the card, add to score, and remove the pair from the
        deck. Otherwise, the computer says go fish, and you take another card. Every bot must do
        this, implement random functionality to ask random players for the computers turn. */
    }

    private static int parseScore(String hand) {
        return Integer.parseInt(hand.substring(hand.indexOf('~') + 1));
    }

    private static String parseHand(String hand) {
        return hand.substring(0, hand.indexOf("~"));
    }

    private static String getHand() {
        StringBuilder cards = new StringBuilder();
        for (int i=0; i< 5; i++) {
            cards.append(getFace()).append(getSuit());
        }
        return cards.toString();
    }

    private static String getFace() {
        int rng = (int) (Math.random() * NUM_FACE) + 1;
        if(rng == 1)
            return "A";
        else if (rng == 10)
            return "X";
        else if (rng == 11)
            return "J";
        else if (rng == 12)
            return "Q";
        else if (rng == 13)
            return "K";
        else
            return rng + "";
    }

    private static String getSuit() {
        int rng = (int) (Math.random() * NUM_SUITS) + 1;
        if(rng == 1)
            return "H";
        else if (rng == 2)
            return "C";
        else if (rng == 3)
            return "S";
        else
            return "D";
    }

    private static String checkPairs(String hand) {
        int count = 0;
        for (int i = 0; i < hand.length() - 1; i+=2) {
            String c = hand.charAt(i) + "";
            String temp = hand.substring(hand.indexOf(c) + 2);
            if(temp.contains(c)) {
                count++;
                hand = hand.substring(0, i) + temp.substring(0, temp.indexOf(c)) + temp.substring(temp.indexOf(c) + 2);
                i = RESET_CARDS;
            }
        }
        return hand + "~" + count;
    }
}

