package org.example;

import java.util.Collection;

/**
 * This interface represents a list of elements (of generic type T).
 * The user can add, remove, check the presence and position of elements in the list.
 * The list can also be cleared, and one can check if the list is empty or not.
 */
public interface MyArrayList<T> {

    /**
     * Adds a value to the end of the list.
     *
     * @param value The value to be added to the list.
     */
    void add(T value);

    /**
     * Inserts a value at a specified index in the list.
     *
     * @param index The index at which the value should be inserted.
     * @param value The value to be added to the list.
     */
    void add(int index, T value);

    /**
     * Adds all elements from a collection to the end of the list.
     *
     * @param values The collection of values to be added to the list.
     */
    void addAll(Collection<T> values);

    /**
     * Inserts all elements from a collection at a certain position in the list.
     *
     * @param index  The index at which the values should be inserted.
     * @param values The collection of values to be added to the list.
     */
    void addAll(int index, Collection<T> values);

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * Checks if a value is present in the list.
     *
     * @param value The value to check.
     * @return true if the value is found, false otherwise.
     */
    boolean contains(T value);

    /**
     * Returns the index of the first occurrence of the specified value in the list, or -1 if the list does not contain the value.
     *
     * @param value The value to find in the list.
     * @return The index of the value in the list, or -1 if the list does not contain the value.
     */
    int indexOf(T value);

    /**
     * Removes the element at the specified position in the list.
     *
     * @param index The index of the element to be removed.
     */
    void removeByIndex(int index);

    /**
     * Removes the first occurrence of the specified value from the list, if it is present.
     *
     * @param value The value to be removed from the list.
     */
    void removeByElement(T value);

    /**
     * Returns the value at a specified index in the list.
     *
     * @param index The index of the value to return.
     * @return The value at the specified index.
     */
    T get(int index);

    /**
     * Checks if the list is empty.
     *
     * @return true if the list contains no elements, false otherwise.
     */
    boolean isEmpty();

    /**
     * Replaces the value at a specified index in the list.
     *
     * @param index The index of the value to replace.
     * @param value The value to be stored at the specified position.
     */
    void set(int index, T value);

    /**
     * Gets the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    int size();
}
