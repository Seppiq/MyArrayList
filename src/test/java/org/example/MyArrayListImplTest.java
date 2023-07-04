package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListImplTest {

    @Test
    public void testDefaultArrayListCapacity() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        assertEquals(10, list.getCapacity());
    }

    @Test
    public void testSpecifiedArrayListCapacity() {
        MyArrayListImpl<String> list = new MyArrayListImpl<>(3);

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.getCapacity());
    }

    @Test
    public void testBeEmpty() {
        MyArrayListImpl<Integer> customArrayList = new MyArrayListImpl<>();

        boolean isEmpty = customArrayList.isEmpty();

        assertTrue(isEmpty);
    }

    @Test
    public void testCustomArrayListCapacity() {
        MyArrayListImpl<Integer> customArrayList = new MyArrayListImpl<>(5);
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);

        customArrayList.add(6);

        assertEquals(7, customArrayList.getCapacity());
    }

    @Test
    public void testSetValueAtSpecifiedIndex() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(1);
        list.add(2);

        list.set(0, 3);

        assertTrue(3 == list.get(0));
        assertEquals(2, list.getSize());
        assertEquals(10, list.getCapacity());
    }

    @Test
    public void testAddElementToArrayList() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(1);
        list.add(2);

        list.add(3);

        assertTrue(1 == list.get(0));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));
        assertEquals(3, list.getSize());
    }

    @Test
    public void testAddElementToArrayListAtSpecifiedIndex() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(1);
        list.add(3);
        list.add(5);

        list.add(1, 7);

        assertTrue(1 == list.get(0));
        assertTrue(7 == list.get(1));
        assertTrue(3 == list.get(2));
        assertTrue(5 == list.get(3));
        assertEquals(4, list.getSize());
    }

    @Test
    public void testAddAllAtIndexZero() {
        MyArrayListImpl<String> list = new MyArrayListImpl<>();
        Collection<String> values = Arrays.asList("test1", "test2");

        list.add(0, "test3");
        list.add(1, "test4");
        list.addAll(0, values);

        assertEquals("test1", list.get(0));
        assertEquals("test2", list.get(1));
        assertEquals("test3", list.get(2));
        assertEquals("test4", list.get(3));
        assertEquals(4, list.getSize());
    }

    @Test
    public void testAddAllWithEmptyList() {
        MyArrayListImpl<String> list = new MyArrayListImpl<>();

        Collection<String> values = Arrays.asList("1", "2", "3");
        list.addAll(values);

        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals(3, list.getSize());
    }

    @Test
    public void testAddAllWithExistingElements() {
        MyArrayListImpl<String> list = new MyArrayListImpl<>();
        list.add("1");
        list.add("2");

        Collection<String> values = Arrays.asList("3", "4", "5");
        list.addAll(values);

        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
        assertEquals("5", list.get(4));
        assertEquals(5, list.getSize());
    }

    @Test
    public void testAddAllWithNull() {
        assertThrows(NullPointerException.class, () -> {
            MyArrayListImpl<String> list = new MyArrayListImpl<>();

            list.addAll(null);
        });
    }

    @Test
    public void testClear() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.getSize());

        list.clear();

        assertEquals(0, list.getSize());
    }

    @Test
    public void testContains() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));

        assertFalse(list.contains(4));
        assertFalse(list.contains(null));
    }

    @Test
    public void testContainsByNull() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(null);
        assertTrue(list.contains(null));
    }

    @Test
    public void testIndexOf() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.indexOf(3));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    public void testRemoveByIndexPositive() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.removeByIndex(0);
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    public void testRemoveByIndexNegativeIndexLessThanZero() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeByIndex(-1));
    }

    @Test
    public void testRemoveByIndexNegativeIndexGreaterThanSize() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeByIndex(3));
    }

    @Test
    public void testRemoveByElementNullValue() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(NullPointerException.class, () -> list.removeByElement(null));
    }

    @Test
    public void testRemoveByElementEmptyArray() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();

        assertThrows(NoSuchElementException.class, () -> list.removeByElement(1));
    }

    @Test
    public void testRemoveByNonExistentElement() {
        MyArrayListImpl<Integer> list = new MyArrayListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(NoSuchElementException.class, () -> list.removeByElement(4));
    }
}
