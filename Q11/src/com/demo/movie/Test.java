package com.demo.movie;

import java.util.*;

public class Test{

    static Scanner sc = new Scanner(System.in);
    static TreeMap<Integer, Movie> map = new TreeMap<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Movie Menu ---");
            System.out.println("1.Add Movie");
            System.out.println("2.Remove Movie");
            System.out.println("3.Update Rating");
            System.out.println("4.Mark Unavailable");
            System.out.println("5.Recommend Movie");
            System.out.println("6.Display All");
            System.out.println("7.Display By Type");
            System.out.println("8.Display Rating Above");
            System.out.println("9.Sort By Duration");
            System.out.println("10.Search By Name");
            System.out.println("11.Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addMovie(); break;
                case 2: removeMovie(); break;
                case 3: updateRating(); break;
                case 4: markUnavailable(); break;
                case 5: recommendMovie(); break;
                case 6: displayAll(); break;
                case 7: displayByType(); break;
                case 8: displayByRating(); break;
                case 9: sortByDuration(); break;
                case 10: searchByName(); break;
                case 11: System.out.println("Exit"); break;
            }

        } while (choice != 11);
    }

    static void addMovie() {
        System.out.println("1.Bollywood  2.Hollywood");
        int type = sc.nextInt();

        System.out.println("Enter id, name, duration, rating:");
        int id = sc.nextInt();
        String name = sc.next();
        double duration = sc.nextDouble();
        double rating = sc.nextDouble();

        if (type == 1) {
            System.out.println("Enter language & lead actor:");
            String lang = sc.next();
            String actor = sc.next();
            map.put(id, new BollywoodMovie(id, name, duration, rating, "available", lang, actor));
        } else {
            System.out.println("Enter studio & budget:");
            String studio = sc.next();
            double budget = sc.nextDouble();
            map.put(id, new HollywoodMovie(id, name, duration, rating, "available", studio, budget));
        }
    }

    static void removeMovie() {
        System.out.println("Enter movieId:");
        int id = sc.nextInt();
        map.remove(id);
    }

    static void updateRating() {
        System.out.println("Enter movieId:");
        int id = sc.nextInt();
        if (map.containsKey(id)) {
            System.out.println("Enter new rating:");
            map.get(id).setRating(sc.nextDouble());
        }
    }

    static void markUnavailable() {
        System.out.println("Enter movieId:");
        int id = sc.nextInt();
        if (map.containsKey(id)) {
            map.get(id).setStatus("unavailable");
        }
    }

    static void recommendMovie() {
        System.out.println("Enter type (1.Bollywood 2.Hollywood) and min rating:");
        int type = sc.nextInt();
        double min = sc.nextDouble();

        for (Movie m : map.values()) {
            if (m.getRating() >= min) {
                if (type == 1 && m instanceof BollywoodMovie)
                    System.out.println(m);
                else if (type == 2 && m instanceof HollywoodMovie)
                    System.out.println(m);
            }
        }
    }

    static void displayAll() {
        map.values().forEach(System.out::println);
    }

    static void displayByType() {
        System.out.println("1.Bollywood  2.Hollywood");
        int type = sc.nextInt();

        for (Movie m : map.values()) {
            if (type == 1 && m instanceof BollywoodMovie)
                System.out.println(m);
            else if (type == 2 && m instanceof HollywoodMovie)
                System.out.println(m);
        }
    }

    static void displayByRating() {
        System.out.println("Enter rating:");
        double r = sc.nextDouble();

        for (Movie m : map.values()) {
            if (m.getRating() > r)
                System.out.println(m);
        }
    }

    static void sortByDuration() {
        List<Movie> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingDouble(Movie::getDuration));
        list.forEach(System.out::println);
    }

    static void searchByName() {
        System.out.println("Enter name:");
        String name = sc.next();

        for (Movie m : map.values()) {
            if (m.getMovieName().equalsIgnoreCase(name))
                System.out.println(m);
        }
    }
}
