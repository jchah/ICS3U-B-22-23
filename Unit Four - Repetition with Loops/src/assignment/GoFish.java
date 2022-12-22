package assignment;
import java.util.Scanner;

public class GoFish {
    private static final int NUM_FACE = 13;
    private static final int NUM_SUITS = 4;
    private static final int RESET_CARDS = -2;
    private static final int MAX_SCORE = 2;
    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String cards1, cards2, cards3, cards4;
        int score1 = 0, score2 = 0, score3 = 0, score4 = 0;
        String temp;
        String suit;
        String card;
        String hand;
        int beginIndex = 1; // 1 % 2 != 0
        int randPlayer = (int) (Math.random() * 4) + 1;
        String randCard;
        boolean gameOver = false;
        String playAgain;

        cards1 = getHand();
        cards2 = getHand();
        cards3 = getHand();
        cards4 = getHand();

        temp = checkPairs(cards1);
        cards1 = parseHand(temp);
        score1 += parseScore(temp);
        temp = checkPairs(cards2);
        cards2 = parseHand(temp);
        score2 += parseScore(temp);
        temp = checkPairs(cards3);
        cards3 = parseHand(temp);
        score3 += parseScore(temp);
        temp = checkPairs(cards4);
        cards4 = parseHand(temp);
        score4 += parseScore(temp);

        while (!gameOver) {
            // On last run of for loop hands with no cards don't reach fixHand in time
            cards1 = fixHand(cards1);
            cards2 = fixHand(cards2);
            cards3 = fixHand(cards3);
            cards4 = fixHand(cards4);

            System.out.println("Adjusted hand: " + cards1);
            System.out.println("Player 1 (you) score: " + score1);
            System.out.println("Player 2 score: " + score2);
            System.out.println("Player 3 score: " + score3);
            System.out.println("Player 4 score: " + score4);

            String face = "";
            while (!face.matches("[23456789XJQKA]")) {
                System.out.print("Card request (2...9, X, J, Q, K, A): ");
                face = in.nextLine();
            }

            int player = choosePlayer();

            if (player == 2 && cards2.contains(face)) {
                suit = cards2.charAt(cards2.indexOf(face) + 1) + "";
                card = face + suit;
                cards1 += card;
                cards2 = cards2.replaceFirst(card, "");
                System.out.printf("You got %s from player %d\n", card, player);
            } else if (player == 3 && cards3.contains(face)) {
                suit = cards3.charAt(cards3.indexOf(face) + 1) + "";
                card = face + suit;
                cards1 += card;
                cards3 = cards3.replaceFirst(card, "");
                System.out.printf("You got %s from player %d\n", card, player);
            } else if (player == 4 && cards4.contains(face)) {
                suit = cards4.charAt(cards4.indexOf(face) + 1) + "";
                card = face + suit;
                cards1 += card;
                cards4 = cards4.replaceFirst(card, "");
                System.out.printf("You got %s from player %d\n", card, player);
            } else {
                card = getCard();
                cards1 += card;
                System.out.printf("Player %d says \"go fish!\" and you randomly draw %s\n", player, card);
            }

            temp = checkPairs(cards1);
            cards1 = parseHand(temp);
            score1 += parseScore(temp);

            for (int i = 2; i < 5; i++) {
                cards1 = fixHand(cards1);
                cards2 = fixHand(cards2);
                cards3 = fixHand(cards3);
                cards4 = fixHand(cards4);
                // randPlayer must be different from player asking (i)
                while (randPlayer == i) {
                    randPlayer = (int) (Math.random() * 4) + 1;
                }
                if (i == 2)
                    hand = cards2;
                else if (i == 3)
                    hand = cards3;
                else
                    hand = cards4;

                while (beginIndex % 2 != 0) {
                    beginIndex = (int) (Math.random() * hand.length()) - 1;
                }
                randCard = hand.substring(beginIndex, beginIndex + 2);
                face = String.valueOf(randCard.charAt(0));
                System.out.printf("Player %d asks player %d for %s\n", i, randPlayer, face);

                if (randPlayer == 1 && cards1.contains(face)) {
                    suit = cards1.charAt(cards1.indexOf(face) + 1) + "";
                    card = face + suit;
                    hand += card;
                    cards1 = cards1.replaceFirst(card, "");
                    System.out.printf("Player %d gives %s to player %d\n", randPlayer, card, i);
                } else if (randPlayer == 2 && cards2.contains(face)) {
                    suit = cards2.charAt(cards2.indexOf(face) + 1) + "";
                    card = face + suit;
                    hand += card;
                    cards2 = cards2.replaceFirst(card, "");
                    System.out.printf("Player %d gives %s to player %d\n", randPlayer, card, i);
                } else if (randPlayer == 3 && cards3.contains(face)) {
                    suit = cards3.charAt(cards3.indexOf(face) + 1) + "";
                    card = face + suit;
                    hand += card;
                    cards3 = cards3.replaceFirst(card, "");
                    System.out.printf("Player %d gives %s to player %d\n", randPlayer, card, i);
                } else if (randPlayer == 4 && cards4.contains(face)) {
                    suit = cards4.charAt(cards4.indexOf(face) + 1) + "";
                    card = face + suit;
                    hand += card;
                    cards4 = cards4.replaceFirst(card, "");
                    System.out.printf("Player %d gives %s to player %d\n", randPlayer, card, i);
                } else {
                    card = getCard();
                    hand += card;
                    System.out.printf("Player %d says \"go fish!\" and player %d randomly draws %s\n", randPlayer, i, card);
                }

                temp = checkPairs(hand);
                hand = parseHand(temp);
                if (i == 2) {
                    score2 += parseScore(temp);
                    cards2 = hand;
                } else if (i == 3) {
                    score3 += parseScore(temp);
                    cards3 = hand;
                } else {
                    score4 += parseScore(temp);
                    cards4 = hand;
                }
                beginIndex = 1;
                randPlayer = (int) (Math.random() * 4) + 1;
            }
            if (score1 >= MAX_SCORE)
                System.out.println("Player 1 wins!");
            else if (score2 >= MAX_SCORE)
                System.out.println("Player 2 wins!");
            else if (score3 >= MAX_SCORE)
                System.out.println("Player 3 wins!");
            else if (score4 >= MAX_SCORE)
                System.out.println("Player 4 wins!");

            if (score1 >= MAX_SCORE || score2 >= MAX_SCORE || score3 >= MAX_SCORE || score4 >= MAX_SCORE)
                System.out.println("Play again? ([y]es/[n]o): ");

            playAgain = in.nextLine();

            if (playAgain.toLowerCase().matches("y|yes")) {
                score1 = 0;
                score2 = 0;
                score3 = 0;
                score4 = 0;

                cards1 = getHand();
                cards2 = getHand();
                cards3 = getHand();
                cards4 = getHand();

                temp = checkPairs(cards1);
                cards1 = parseHand(temp);
                score1 += parseScore(temp);
                temp = checkPairs(cards2);
                cards2 = parseHand(temp);
                score2 += parseScore(temp);
                temp = checkPairs(cards3);
                cards3 = parseHand(temp);
                score3 += parseScore(temp);
                temp = checkPairs(cards4);
                cards4 = parseHand(temp);
                score4 += parseScore(temp);

                System.err.println("----------Game reset----------\n");
            } else if (playAgain.toLowerCase().matches("n|no")) {
                System.err.println("----------Game ended----------");
                gameOver = true;
            }
        }
    }

    private static int choosePlayer() {
        while(true) {
            System.out.println("Player to ask (2, 3, 4): ");
            try {
                int p = Integer.parseInt(in.nextLine());
                if(p > 4 || p < 2)
                    System.err.println("Please enter a valid input\n");
                else
                    return p;
            } catch(NumberFormatException e) {
                System.err.println("Please enter a valid input\n");
            }
        }
    }

    private static String fixHand(String hand) {
        if (hand.length() > 0) {
            return hand;
        }
        String temp = getHand();
        System.out.println("Gave new hand: " + temp);
        return temp;
    }

    private static int parseScore(String hand) {
        return Integer.parseInt(hand.substring(hand.indexOf('~') + 1));
    }

    private static String parseHand(String hand) {
        return hand.substring(0, hand.indexOf("~"));
    }

    private static String getHand() {
        StringBuilder cards = new StringBuilder();
        for (int i=0; i< 5; i++)
            cards.append(getCard());
        return cards.toString();
    }

    private static String getCard() {
        return getFace() + getSuit();
    }

    private static String getFace() {
        int rng = (int) (Math.random() * NUM_FACE) + 1;
        if (rng == 1)
            return "A";
        if (rng == 10)
            return "X";
        if (rng == 11)
            return "J";
        if (rng == 12)
            return "Q";
        if (rng == 13)
            return "K";
        return rng + "";
    }

    private static String getSuit() {
        int rng = (int) (Math.random() * NUM_SUITS) + 1;
        if (rng == 1)
            return "H";
        if (rng == 2)
            return "C";
        if (rng == 3)
            return "S";
        return "D";
    }

    private static String checkPairs(String hand) {
        int count = 0;
            for (int i = 0; i < hand.length() - 1; i += 2) {
                String c = hand.charAt(i) + "";
                String temp = hand.substring(hand.indexOf(c) + 2);
                if (temp.contains(c)) {
                    count++;
                    hand = hand.substring(0, i) + temp.substring(0, temp.indexOf(c)) + temp.substring(temp.indexOf(c) + 2);
                    i = RESET_CARDS;
                }
            }
        return hand + "~" + count;
    }
}

