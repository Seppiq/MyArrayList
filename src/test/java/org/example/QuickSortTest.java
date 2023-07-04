package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private QuickSort quickSort;

    @BeforeEach
    void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    void testQuickSortEmptyList() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        assertTrue(list.isEmpty());

        quickSort.quickSort(list, Comparator.naturalOrder());

        assertTrue(list.isEmpty());
    }

    @Test
    void testQuickSortNullComparatorTrowsIllegalArgumentException() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();

        assertThrows(IllegalArgumentException.class, () -> quickSort.quickSort(list, null));
    }

    @Test
    void testQuickSortSingleElementListSortedList() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(5);

        quickSort.quickSort(list, new QuickSortComparator<>());

        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    void testQuickSortMultipleElementsListSortedList() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(10);
        list.add(5);
        list.add(15);

        quickSort.quickSort(list, new QuickSortComparator<>());

        assertEquals(3, list.size());
        assertEquals(15, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(5, list.get(2));
    }

    @Test
    void testQuickSortMultipleStringElementsListSortedList() {
        MyArrayListImpl<String> list = new MyArrayListImpl<>();
        list.add("a");
        list.add("b");
        list.add("c");

        quickSort.quickSort(list, new QuickSortComparator<>());

        assertEquals(3, list.size());
        assertEquals("c", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("a", list.get(2));
    }
}