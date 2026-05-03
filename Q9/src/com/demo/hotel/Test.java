package com.demo.hotel;

import java.util.*;

public class Test{

    static Scanner sc = new Scanner(System.in);
    static ArrayList<HotelRoom> rooms = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Hotel Menu ---");
            System.out.println("1.Add Room");
            System.out.println("2.Remove Room");
            System.out.println("3.Update Price");
            System.out.println("4.Book Room");
            System.out.println("5.Cancel Booking");
            System.out.println("6.Display All");
            System.out.println("7.Display By Type");
            System.out.println("8.Display By Price Range");
            System.out.println("9.Sort By Price");
            System.out.println("10.Search By Type");
            System.out.println("11.Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addRoom(); break;
                case 2: removeRoom(); break;
                case 3: updatePrice(); break;
                case 4: changeStatus("booked"); break;
                case 5: changeStatus("available"); break;
                case 6: displayAll(); break;
                case 7: displayByType(); break;
                case 8: displayByPrice(); break;
                case 9: sortByPrice(); break;
                case 10: searchByType(); break;
                case 11: System.out.println("Exit"); break;
            }

        } while (choice != 11);
    }

    static void addRoom() {
        System.out.println("1.AC Room  2.Non-AC Room");
        int type = sc.nextInt();

        System.out.println("Enter id, type, price:");
        int id = sc.nextInt();
        String rtype = sc.next();
        double price = sc.nextDouble();

        if (type == 1) {
            System.out.println("Enter AC type & beds:");
            String ac = sc.next();
            int beds = sc.nextInt();
            rooms.add(new ACRoom(id, rtype, price, "available", ac, beds));
        } else {
            System.out.println("Enter fan count & floor:");
            int fans = sc.nextInt();
            int floor = sc.nextInt();
            rooms.add(new NonACRoom(id, rtype, price, "available", fans, floor));
        }
    }

    static void removeRoom() {
        System.out.println("Enter roomId:");
        int id = sc.nextInt();
        rooms.removeIf(r -> r.getRoomId() == id);
    }

    static void updatePrice() {
        System.out.println("Enter roomId:");
        int id = sc.nextInt();
        for (HotelRoom r : rooms) {
            if (r.getRoomId() == id) {
                System.out.println("Enter new price:");
                r.setPrice(sc.nextDouble());
            }
        }
    }

    static void changeStatus(String status) {
        System.out.println("Enter roomId:");
        int id = sc.nextInt();
        for (HotelRoom r : rooms) {
            if (r.getRoomId() == id) {
                r.setStatus(status);
            }
        }
    }

    static void displayAll() {
        rooms.forEach(System.out::println);
    }

    static void displayByType() {
        System.out.println("1.AC  2.Non-AC");
        int type = sc.nextInt();

        for (HotelRoom r : rooms) {
            if (type == 1 && r instanceof ACRoom)
                System.out.println(r);
            else if (type == 2 && r instanceof NonACRoom)
                System.out.println(r);
        }
    }

    static void displayByPrice() {
        System.out.println("Enter min & max:");
        double min = sc.nextDouble();
        double max = sc.nextDouble();

        for (HotelRoom r : rooms) {
            if (r.getPrice() >= min && r.getPrice() <= max)
                System.out.println(r);
        }
    }

    static void sortByPrice() {
        rooms.sort(Comparator.comparingDouble(HotelRoom::getPrice));
        displayAll();
    }

    static void searchByType() {
        System.out.println("Enter room type:");
        String type = sc.next();

        for (HotelRoom r : rooms) {
            if (r.getRoomType().equalsIgnoreCase(type))
                System.out.println(r);
        }
    }
}
