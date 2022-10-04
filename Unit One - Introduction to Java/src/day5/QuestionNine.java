package day5;

import java.util.Scanner;

public class QuestionNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int itemsSold = sc.nextInt();
        double payDue = itemsSold * 0.27;

        System.out.println("$" + payDue + " is due");
    }
}
