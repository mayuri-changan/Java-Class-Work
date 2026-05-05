package com.demo.gym;

import java.util.*;

public class Test {

    static Scanner sc = new Scanner(System.in);
    static LinkedHashMap<Integer, GymMember> map = new LinkedHashMap<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Gym Menu ---");
            System.out.println("1.Add Member");
            System.out.println("2.Remove Member");
            System.out.println("3.Update Fees");
            System.out.println("4.Activate/Deactivate");
            System.out.println("5.Assign Membership");
            System.out.println("6.Display All");
            System.out.println("7.Display By Type");
            System.out.println("8.Display Fees > Value");
            System.out.println("9.Sort By Fees");
            System.out.println("10.Search By Name");
            System.out.println("11.Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addMember(); break;
                case 2: removeMember(); break;
                case 3: updateFees(); break;
                case 4: changeStatus(); break;
                case 5: assignMembership(); break;
                case 6: displayAll(); break;
                case 7: displayByType(); break;
                case 8: displayByFees(); break;
                case 9: sortByFees(); break;
                case 10: searchByName(); break;
                case 11: System.out.println("Exit"); break;
            }

        } while (choice != 11);
    }

    static void addMember() {
        System.out.println("1.Regular  2.Premium");
        int type = sc.nextInt();

        System.out.println("Enter id, name, planType, fees:");
        int id = sc.nextInt();
        String name = sc.next();
        String plan = sc.next();
        double fees = sc.nextDouble();

        if (type == 1) {
            System.out.println("Enter trainer & workout hours:");
            String trainer = sc.next();
            int hours = sc.nextInt();
            map.put(id, new RegularMember(id, name, plan, fees, "active", trainer, hours));
        } else {
            System.out.println("Enter diet plan & personal trainer:");
            String diet = sc.next();
            String trainer = sc.next();
            map.put(id, new PremiumMember(id, name, plan, fees, "active", diet, trainer));
        }
    }

    static void removeMember() {
        System.out.println("Enter memberId:");
        int id = sc.nextInt();
        map.remove(id);
    }

    static void updateFees() {
        System.out.println("Enter memberId:");
        int id = sc.nextInt();
        if (map.containsKey(id)) {
            System.out.println("Enter new fees:");
            map.get(id).setFees(sc.nextDouble());
        }
    }

    static void changeStatus() {
        System.out.println("Enter memberId:");
        int id = sc.nextInt();
        if (map.containsKey(id)) {
            GymMember m = map.get(id);
            m.setStatus(m.getStatus().equals("active") ? "inactive" : "active");
        }
    }

    // Assign based on planType & fees
    static void assignMembership() {
        System.out.println("Enter memberId:");
        int id = sc.nextInt();

        if (map.containsKey(id)) {
            GymMember m = map.get(id);

            if (m.getFees() > 5000) {
                System.out.println("Recommended: Premium Membership");
            } else {
                System.out.println("Recommended: Regular Membership");
            }
        }
    }

    static void displayAll() {
        map.values().forEach(System.out::println);
    }

    static void displayByType() {
        System.out.println("1.Regular  2.Premium");
        int type = sc.nextInt();

        for (GymMember m : map.values()) {
            if (type == 1 && m instanceof RegularMember)
                System.out.println(m);
            else if (type == 2 && m instanceof PremiumMember)
                System.out.println(m);
        }
    }

    static void displayByFees() {
        System.out.println("Enter minimum fees:");
        double f = sc.nextDouble();

        for (GymMember m : map.values()) {
            if (m.getFees() > f)
                System.out.println(m);
        }
    }

    static void sortByFees() {
        List<GymMember> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingDouble(GymMember::getFees));
        list.forEach(System.out::println);
    }

    static void searchByName() {
        System.out.println("Enter name:");
        String name = sc.next();

        for (GymMember m : map.values()) {
            if (m.getMemberName().equalsIgnoreCase(name))
                System.out.println(m);
        }
    }
}
