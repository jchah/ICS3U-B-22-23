package day3;

public class ExampleFour {
    public static void main(String[] args) {
        int x = 7;
        x = x + 1; // x is assigned x + 1 - order of operations has = last
        System.out.println(x);

        int numberOfStudents = 26;
        numberOfStudents = numberOfStudents + 1;
        numberOfStudents++; // same as the line above

        System.out.println(numberOfStudents);

        numberOfStudents--;
        System.out.println(numberOfStudents);

        numberOfStudents = numberOfStudents / 3;
        numberOfStudents /= 3; // does the same as the line above

        // +=
        // -=
        // /=
        // %=

        /*
         * These operators will perform that operation on the variable and then reassign
         * that value to the variable.
         */
    }
}
