package org.example;

import java.util.Comparator;

public class QuickSortComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T obj1, T obj2) {
        return obj2.compareTo(obj1);
    }
}