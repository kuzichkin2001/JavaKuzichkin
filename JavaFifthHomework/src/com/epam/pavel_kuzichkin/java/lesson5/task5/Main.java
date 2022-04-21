package com.epam.pavel_kuzichkin.java.lesson5.task5;

import com.epam.pavel_kuzichkin.java.lesson5.task5.FileSystemExplorer.FileSystemExplorable;
import com.epam.pavel_kuzichkin.java.lesson5.task5.FileSystemExplorer.FileSystemExplorer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystemExplorable explorer = new FileSystemExplorer();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path and function number: ");

        String query = scanner.nextLine();
        String[] queryParts = query.split("\s");

        try {
            explorer.executeExplorer(queryParts[0], Integer.valueOf(queryParts[1]));
        }
        catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }
}
