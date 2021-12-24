package sorting;

import java.util.Arrays;

public class InsertionSort {

    /*
    @param takes unsorted array
    @param array passed cannot be empty
    Upper Bound = O(n2)
     */
    private static void sort(int arr[]) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be Empty");
        }
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] >= arr[j + 1]) {
                int tmp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 0, 5, 3, 7, 22, 1};
        sort(arr);
        System.out.println("The sorted array is " + Arrays.toString(arr));
    }
}
