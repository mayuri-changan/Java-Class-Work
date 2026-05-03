package com.demo.hotel;

public class HotelRoom {
    protected int roomId;
    protected String roomType;
    protected double price;
    protected String status; // available / booked

    public HotelRoom(int roomId, String roomType, double price, String status) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.status = status;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID=" + roomId + ", Type=" + roomType +
               ", Price=" + price + ", Status=" + status;
    }
}
