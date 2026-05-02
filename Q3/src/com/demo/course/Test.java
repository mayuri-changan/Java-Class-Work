package com.demo.course;

import java.util.*;

public class Test {

    static LinkedList<Course> list = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("a. Add Course");
            System.out.println("b. Remove Course");
            System.out.println("c. Update Fees");
            System.out.println("d. Activate/Deactivate Course");
            System.out.println("e. Enroll in Course");
            System.out.println("f. Display All Courses");
            System.out.println("g. Display Courses by Type");
            System.out.println("h. Display Courses with Fees < value");
            System.out.println("i. Sort by Duration");
            System.out.println("j. Search by Name");
            System.out.println("k. Exit");

            choice = Character.toLowerCase(sc.next().charAt(0));

            switch (choice) {

                case 'a': // Add
                    System.out.println("1. Online  2. Offline");
                    int type = sc.nextInt();

                    System.out.println("Enter id, name, duration, fees:");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int dur = sc.nextInt();
                    double fees = sc.nextDouble();

                    if (type == 1) {
                        System.out.println("Enter platform & instructor:");
                        String platform = sc.next();
                        String instructor = sc.next();

                        list.add(new OnlineCourse(id, name, dur, fees, true, platform, instructor));
                    } else {
                        System.out.println("Enter classroom & location:");
                        int room = sc.nextInt();
                        String loc = sc.next();

                        list.add(new OfflineCourse(id, name, dur, fees, true, room, loc));
                    }
                    break;

                case 'b': // Remove
                    System.out.println("Enter courseId:");
                    int rid = sc.nextInt();
                    list.removeIf(c -> c.getCourseId() == rid);
                    break;

                case 'c': // Update fees
                    System.out.println("Enter courseId:");
                    int fid = sc.nextInt();
                    for (Course c : list) {
                        if (c.getCourseId() == fid) {
                            System.out.println("Enter new fees:");
                            c.setFees(sc.nextDouble());
                        }
                    }
                    break;

                case 'd': // Activate/Deactivate
                    System.out.println("Enter courseId:");
                    int sid = sc.nextInt();
                    for (Course c : list) {
                        if (c.getCourseId() == sid) {
                            c.setStatus(!c.isStatus());
                        }
                    }
                    break;

                case 'e': // Enroll
                    System.out.println("Enter type (Online/Offline) and max duration:");
                    String t = sc.next();
                    int maxDur = sc.nextInt();

                    for (Course c : list) {
                        if (c.getClass().getSimpleName().equalsIgnoreCase(t + "Course")
                                && c.getDuration() <= maxDur
                                && c.isStatus()) {
                            c.display();
                        }
                    }
                    break;

                case 'f': // Display all
                    for (Course c : list) {
                        c.display();
                    }
                    break;

                case 'g': // By type
                    System.out.println("Enter type:");
                    String typ = sc.next();

                    for (Course c : list) {
                        if (c.getClass().getSimpleName().equalsIgnoreCase(typ + "Course")) {
                            c.display();
                        }
                    }
                    break;

                case 'h': // Fees filter
                    System.out.println("Enter max fees:");
                    double max = sc.nextDouble();

                    for (Course c : list) {
                        if (c.getFees() < max) {
                            c.display();
                        }
                    }
                    break;

                case 'i': // Sort
                    list.sort(Comparator.comparingInt(Course::getDuration));
                    System.out.println("Sorted by duration.");
                    break;

                case 'j': // Search
                    System.out.println("Enter name:");
                    String search = sc.next();

                    for (Course c : list) {
                        if (c.getCourseName().equalsIgnoreCase(search)) {
                            c.display();
                        }
                    }
                    break;

                case 'k':
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 'k');

        sc.close();
    }
}
