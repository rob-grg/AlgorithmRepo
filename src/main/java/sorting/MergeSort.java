package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        int key = 0;
        int i = 0, j = 0;
        int[] temp = new int[right - left + 1];
        while (left + i <= mid && mid + 1 + j <= right) {
            if (arr[left + i] < arr[mid + 1 + j]) {
                temp[key] = arr[left + i];
                i++;
            } else {
                temp[key] = arr[mid + 1 + j];
                j++;
            }
            key++;
        }

        while (left + i <= mid) {
            temp[key] = arr[left + i];
            i++;
            key++;
        }
        while (mid + 1 + j <= right) {
            temp[key] = arr[mid + 1 + j];
            j++;
            key++;
        }
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 0, 22, 11, 7};
        sort(arr, 0, arr.length - 1);
        System.out.println("The Sorted Array for {5, 3, 1, 0, 22, 11, 7} using merge sort : "+Arrays.toString(arr));
    }
}
