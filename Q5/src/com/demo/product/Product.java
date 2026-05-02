package com.demo.product;

public class Product {
    protected int productId;
    protected String productName;
    protected double price;
    protected int quantity;
    protected boolean status; // true = available

    public Product(int productId, String productName, double price, int quantity, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void display() {
        System.out.println(productId + " " + productName + " " + price + " " + quantity + " " + (status ? "Available" : "Unavailable"));
    }
}
