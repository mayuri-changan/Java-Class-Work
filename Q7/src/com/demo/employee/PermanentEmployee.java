package com.demo.employee;

public class PermanentEmployee extends Employee {

    private String pfNumber;
    private String insuranceDetails;

    public PermanentEmployee(int id, String name, double sal, String dept, boolean status,
                             String pfNumber, String insuranceDetails) {
        super(id, name, sal, dept, status);
        this.pfNumber = pfNumber;
        this.insuranceDetails = insuranceDetails;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("PF: " + pfNumber + ", Insurance: " + insuranceDetails);
    }
}
