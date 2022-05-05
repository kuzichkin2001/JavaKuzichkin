package com.epam.pavel_kuzichkin.java.lesson7.task7;


import com.epam.pavel_kuzichkin.java.lesson7.task7.QuickSort.QuickSort;
import com.epam.pavel_kuzichkin.java.lesson7.task7.ThreadedQuickSort.ThreadedQuickSort;

public class Main {
    public static void main(String[] args) {
        int arr[] = new int[1000];

        System.out.println("First array generating");
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * 100 - Math.random() * 100);
        }

        double start = System.currentTimeMillis(), end = 0;
        // Single-threaded quicksort
        QuickSort quick = new QuickSort();
        quick.quickSort(arr, 0, arr.length - 1);
        end = System.currentTimeMillis();

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nSpent time on single-threaded qsort: " + (end - start));

        System.out.println("\n------------------------------------------------------------\n");

        System.out.println("Second array generating");
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * 100 - Math.random() * 100);
        }

        start = System.currentTimeMillis();
        // Multi-threaded quicksort
        ThreadedQuickSort threadedQuick = new ThreadedQuickSort(arr, 0, arr.length - 1);
        threadedQuick.run();
        end = System.currentTimeMillis();
        System.out.println("Spent time on multi-threaded qsort: " + (end - start));

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}