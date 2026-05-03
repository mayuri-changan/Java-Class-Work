package com.demo.string;

import java.util.*;
import java.io.*;

public class VectorString {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        Vector<String> list1 = new Vector<>();
        Vector<String> list2 = new Vector<>();
        Vector<String> list3 = new Vector<>();

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list1.add(str);
        }

        for (String s : list1) {

            if (isUpperCaseString(s)) {
                list2.add(s);
            }

            if (endsWithVowel(s)) {
                list3.add(s);
            }
        }

        System.out.println("\nUppercase Strings:");
        list2.forEach(System.out::println);

        System.out.println("\nStrings ending with vowel:");
        list3.forEach(System.out::println);

        writeToFile("upper.txt", list2);
        writeToFile("vowel.txt", list3);

        System.out.println("\nFiles created successfully.");
    }

    public static boolean isUpperCaseString(String s) {
        return s.equals(s.toUpperCase()) && s.matches("[A-Z]+");
    }

    public static boolean endsWithVowel(String s) {
        char ch = Character.toLowerCase(s.charAt(s.length() - 1));
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }

    public static void writeToFile(String fileName, Vector<String> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
