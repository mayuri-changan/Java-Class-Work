package com.demo.string;

import java.util.*;
import java.io.*;

public class StringList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(); // length > 5
        ArrayList<String> list3 = new ArrayList<>(); // starts with vowel

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list1.add(str);
        }

        // Process lists
        for (String s : list1) {

            // length > 5
            if (s.length() > 5) {
                list2.add(s);
            }

            // starts with vowel
            char ch = Character.toLowerCase(s.charAt(0));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                list3.add(s);
            }
        }

        // Display lists
        System.out.println("Strings with length > 5: " + list2);
        System.out.println("Strings starting with vowel: " + list3);

        // Write list2 to data1.txt
        try {
            FileWriter fw1 = new FileWriter("data1.txt");
            for (String s : list2) {
                fw1.write(s + "\n");
            }
            fw1.close();
        } catch (IOException e) {
            System.out.println("Error writing to data1.txt");
        }

        // Write list3 to data2.txt
        try {
            FileWriter fw2 = new FileWriter("data2.txt");
            for (String s : list3) {
                fw2.write(s + "\n");
            }
            fw2.close();
        } catch (IOException e) {
            System.out.println("Error writing to data2.txt");
        }

        sc.close();
    }
}
