package assignment;

import java.util.Scanner;

public class BayviewGlenPools {
    static Scanner i = new Scanner(System.in);

    // method to simplify input
    static int inquire(String q) {
        System.out.printf("Input %s: ", q);

        return i.nextInt();
    }

    public static void main(String[] args) {
        // prompts user for input
         int l = inquire("length"), w = inquire("width"), ds = inquire("shallow depth"),
             dd = inquire("deep depth"), t = inquire("transition slope"), ls = inquire("shallow length"),
             p = inquire("price of liner/m²"), tHeight = dd - ds;

        // calculations for volume, surface area, and liner cost
        double tLength = Math.sqrt(t*t-tHeight*tHeight),
                ld = l - ls - tLength,
                volume = w * ds * ls + w * dd * ld + tLength * ds * w + 0.5 * w * tLength * tHeight,
                surfaceArea = ds * ls * 2 + ls * w + (ds * tLength + tLength * (dd - ds) / 2) * 2 +
                        t * w + dd * ld * 2 + ld * w + w * dd + w * ds,
                cost = surfaceArea * p;

        System.out.printf("Water for 90%%: %.2fL\n", volume*900);
        System.out.printf("Liner needed: %.2f cm²\n", surfaceArea);
        System.out.printf("Liner cost @ $%d/cm²: $%.2f", p, cost);
    }
}
