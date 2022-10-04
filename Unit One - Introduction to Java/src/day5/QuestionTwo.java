package day5;

public class QuestionTwo {
    public static void main(String[] args) {
        double length = 4.5;
        double width = 2.3;
        double perimeter = Math.round((length * 2 + width * 2) * 10.0) / 10.0;
        double area = Math.round(length * width * 10.0) / 10.0;

        System.out.println("The perimeter of the rectangle rounded to the nearest tenth is " + perimeter);
        System.out.println("The area of the rectangle rounded to the nearest tenth is " + area);
    }
}
