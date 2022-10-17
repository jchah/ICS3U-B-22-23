package assignments;

import java.util.Scanner;

public class BayviewGlenPools {
    // TODO: change variable names
    static Scanner i = new Scanner(System.in);

    static int inquire(String q) {
        System.out.printf("Input %s: ", q);

        return i.nextInt();
    }

    public static void main(String[] args) {
         int l = inquire("length"), w = inquire("width"), ds = inquire("shallow depth"),
             dd = inquire("deep depth"), t = inquire("transition slope"), ls = inquire("shallow length"),
             p = inquire("price of liner"), tHeight = dd - ds;

        double tLength = Math.sqrt(t*t-tHeight*tHeight),
                ld = l - ls - tLength,
                volume = w * ds * ls + w * dd * ld + tLength * ds * w + 0.5 * w * tLength * tHeight,
                surfaceArea = w * dd + w * ds + 2 * (l * ds + (ld + ld + tLength) * tHeight / 2) + (ld + ls) * w + t,
                cost = surfaceArea * p;

        System.out.printf("Water for 90%%: %.2fL\n", volume*900);
        System.out.printf("Liner needed: %.2f cm²\n", surfaceArea);
        System.out.printf("Liner cost @ $%d/cm²: $%.2f", p, cost);


    }
}
