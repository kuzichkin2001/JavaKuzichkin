package com.pkuzichkin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        task1_1();
        task1_2();
    }

    private static void task1_1() {
        int[] arr = new int[10];

        int maxNegativeIdx = 0;
        int minPositiveIdx = 0;
        int maxNegative = (int)Integer.MIN_VALUE;
        int minPositive = (int)Integer.MAX_VALUE;

        System.out.println("Initial array:");
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * 10 - Math.random() * 10);
            System.out.println(arr[i]);

            if (arr[i] < 0 && arr[i] > maxNegative) {
                maxNegative = arr[i];
                maxNegativeIdx = i;
            } else if (arr[i] > 0 && arr[i] < minPositive) {
                minPositive = arr[i];
                minPositiveIdx = i;
            }
        }

        System.out.println("\n-------------------------\n");

        System.out.println("Index of minimum positive value in array: " + minPositiveIdx);
        System.out.println("Index of maximum negative value in array: " + maxNegativeIdx);

        System.out.println("\n-------------------------\n");

        System.out.println("Result array:");

        int temp = arr[minPositiveIdx];
        arr[minPositiveIdx] = arr[maxNegativeIdx];
        arr[maxNegativeIdx] = temp;

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

    private static String getOperation(Scanner scan) throws Exception {
        String operation = scan.next();

        if (operation.length() > 1) {
            throw new Exception("You must use only one character operation.");
        }

        return operation;
    }

    private static void task1_2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two real numbers: ");
        Double a = scanner.nextDouble();
        Double b = scanner.nextDouble();

        System.out.print("\nEnter an operation, that you want to perform with 'a' and 'b' (+-/*): ");

        String operation;

        try {
            operation = getOperation(scanner);
        }
        catch (Exception error) {
            System.out.println("Incorrect operation found.");
            return;
        }

        switch (operation) {
            case "+":
                System.out.println("The result of sum is: " + (a + b));
                break;
            case "-":
                System.out.println("The result of substract is: " + (a - b));
                break;
            case "*":
                System.out.println("The result of multiply is: " + (a * b));
                break;
            case "/":
                System.out.println("The result of fraction is: " + (a / b));
                break;
        }
    }
}
