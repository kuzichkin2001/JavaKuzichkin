package com.epam.pavel_kuzichkin.java.lesson4.task4.DynamicArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<T> implements Iterable<T>, DynamicArrayInterface<T> {
    private T[] array;
    private Integer count;
    private Integer capacity;

    public DynamicArray() {
        array = (T[]) (new Object[8]);
        count = 0;
        capacity = 8;
    }

    public DynamicArray(Integer length) {
        array = (T[]) (new Object[length]);
        count = 0;
        capacity = length;
    }

    private void refreshArray() {
        capacity *= 2;
        T[] newArr = (T[]) (new Object[capacity]);

        for (int i = 0; i < array.length; ++i) {
            newArr[i] = array[i];
        }

        array = newArr;
    }

    @Override
    public void add(T value) {
        if (count + 1 >= capacity) {
            refreshArray();
        }

        array[count++] = value;
    }

    @Override
    public T get(Integer index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        return array[index];
    }

    @Override
    public void set(T value, Integer position) throws IndexOutOfBoundsException {
        if (position < 0 || position >= count) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        if (count + 1 >= capacity) {
            refreshArray();
        }

        for (Integer i = count; i > position; --i) {
            array[i] = array[i - 1];
        }

        array[position] = value;
        count++;
    }

    @Override
    public void remove(Integer index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        for (Integer i = index; i < count - 1; ++i) {
            array[i] = array[i + 1];
        }

        count--;
    }

    @Override
    public String toString() {
        String result = "[";

        for (Integer i = 0; i < count; ++i) {
            if (i != count - 1) {
                result += array[i].toString() + ", ";
            }
            else {
                result += array[i].toString();
            }
        }

        result += "]";

        return result;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Integer curIdx = 0;

            @Override
            public boolean hasNext() {
                return curIdx < count && array[curIdx] != null;
            }

            @Override
            public T next() {
                return array[curIdx++];
            }
        };
    }
}
