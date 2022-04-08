package com.epam.pavel_kuzichkin.java.lesson4.task4;

import com.epam.pavel_kuzichkin.java.lesson4.task4.DynamicArray.DynamicArray;

public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<Integer>(5);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        arr.set(10, 2);

        System.out.println(arr);

        arr.remove(0);

        System.out.println(arr);

        try {
            System.out.println(arr.get(3));
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        arr.add(100);

        System.out.println(arr.get(3));
        System.out.println(arr);
    }
}
