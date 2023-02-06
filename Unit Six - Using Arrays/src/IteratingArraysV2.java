public class IteratingArraysV2 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 45, 6, 7, 78, 5, 3, 23, 2 };

        // iterate front to back
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }

        // iterate back to front
        // for (int i = arr.length - 1; i >= 0; i--) {
        // System.out.println(arr[i]);
        // }

        // int sum = 0;
        // for (int i = 0; i < arr.length; i++) {
        // sum += arr[i];
        // }
        // System.out.println(sum);

        // double average = getBetterAverage(arr);
        // System.out.println(average);

        int index = search(arr, 7);
        System.out.println(index);

        index = search(arr, 8);
        System.out.println(index);

    }

    private static int search(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return i;
        }

        return -1;
    }

    private static double getBetterAverage(int[] arr) {
        int sum = 0;
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (min > arr[i])
                min = arr[i];

            if (max < arr[i])
                max = arr[i];
        }

        return (sum - min - max) / (arr.length - 2.0);
    }

}