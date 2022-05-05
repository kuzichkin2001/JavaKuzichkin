package com.epam.pavel_kuzichkin.java.lesson7.task7.ThreadedQuickSort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadedQuickSort implements Runnable {
    public static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();
    static final ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

    final int[] my_array;
    final int start, end;

    public ThreadedQuickSort(int[] my_array, int start, int end) {
        this.my_array = my_array;
        this.start = start;
        this.end = end;
    }

    public void quickSort(int[] arr, int start, int end){
        if (end - start + 1 <= 1)
            return;

        int pivot = arr[arr.length / 2];

        int storeIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int swapTemp = arr[i];
                arr[i] = arr[storeIndex];
                arr[storeIndex] = swapTemp;
                storeIndex++;
            }
        }

        int swapTemp = arr[storeIndex];
        arr[storeIndex] = arr[end];
        arr[end] = swapTemp;

        if (end - start + 1 > (int)(arr.length / MAX_THREADS)){
            ThreadedQuickSort quick = new ThreadedQuickSort(arr, start, storeIndex - 1);
            Future<?> future = executor.submit(quick);
            quickSort(arr, storeIndex + 1, end);

            try {
                future.get(1000, TimeUnit.SECONDS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            quickSort(arr, start, storeIndex - 1);
            quickSort(arr, storeIndex + 1, end);
        }
    }

    @Override
    public void run() {
        quickSort(my_array, start, end);
    }
}
