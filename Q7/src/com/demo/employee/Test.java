package com.demo.employee;

import java.util.*;

public class Test {

    static TreeSet<Employee> set = new TreeSet<>(new Comparator1());

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Change Status");
            System.out.println("5. Assign by Department");
            System.out.println("6. Display All");
            System.out.println("7. Display by Type");
            System.out.println("8. Salary > value");
            System.out.println("9. Sort by Salary");
            System.out.println("10. Search by Name");
            System.out.println("11. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1: // Add
                    System.out.println("1. Permanent  2. Contract");
                    int type = sc.nextInt();

                    System.out.println("Enter id, name, salary, department:");
                    int id = sc.nextInt();
                    String name = sc.next();
                    double sal = sc.nextDouble();
                    String dept = sc.next();

                    if (type == 1) {
                        System.out.println("Enter PF & Insurance:");
                        String pf = sc.next();
                        String ins = sc.next();

                        set.add(new PermanentEmployee(id, name, sal, dept, true, pf, ins));
                    } else {
                        System.out.println("Enter duration & agency:");
                        int dur = sc.nextInt();
                        String agency = sc.next();

                        set.add(new ContractEmployee(id, name, sal, dept, true, dur, agency));
                    }
                    break;

                case 2: // Remove
                    System.out.println("Enter empId:");
                    int rid = sc.nextInt();
                    set.removeIf(e -> e.getEmpId() == rid);
                    break;

                case 3: // Update salary
                    System.out.println("Enter empId:");
                    int uid = sc.nextInt();

                    for (Employee e : set) {
                        if (e.getEmpId() == uid) {
                            System.out.println("Enter new salary:");
                            double newSal = sc.nextDouble();
                            set.remove(e); // remove old (important for TreeSet)
                            e.setSalary(newSal);
                            set.add(e); // re-add
                            break;
                        }
                    }
                    break;

                case 4: // Status
                    System.out.println("Enter empId:");
                    int sid = sc.nextInt();

                    for (Employee e : set) {
                        if (e.getEmpId() == sid) {
                            e.setStatus(!e.isStatus());
                        }
                    }
                    break;

                case 5: // Department
                    System.out.println("Enter department:");
                    String d = sc.next();

                    for (Employee e : set) {
                        if (e.getDepartment().equalsIgnoreCase(d) && e.isStatus()) {
                            e.display();
                        }
                    }
                    break;

                case 6: // Display all
                    for (Employee e : set) {
                        e.display();
                    }
                    break;

                case 7: // By type
                    System.out.println("Enter type:");
                    String typ = sc.next();

                    for (Employee e : set) {
                        if (e.getClass().getSimpleName().equalsIgnoreCase(typ + "Employee")) {
                            e.display();
                        }
                    }
                    break;

                case 8: // Salary filter
                    System.out.println("Enter salary:");
                    double min = sc.nextDouble();

                    for (Employee e : set) {
                        if (e.getSalary() > min) {
                            e.display();
                        }
                    }
                    break;

                case 9: // Already sorted
                    for (Employee e : set) {
                        e.display();
                    }
                    break;

                case 10: // Search
                    System.out.println("Enter name:");
                    String search = sc.next();

                    for (Employee e : set) {
                        if (e.getEmpName().equalsIgnoreCase(search)) {
                            e.display();
                        }
                    }
                    break;
            }

        } while (choice != 11);

        sc.close();
    }
}
