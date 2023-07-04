package org.example;

import java.util.Comparator;

/**
 * This class provides a method to perform QuickSort on a given MyArrayListImpl.
 * QuickSort is an efficient in-place sorting algorithm and is based on partitioning of array of data into smaller arrays.
 * This class should be used when you have a MyArrayListImpl that needs to be sorted according to the provided Comparator.
 */
public class QuickSort {
    /**
     * Initiates the QuickSort on the given MyArrayListImpl according to the given comparator.
     *
     * @param list       The MyArrayListImpl to be sorted.
     * @param comparator The comparator defining the sort order.
     * @throws IllegalArgumentException If the comparator is null.
     */
    public <T> void quickSort(MyArrayListImpl<T> list, Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }
        quickSort(list, 0, list.size() - 1, comparator);
    }

    private <T> void quickSort(MyArrayListImpl<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(list, low, high, comparator);
            quickSort(list, low, pi - 1, comparator);
            quickSort(list, pi + 1, high, comparator);
        }
    }

    private <T> int partition(MyArrayListImpl<T> list, int low, int high, Comparator<T> comparator) {
        T pivot = list.get(high);
        int smallerElementIndex = (low - 1);
        for (int i = low; i < high; i++) {
            if (comparator.compare(list.get(i), pivot) < 0) {
                smallerElementIndex++;
                swap(list, i, smallerElementIndex);
            }
        }
        swap(list, high, smallerElementIndex + 1);
        return (smallerElementIndex + 1);
    }

    private <T> void swap(MyArrayListImpl<T> list, int i1, int i2) {
        T temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }
}