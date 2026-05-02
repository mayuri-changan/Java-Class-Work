package com.demo.string;

import java.util.*;
import java.io.*;

public class StringProcess {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(); 
        ArrayList<String> list3 = new ArrayList<>(); 

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list1.add(str);
        }

        // Processing
        for (String s : list1) {

            if (startsWithConsonant(s)) {
                list2.add(s);
            }

            if (isPalindrome(s)) {
                list3.add(s);
            }
        }

        // Display
        System.out.println("\nStrings starting with consonant (list2):");
        list2.forEach(System.out::println);

        System.out.println("\nPalindrome strings (list3):");
        list3.forEach(System.out::println);

        // Write to files
        writeToFile("consonant.txt", list2);
        writeToFile("palindrome.txt", list3);

        System.out.println("\nData written to files successfully.");
    }

    // Check consonant
    public static boolean startsWithConsonant(String s) {
        char ch = Character.toLowerCase(s.charAt(0));

        if (!Character.isLetter(ch)) return false;

        return !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    // Check palindrome
    public static boolean isPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(rev);
    }

    // Write to file
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
