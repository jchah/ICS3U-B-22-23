package day3;

public class ExampleTwo {
    public static void main(String[] args) {
        int numberOne = 17, numberTwo = 17, numberThree = 19;
        int numStudents = 3;


        /* because all the variables are ints we need to temporarily treat something as a
        double before the division, so we get double division */

        // (type) variable --> will cast the variable as the type
        double averageAge = (double) (numberOne + numberTwo + numberThree) / numStudents;

        // int / int = int
        // double / int = double
        // double /. double = double
        // int / double = double

        System.out.println("Average age is: " + averageAge);

        int x = 6;
        int y = 7;

        System.out.println("The sum of " + x + " and " + y + " is " + x + y);

        // "The sum of 6 and 7 is 67"

        System.out.println("The sum of " + x + " and " + y + " is " + (x + y));

        // "
    }
}
