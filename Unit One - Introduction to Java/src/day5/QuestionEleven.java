package day5;

import java.util.Scanner;

public class QuestionEleven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double mass = sc.nextDouble();
        double velocity = sc.nextDouble();
        double kineticEnergy = 0.5 * mass * Math.pow(velocity, 2);

        System.out.println("The kinetic energy of the object is " + kineticEnergy);
    }
}
