package com.demo.employee;

import java.util.Comparator;

public class Comparator1 implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {

        // Compare based on salary
        int result = Double.compare(e1.getSalary(), e2.getSalary());

        // If salary is same, compare by empId (to avoid duplicate removal in TreeSet)
        if (result == 0) {
            return e1.getEmpId() - e2.getEmpId();
        }

        return result;
    }
}
