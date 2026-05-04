package com.demo.flight;

import java.util.*;

public class Test {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Flight> flights = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Flight Menu ---");
            System.out.println("1.Add Flight");
            System.out.println("2.Remove Flight");
            System.out.println("3.Update Fare");
            System.out.println("4.Book Flight");
            System.out.println("5.Cancel Booking");
            System.out.println("6.Display All");
            System.out.println("7.Display By Type");
            System.out.println("8.Display By Fare Range");
            System.out.println("9.Sort By Fare");
            System.out.println("10.Search By Name");
            System.out.println("11.Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addFlight(); break;
                case 2: removeFlight(); break;
                case 3: updateFare(); break;
                case 4: changeStatus("booked"); break;
                case 5: changeStatus("available"); break;
                case 6: displayAll(); break;
                case 7: displayByType(); break;
                case 8: displayByFare(); break;
                case 9: sortByFare(); break;
                case 10: searchByName(); break;
                case 11: System.out.println("Exit"); break;
            }

        } while (choice != 11);
    }

    static void addFlight() {
        System.out.println("1.Domestic  2.International");
        int type = sc.nextInt();

        System.out.println("Enter id, name, capacity, fare:");
        int id = sc.nextInt();
        String name = sc.next();
        int capacity = sc.nextInt();
        double fare = sc.nextDouble();

        if (type == 1) {
            System.out.println("Enter state & terminal:");
            String state = sc.next();
            int terminal = sc.nextInt();
            flights.add(new DomesticFlight(id, name, capacity, fare, "available", state, terminal));
        } else {
            System.out.println("Enter country & passportRequired(true/false):");
            String country = sc.next();
            boolean passport = sc.nextBoolean();
            flights.add(new InternationalFlight(id, name, capacity, fare, "available", country, passport));
        }
    }

    static void removeFlight() {
        System.out.println("Enter flightId:");
        int id = sc.nextInt();
        flights.removeIf(f -> f.getFlightId() == id);
    }

    static void updateFare() {
        System.out.println("Enter flightId:");
        int id = sc.nextInt();
        for (Flight f : flights) {
            if (f.getFlightId() == id) {
                System.out.println("Enter new fare:");
                f.setFare(sc.nextDouble());
            }
        }
    }

    static void changeStatus(String status) {
        System.out.println("Enter flightId:");
        int id = sc.nextInt();
        for (Flight f : flights) {
            if (f.getFlightId() == id) {
                f.setStatus(status);
            }
        }
    }

    static void displayAll() {
        flights.forEach(System.out::println);
    }

    static void displayByType() {
        System.out.println("1.Domestic  2.International");
        int type = sc.nextInt();

        for (Flight f : flights) {
            if (type == 1 && f instanceof DomesticFlight)
                System.out.println(f);
            else if (type == 2 && f instanceof InternationalFlight)
                System.out.println(f);
        }
    }

    static void displayByFare() {
        System.out.println("Enter min & max fare:");
        double min = sc.nextDouble();
        double max = sc.nextDouble();

        for (Flight f : flights) {
            if (f.getFare() >= min && f.getFare() <= max)
                System.out.println(f);
        }
    }

    static void sortByFare() {
        flights.sort(Comparator.comparingDouble(Flight::getFare));
        displayAll();
    }

    static void searchByName() {
        System.out.println("Enter flight name:");
        String name = sc.next();

        for (Flight f : flights) {
            if (f.getFlightName().equalsIgnoreCase(name))
                System.out.println(f);
        }
    }
}
