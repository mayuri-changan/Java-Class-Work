package com.demo.product;

import java.util.*;

public class Test
{

    static HashMap<Integer, Product> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Price & Quantity");
            System.out.println("4. Mark Unavailable");
            System.out.println("5. Purchase Product");
            System.out.println("6. Display All");
            System.out.println("7. Display by Type");
            System.out.println("8. Quantity < value");
            System.out.println("9. Sort by Price");
            System.out.println("10. Search by Name");
            System.out.println("11. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1: // Add
                    System.out.println("1. Electronic  2. Grocery");
                    int type = sc.nextInt();

                    System.out.println("Enter id, name, price, quantity:");
                    int id = sc.nextInt();
                    String name = sc.next();
                    double price = sc.nextDouble();
                    int qty = sc.nextInt();

                    if (type == 1) {
                        System.out.println("Enter warranty & brand:");
                        int warranty = sc.nextInt();
                        String brand = sc.next();

                        map.put(id, new Electronic(id, name, price, qty, true, warranty, brand));
                    } else {
                        System.out.println("Enter expiry & weight:");
                        String exp = sc.next();
                        double weight = sc.nextDouble();

                        map.put(id, new Grocery(id, name, price, qty, true, exp, weight));
                    }
                    break;

                case 2: // Remove
                    System.out.println("Enter productId:");
                    map.remove(sc.nextInt());
                    break;

                case 3: // Update
                    System.out.println("Enter productId:");
                    Product p = map.get(sc.nextInt());
                    if (p != null) {
                        System.out.println("Enter new price & quantity:");
                        p.setPrice(sc.nextDouble());
                        p.setQuantity(sc.nextInt());
                    }
                    break;

                case 4: // Unavailable
                    System.out.println("Enter productId:");
                    Product p2 = map.get(sc.nextInt());
                    if (p2 != null) {
                        p2.setStatus(false);
                    }
                    break;

                case 5: // Purchase
                    System.out.println("Enter type & max price:");
                    String t = sc.next();
                    double max = sc.nextDouble();

                    for (Product pr : map.values()) {
                        if (pr.getClass().getSimpleName().equalsIgnoreCase(t + "Product")
                                && pr.getPrice() <= max
                                && pr.isStatus()) {
                            pr.display();
                        }
                    }
                    break;

                case 6: // Display all
                    for (Product pr : map.values()) {
                        pr.display();
                    }
                    break;

                case 7: // By type
                    System.out.println("Enter type:");
                    String typ = sc.next();

                    for (Product pr : map.values()) {
                        if (pr.getClass().getSimpleName().equalsIgnoreCase(typ + "Product")) {
                            pr.display();
                        }
                    }
                    break;

                case 8: // Quantity filter
                    System.out.println("Enter quantity:");
                    int q = sc.nextInt();

                    for (Product pr : map.values()) {
                        if (pr.getQuantity() < q) {
                            pr.display();
                        }
                    }
                    break;

                case 9: // Sort
                    List<Product> list = new ArrayList<>(map.values());
                    list.sort(Comparator.comparingDouble(Product::getPrice));

                    for (Product pr : list) {
                        pr.display();
                    }
                    break;

                case 10: // Search
                    System.out.println("Enter name:");
                    String search = sc.next();

                    for (Product pr : map.values()) {
                        if (pr.getProductName().equalsIgnoreCase(search)) {
                            pr.display();
                        }
                    }
                    break;
            }

        } while (choice != 11);

        sc.close();
    }
}
