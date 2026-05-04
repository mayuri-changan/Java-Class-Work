package com.demo.strings;

import java.util.*;
import java.io.*;

public class StringJavaApp {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(); // contains "java"
        ArrayList<String> list3 = new ArrayList<>(); // uppercase strings

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list1.add(str);
        }

        // Processing
        for (String s : list1) {

            // contains "java" (case-insensitive)
            if (s.toLowerCase().contains("java")) {
                list2.add(s);
            }

            // uppercase strings
            if (isUpperCase(s)) {
                list3.add(s);
            }
        }

        // Display
        System.out.println("\nStrings containing 'java' (list2):");
        list2.forEach(System.out::println);

        System.out.println("\nUppercase strings (list3):");
        list3.forEach(System.out::println);

        // Write to files
        writeToFile("java.txt", list2);
        writeToFile("upper.txt", list3);

        System.out.println("\nFiles created successfully.");
    }

    // Check uppercase string
    public static boolean isUpperCase(String s) {
        return s.equals(s.toUpperCase()) && s.matches("[A-Z]+");
    }

    // Write to file
    public static void writeToFile(String fileName, ArrayList<String> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
