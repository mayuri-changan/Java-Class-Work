package com.demo.product;

public class Electronic extends Product {

    private int warrantyPeriod;
    private String brand;

    public Electronic(int id, String name, double price, int qty, boolean status,
                             int warrantyPeriod, String brand) {
        super(id, name, price, qty, status);
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Brand: " + brand + ", Warranty: " + warrantyPeriod + " months");
    }
}
