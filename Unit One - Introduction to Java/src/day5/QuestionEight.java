package day5;

import java.util.Scanner;

public class QuestionEight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        double numSquared = Math.pow(num, 2);
        double numSqrt = Math.sqrt(num);

        System.out.println(num + " squared = " + numSquared + "\n" + num + " square root = " + numSqrt);
    }
}
    