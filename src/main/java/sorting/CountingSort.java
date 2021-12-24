package sorting;

import java.util.Arrays;

public class CountingSort {

    private static int findMax(int[] arr) {
        int sum = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > sum)
                sum = x;
        }
        return sum;
    }

    private static void sort(int[] arr, int max) {
        int[] countArray = new int[max + 1];
        Arrays.fill(countArray, 0);

        for (int item : arr) {
            countArray[item]++;
        }
        int key = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                arr[key] = i;
                countArray[i]--;
                key++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 0, 5, 3, 7, 22, 1};
        int max = findMax(arr);
        sort(arr, max);
        System.out.println(Arrays.toString(arr));
    }
}
