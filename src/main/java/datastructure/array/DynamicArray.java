package datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

@SuppressWarnings("suppreswarning")
public class DynamicArray<T> implements Iterable<T> {
    private static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_SIZE = 20;
    private int size = 0;
    private int totalCapacity = 0;
    private T[] arr;

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    public DynamicArray(int size) {
        this.totalCapacity = size;
        arr = (T[]) new Object[totalCapacity];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public void add(T element) {
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

    private boolean contain(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1; // if element is not found
    }

    public void removeByElement(T element) {
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

    public void set(int index, T element) {
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
            T tmp = arr[high];
            arr[high] = arr[low];
            arr[low] = tmp;
            low++;
            high--;
        }
    }

    @Override
    public String toString() {
        T[] temp = (T[]) new Object[size];
        System.arraycopy(arr, 0, temp, 0, size);
        return Arrays.toString(temp);
    }

    public static void main(String[] args) {
        DynamicArray<String> dy = new DynamicArray<String>(12);
        dy.add("Rabin");
        dy.add("Babin");
        dy.add("Sabin");
        for (String s : dy) {  // this uses iterator
            System.out.println(s);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
}
