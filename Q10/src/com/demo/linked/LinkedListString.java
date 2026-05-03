package com.demo.linked;

import java.util.*;
import java.io.*;

public class LinkedListString{

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>(); // start & end same char
        LinkedList<String> list3 = new LinkedList<>(); // only digits

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list1.add(str);
        }

        // Processing
        for (String s : list1) {

            if (startsAndEndsSame(s)) {
                list2.add(s);
            }

            if (isOnlyDigits(s)) {
                list3.add(s);
            }
        }

        // Display
        System.out.println("\nStrings starting & ending with same character (list2):");
        list2.forEach(System.out::println);

        System.out.println("\nStrings containing only digits (list3):");
        list3.forEach(System.out::println);

        // Write to files
        writeToFile("samechar.txt", list2);
        writeToFile("digits.txt", list3);

        System.out.println("\nFiles created successfully.");
    }

    // Check start & end same character
    public static boolean startsAndEndsSame(String s) {
        if (s.length() == 0) return false;
        char first = Character.toLowerCase(s.charAt(0));
        char last = Character.toLowerCase(s.charAt(s.length() - 1));
        return first == last;
    }

    // Check only digits
    public static boolean isOnlyDigits(String s) {
        return s.matches("\\d+");
    }

    // Write to file
    public static void writeToFile(String fileName, LinkedList<String> list) {
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
