package com.demo.employee;

public class Employee {
    protected int empId;
    protected String empName;
    protected double salary;
    protected String department;
    protected boolean status; // true = working

    public Employee(int empId, String empName, double salary, String department, boolean status) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.department = department;
        this.status = status;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isStatus() {
        return status;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void display() {
        System.out.println(empId + " " + empName + " " + salary + " " + department + " " +
                (status ? "Working" : "Resigned"));
    }
}
