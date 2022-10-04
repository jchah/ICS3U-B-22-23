package day5;

import java.util.Scanner;

public class QuestionTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double length = sc.nextInt();
        double width = sc.nextInt();
        double perimeter = length * 2 + width * 2;
        double area = length * width;

        System.out.println("The perimeter of the rectangle is " + perimeter);
        System.out.println("The area of the rectangle is " + area);
    }
}
