package datastructure.array;

import java.util.Arrays;
/*
This is a Dynamic Array for Integer
 */
public class IntArray {
    private static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_SIZE = 20;
    private int size = 0;
    private int totalCapacity;
    private int[] arr;

    IntArray() {
        this(DEFAULT_SIZE);
    }

    IntArray(int size) {
        this.totalCapacity = size;
        arr = new int[totalCapacity];
    }

    public static void main(String[] args) {
        IntArray arr = new IntArray();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.println(arr);
        arr.reverse();
        System.out.println(arr);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void add(int element) {
        if (size * 100 / totalCapacity >= 75) {
            increaseSize();
        }
        arr[size] = element;
        size++;
    }

    private void increaseSize() {
        if (totalCapacity == MAX_SIZE) {
            throw new StackOverflowError();
        }
        if (totalCapacity * 2 >= MAX_SIZE) {
            totalCapacity = MAX_SIZE - totalCapacity;
        }
        totalCapacity = totalCapacity + totalCapacity / 2; //increase by 150%;
        arr = Arrays.copyOf(arr, totalCapacity);
    }

    private boolean contain(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1; // if element is not found
    }

    public void removeByElement(int element) {
        if (contain(element)) {
            removeByIndex(indexOf(element));
        }
    }

    public void removeByIndex(int index) {
        for (int i = index, j = index + 1; i < size; i++, j++) {
            arr[i] = arr[j];
        }
        size--;
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Illegal index");
        }
        arr[index] = element;
    }

    // runs for n/2 time
    public void reverse() {
        int low = 0;
        int high = size - 1;
        while (low < high) {
            arr[high] = arr[high] + arr[low];
            arr[low] = arr[high] - arr[low];
            arr[high] = arr[high] - arr[low];
            low++;
            high--;
        }
    }

    @Override
    public String toString() {
        int[] temp = new int[size];
        System.arraycopy(arr, 0, temp, 0, size);
        return Arrays.toString(temp);
    }
}
