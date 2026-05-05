package com.demo.strings;

import java.util.*;
import java.io.*;

public class StringAnalysisApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(); // repeated characters
        ArrayList<String> list3 = new ArrayList<>(); // no vowels

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list1.add(str);
        }

        // Processing
        for (String s : list1) {

            if (hasRepeatedCharacters(s)) {
                list2.add(s);
            }

            if (hasNoVowels(s)) {
                list3.add(s);
            }
        }

        // Display
        System.out.println("\nStrings with repeated characters (list2):");
        list2.forEach(System.out::println);

        System.out.println("\nStrings with no vowels (list3):");
        list3.forEach(System.out::println);

        // Write to files
        writeToFile("repeat.txt", list2);
        writeToFile("novowel.txt", list3);

        System.out.println("\nFiles created successfully.");
    }

    // Check repeated characters
    public static boolean hasRepeatedCharacters(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                return true;
            }
            set.add(ch);
        }
        return false;
    }

    // Check no vowels
    public static boolean hasNoVowels(String s) {
        return !s.toLowerCase().matches(".*[aeiou].*");
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
