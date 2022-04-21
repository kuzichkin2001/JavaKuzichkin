package com.epam.pavel_kuzichkin.java.lesson5.task5.FileSystemExplorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSystemExplorer implements FileSystemExplorable {
    private File rootFile;
    private Path rootPath;
    private List<File> filesInFolder;
    private HashMap<String, Integer> filesByChar;
    private HashMap<String, Integer> foldersByChar;

    private void initialize(String rootFilePath) throws IOException {
        rootFile = new File(rootFilePath);
        rootPath = Paths.get(rootFilePath);

        filesInFolder = Files.walk(rootPath)
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
        filesByChar = new HashMap<>();
        foldersByChar = new HashMap<>();
    }

    public void executeExplorer(String path, Integer functionNumber) throws IOException {
        Scanner scanner = new Scanner(System.in);

        try {
            initialize(path);

            switch (functionNumber) {
                case 1:
                    System.out.println("File with maximum number of 's' in its name: \n");
                    getFileWithMaximumS();
                    break;
                case 2:
                    findMaxSizeFiles();
                    break;
                case 3:
                    System.out.print("Mean size of the files in current directory and its subdirectories: " + getFolderSize() + " mBytes");
                    break;
                case 4:
                    countFilesByAllUpperLetters(path);
                    break;
                default:
                    break;
            }
        }
        catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }

    private List<Object> findByFileName(String fileName) throws IOException {
        List<Object> result = null;

        try (Stream pathStream = Files.find(rootPath, Integer.MAX_VALUE,
                (path, attrs) -> path.getFileName().toString().equalsIgnoreCase(fileName))
        ) {
            result = (List<Object>) pathStream.collect(Collectors.toList());
        }

        return result;
    }

    // Function #1
    private void getFileWithMaximumS() throws IOException {
        ArrayList<String> fileNames = new ArrayList();

        for (int i = 0; i < filesInFolder.size(); ++i) {
            File filepath = (File) filesInFolder.get(i);
            String[] nameAndType = filepath.toString().split("\\\\");
            fileNames.add(nameAndType[nameAndType.length - 1]);
        }

        int tempMaxS = 0;
        int maxS = 0;
        File path = null;
        String file = "";

        for (int i = 0; i < fileNames.size(); ++i) {
            tempMaxS = 0;
            for (int j = 0; j < fileNames.get(i).length(); ++j) {
                if (fileNames.get(i).charAt(j) == 's') {
                    tempMaxS++;
                }
            }

            if (tempMaxS >= maxS) {
                maxS = tempMaxS;
                path = (File) filesInFolder.get(i);
                file = fileNames.get(i);
            }
        }

        if (path != null) {
            System.out.println("Current path: " + path);
            System.out.println("Current filename: " + file);
        }
    }

    // Function #2
    private void findMaxSizeFiles() {
        Comparator<File> comparator = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return getMegaBytes(o1).compareTo(getMegaBytes(o2));
            }
        };

        filesInFolder.sort(comparator.reversed());

        for (int i = 0; i < 5; ++i) {
            System.out.println(filesInFolder.get(i) + ": " + getMegaBytes((File) filesInFolder.get(i)) + " mBytes");
        }
    }

    // Function #3
    private long getFolderSize() throws IOException {
        Path folder = rootPath;
        long size = Files.walk(folder)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();

        return size / (1024 * 1024);
    }

    private Double getMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024);
    }


    private void countFilesByLetter(String letter) {
        File[] files = rootFile.listFiles();
        int length = files.length;

        for (int i = 0; i < length; ++i) {
            String filename = files[i].getName().toLowerCase();

            if (filename.indexOf(letter.toLowerCase()) == 0 || filename.indexOf(letter.toUpperCase()) == 0) {
                if (files[i].isDirectory()) {
                    foldersByChar.put(letter.toUpperCase(), foldersByChar.get(letter.toUpperCase()) + 1);
                    rootFile = files[i];
                    countFilesByLetter(letter);
                }
                else {
                    filesByChar.put(letter.toUpperCase(), filesByChar.get(letter.toUpperCase()) + 1);
                }
            }
        }
    }

    // Function #4
    private void countFilesByAllUpperLetters(String path) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < alpha.length(); ++i) {
            filesByChar.put(String.valueOf(alpha.charAt(i)), 0);
            foldersByChar.put(String.valueOf(alpha.charAt(i)), 0);

            countFilesByLetter(String.valueOf(alpha.charAt(i)));

            System.out.println("Char: " + String.valueOf(alpha.charAt(i))
                    + ";\n Directories: " + foldersByChar.get(String.valueOf(alpha.charAt(i)))
                    + ";\n Files: " + filesByChar.get(String.valueOf(alpha.charAt(i)))
                    + "\n-------------------------------------\n");

            rootFile = new File(path);
        }
    }
}
