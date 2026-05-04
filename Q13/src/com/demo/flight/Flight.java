package com.demo.flight;

public class Flight {
    protected int flightId;
    protected String flightName;
    protected int capacity;
    protected double fare;
    protected String status; // available / booked

    public Flight(int flightId, String flightName, int capacity, double fare, String status) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.capacity = capacity;
        this.fare = fare;
        this.status = status;
    }

    public int getFlightId() { return flightId; }
    public String getFlightName() { return flightName; }
    public int getCapacity() { return capacity; }
    public double getFare() { return fare; }
    public String getStatus() { return status; }

    public void setFare(double fare) { this.fare = fare; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "ID=" + flightId + ", Name=" + flightName +
               ", Capacity=" + capacity + ", Fare=" + fare +
               ", Status=" + status;
    }
}
