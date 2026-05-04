package com.demo.strings;

import java.util.*;
import java.io.*;

public class StackStringApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<String> stack = new Stack<>();
        ArrayList<String> list2 = new ArrayList<>(); // palindrome
        ArrayList<String> list3 = new ArrayList<>(); // contains spaces

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine(); // allows spaces
            stack.push(str);
        }

        // Processing
        for (String s : stack) {

            if (isPalindrome(s)) {
                list2.add(s);
            }

            if (containsSpace(s)) {
                list3.add(s);
            }
        }

        // Display
        System.out.println("\nPalindrome Strings (list2):");
        list2.forEach(System.out::println);

        System.out.println("\nStrings containing spaces (list3):");
        list3.forEach(System.out::println);

        // Write to files
        writeToFile("palin.txt", list2);
        writeToFile("space.txt", list3);

        System.out.println("\nFiles created successfully.");
    }

    // Check palindrome
    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("\\s+", "").toLowerCase();
        String rev = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(rev);
    }

    // Check space
    public static boolean containsSpace(String s) {
        return s.contains(" ");
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
