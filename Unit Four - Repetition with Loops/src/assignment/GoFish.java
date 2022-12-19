package assignment;
import java.util.Scanner;

public class GoFish {
    private static final int NUM_FACE = 13;
    private static final int NUM_SUITS = 4;
    private static final int RESET_CARDS = -2;
    static final Scanner in  = new Scanner(System.in);
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

        cards1 = getHand();
        cards2 = getHand();
        cards3 = getHand();
        cards4 = getHand();

        System.out.println("Original draw: " + cards1);

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

        while (score1 < 10 && score2 < 10 && score3 < 10 && score4 < 10) {
            System.out.println("Pair adjusted hand: " + cards1);
            System.out.println("Player 1 (you) score: " + score1);
            System.out.println("Player 2 score: " + score2);
            System.out.println("Player 3 score: " + score3);
            System.out.println("Player 4 score: " + score4);

            System.out.println("cards2: " + cards2);
            System.out.println("cards3: " + cards3);
            System.out.println("cards4: " + cards4);

            System.out.print("Card request: ");
            String face = in.nextLine();
            System.out.print("From player: ");
            int player = in.nextInt();
            in.nextLine(); // clears buffer

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

            for(int i = 2; i < 5; i++) {
                //FIXME On last iteration hands with one card will not be fixed if it's given away
                cards1 = fixHand(cards1);
                cards2 = fixHand(cards2);
                cards3 = fixHand(cards3);
                cards4 = fixHand(cards4);
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
                }
                else if (i == 3) {
                    score3 += parseScore(temp);
                    cards3 = hand;
                } else {
                    score4 += parseScore(temp);
                    cards4 = hand;
                }
                beginIndex = 1;
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
        return switch (rng) {
            case 1 -> "A";
            case 10 -> "X";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> rng + "";
        };
    }

    private static String getSuit() {
        int rng = (int) (Math.random() * NUM_SUITS) + 1;
        return switch (rng) {
            case 1 -> "H";
            case 2 -> "C";
            case 3 -> "S";
            default -> "D";
        };
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

