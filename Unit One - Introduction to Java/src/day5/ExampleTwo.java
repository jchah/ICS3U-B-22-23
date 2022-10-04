package day5;

import java.util.Scanner;

public class ExampleTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter two integers: ");

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum = num1 + num2;

        System.out.println(num1 + " + " + num2 + " = " + sum);

        sc.close();
    }
}
