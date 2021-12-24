package sorting;

import java.util.Arrays;

public class MergeSort {

    /*
    @param takes unsorted array
    left index 0 of the array
    right index top most index of the array
    splits the array unto 2 pairs and merge up
    @param arr size cannot be 0
    @param left and right are not checked and
    will throw array index out of bound if wrong index for left and right
    are given
    Upper Bound = O(nlog(n))
     */
    public static void sort(int arr[], int left, int right) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid); // split left part from mid
            sort(arr, mid + 1, right); // split the right part from mid
            merge(arr, left, right); // merge the broken array
        }
    }

    private static void merge(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        int key = 0; // index for the temp array
        int[] temp = new int[right - left + 1]; // to hold the element

        int i = 0, j = 0; // index i for left to mid and j for mid to right
        while (left + i <= mid && mid + 1 + j <= right) {
            if (arr[left + i] < arr[mid + 1 + j]) {
                temp[key] = arr[left + i]; // if element from left array is smaller than right
                i++;
            } else {
                temp[key] = arr[mid + 1 + j]; // if element from right array is smaller than left one
                j++;
            }
            key++;
        }

        while (left + i <= mid) { // put the remaining item into the temp
            temp[key] = arr[left + i];
            i++;
            key++;
        }
        while (mid + 1 + j <= right) { // put the remaining item into the temp
            temp[key] = arr[mid + 1 + j];
            j++;
            key++;
        }
        for (int x = 0; x < temp.length; x++) { // copy from temp to original array
            arr[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 0, 22, 11, 7};
        sort(arr, 0, arr.length - 1);
        System.out.println("The Sorted Array for {5, 3, 1, 0, 22, 11, 7} using merge sort : " + Arrays.toString(arr));
    }
}
