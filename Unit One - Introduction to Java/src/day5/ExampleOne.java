package day5;

import java.util.Scanner;

public class ExampleOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double radius;

        System.out.print("Please enter the radius: ");
        radius = sc.nextDouble();

        double area = Math.PI * Math.pow(radius, 2);

        System.out.println("The area of a circle with a radius of " + radius + " is " + area);

        sc.close();
    }
}
