package search;

public class BinarySearch {

    /*
    @param extends generic object that implements Comparable interface
    @return the index of the element found
    @return -1 if the element is not found
    Upper Bound = O(log(n))
     */
    public static <T extends Comparable<T>> int search(T target, T[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (target == null) {
            throw new IllegalArgumentException("Target passed cannot be null");
        }
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparedValue = arr[mid].compareTo(target);
            if (comparedValue == 0) {
                return mid; // We found the element and returning the index
            } else if (comparedValue > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // if element is not found
    }

    public static void main(String[] args) {
        int element  = 9;
        int index = search(element, new Integer[]{1,3,6,7,9,11});
        System.out.println(String.format("The index of the element %d is : ",element)+index);
    }
}
