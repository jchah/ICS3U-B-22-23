package day3;

public class ExampleThree {
    public static void main(String[] args) {
        int x = 17;

        System.out.println("Remainder: " + (x % 5));
        System.out.println("Division: " + (x / 5));

        int number = 57856;

        /*
        int digit1 = number / 10000 % 10; // 5
        int digit2 = number / 1000 % 10;
        int digit3 = number / 100 % 10;
        int digit4 = number / 10 % 10; // 57856 / 10 - 5785 % 10 = 5
        int digit5 = number / 1 % 10; // 6
         */

        int digit1 = number / 10000;
        int digit2 = number % 10000 / 1000;
        int digit3 = number % 1000 / 100;
        int digit4 = number % 100 / 10;
        int digit5 = number % 10; //

        int sum = digit1 + digit2 + digit3 + digit4 + digit5;
        System.out.println(sum);

    }
}
