package com.epam.pavel_kuzichkin.java.lesson4.task4.DynamicArray;

public interface DynamicArrayInterface<T> {
    void add(T value);

    T get(Integer index);

    void set(T value, Integer position);

    void remove(Integer index);
}
