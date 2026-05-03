package com.demo.hotel;

public class NonACRoom extends HotelRoom {

    private int fanCount;
    private int floorNumber;

    public NonACRoom(int id, String type, double price, String status,
                     int fanCount, int floor) {
        super(id, type, price, status);
        this.fanCount = fanCount;
        this.floorNumber = floor;
    }

    @Override
    public String toString() {
        return "[Non-AC Room] " + super.toString() +
               ", Fans=" + fanCount +
               ", Floor=" + floorNumber;
    }
}
