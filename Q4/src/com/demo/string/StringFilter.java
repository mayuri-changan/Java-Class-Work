package com.demo.string;

import java.util.*;
import java.io.*;

public class StringFilter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(); // length < 4
        ArrayList<String> list3 = new ArrayList<>(); // contains digits

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list1.add(str);
        }

        // Processing
        for (String s : list1) {

            // length < 4
            if (s.length() < 4) {
                list2.add(s);
            }

            // contains digits
            if (containsDigit(s)) {
                list3.add(s);
            }
        }

        // Display results
        System.out.println("\nStrings with length < 4 (list2):");
        list2.forEach(System.out::println);

        System.out.println("\nStrings containing digits (list3):");
        list3.forEach(System.out::println);

        // Write to files
        writeToFile("small.txt", list2);
        writeToFile("digits.txt", list3);

        System.out.println("\nData written to files successfully.");
    }

    // Method to check if string contains digit
    public static boolean containsDigit(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    // Method to write list to file
    public static void writeToFile(String fileName, ArrayList<String> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
