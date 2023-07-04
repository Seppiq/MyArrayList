package org.example;

import lombok.Data;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * MyArrayListImpl is a dynamic array implementation of the MyArrayList interface.
 * The array expands when the capacity is reached, maintaining efficient use of memory.
 * Elements can be added, removed, checked for presence, and accessed by index. A representation of the array can also be returned as a string.
 */
@Data
public class MyArrayListImpl<T> implements MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private int capacity;

    private Object[] array;

    /**
     * Resizes the array to adjust for added elements, increasing the array's capacity by 1.5 times,
     * and maintaining efficient use of memory.
     */
    private void resize() {
        int newCapacity = capacity + (capacity >> 1);
        Object[] resizedData = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            resizedData[i] = array[i];
        }

        array = resizedData;
        capacity = newCapacity;
    }

    /**
     * Adds an element to the end of the array. Resizes the array if necessary.
     *
     * @param value The element to be added.
     */
    @Override
    public void add(T value) {
        if (capacity == size) {
            resize();
        }
        array[size] = value;
        size++;
    }

    /**
     * Inserts an element at a specified position in the array.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right. Resizes the array if necessary.
     *
     * @param index The position at which the element is to be inserted.
     * @param value The element to be inserted.
     */
    @Override
    public void add(int index, T value) {
        if (size == array.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    /**
     * Appends all elements in the specified collection to the end of the array, in the order that they are returned by the collection's iterator.
     *
     * @param values The collection containing elements to be added to this list
     */
    @Override
    public void addAll(Collection<T> values) {
        for (T value : values) {
            add(value);
        }
    }

    /**
     * Inserts all the elements in the collection into the array at the specified positions.
     * Shifts the current occupant and subsequent elements to the right.
     *
     * @param index  index at which to insert the first element from the specified collection.
     * @param values collection containing elements to be added to this list.
     */
    @Override
    public void addAll(int index, Collection<T> values) {
        int currentIndex = index;
        for (T value : values) {
            add(currentIndex, value);
            currentIndex++;
        }
    }

    /**
     * Removes all elements from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Returns true if this list contains the specified element.
     * More formally, returns true if and only if this list contains at least one element e such that (value==null ? value==null : value.equals(e)).
     *
     * @param value element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null && value == null)
                return true;
            else if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param value element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null && value == null)
                return i;
            else if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * If this list does not contain the element, it is unchanged.
     *
     * @param value element to be removed from this list, if present
     */
    @Override
    public void removeByElement(T value) {
        if (value == null) {
            throw new NullPointerException("The value to remove cannot be null");
        }

        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return;
            }
        }
        throw new NoSuchElementException("The value does not exist in the array");
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public T get(int index) {

        return (T) array[index];
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param value element to be stored at the specified position
     */
    @Override
    public void set(int index, T value) {

        array[index] = value;
    }

    /**
     * Gets the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int size() {

        return size;
    }

    /**
     * Returns a string representation of this collection.
     * The string representation consists of a list of the collection's elements in the order they are returned by its iterator,
     * enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (comma and space).
     *
     * @return a string representation of this collection.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * Constructs a list with an initial capacity
     *
     * @param capacity The initial capacity of the list
     */
    public MyArrayListImpl(int capacity) {
        this.capacity = capacity;
        array = new Object[this.capacity];
    }

    /**
     * Constructs an empty list with an initial capacity of 10.
     */
    public MyArrayListImpl() {
        this.capacity = DEFAULT_CAPACITY;
        array = new Object[this.capacity];
    }
}