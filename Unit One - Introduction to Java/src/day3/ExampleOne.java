package day3;

public class ExampleOne {
    public static void main(String[] args) {

        // Variables allow us to store data/information
        // We must declare the variable and the type of data it will store

        // Primitive Data Types
        // int -> integer (have no decimal portion)
        // double -> decimal numbers
        // boolean -> true / false

        // Naming convention for variables (camelCase)

        /* int age = 17.9; cannot convert a double to an int. 17.9 is a double and age
        is an int */
        int numberOfStudents = 13; // = assignment operator (it assigns a value to a variable)
        double averageAge = 18.3;

        System.out.println(numberOfStudents);
        System.out.println(averageAge);
        System.out.println(5 + 3);

        // Good practice declare variables as you need them
        int numberOne, numberTwo, numberThree; // you can declare multiple variables of the same type on the same line.

        numberOne = 10;
        numberTwo = 16;
        numberThree = 11;

        int sum = numberOne + numberTwo + numberThree;

        System.out.println("The sum is " + sum); // String concatenation

        // String concatenation is when I join something to a String using +

    }
}
