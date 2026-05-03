package com.demo.hotel;

public class ACRoom extends HotelRoom {

    private String acType;
    private int numberOfBeds;

    public ACRoom(int id, String type, double price, String status,
                  String acType, int beds) {
        super(id, type, price, status);
        this.acType = acType;
        this.numberOfBeds = beds;
    }

    @Override
    public String toString() {
        return "[AC Room] " + super.toString() +
               ", ACType=" + acType +
               ", Beds=" + numberOfBeds;
    }
}
