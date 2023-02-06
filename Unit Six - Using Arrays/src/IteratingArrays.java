public class IteratingArrays {
    public static void main(String[] args) {
        iterateArray();
        int[] nums = { 1, 2, 54, 6, 3, 1, 23, 5, 12, 9 };
        int index = search(nums, 7);

    }

    /* return index of val, -1 if not there */
    private static int search(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return i;
        }

        return -1;
    }

    private static void iterateArray() {
        int[] nums = { 1, 2, 54, 6, 3, 1, 23, 5, 12, 9 };
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // System.out.println(nums[i]);
            sum += nums[i];
        }

        System.out.println(sum);
    }

}