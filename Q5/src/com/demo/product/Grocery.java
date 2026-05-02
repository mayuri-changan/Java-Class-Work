package com.demo.product;

public class Grocery extends Product {

    private String expiryDate;
    private double weight;

    public Grocery(int id, String name, double price, int qty, boolean status,
                          String expiryDate, double weight) {
        super(id, name, price, qty, status);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Expiry: " + expiryDate + ", Weight: " + weight + "kg");
    }
}
