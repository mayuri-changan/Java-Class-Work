package com.demo.vehicle;
public class ElectricVehicle extends Vehicle {
    private double batteryCapacity;
    private double chargingTime;

    public ElectricVehicle(int id, String name, double price, String status,
                           double batteryCapacity, double chargingTime) {
        super(id, name, price, status);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    public String toString() {
        return "[Electric] " + super.toString() +
               ", Battery=" + batteryCapacity +
               ", ChargingTime=" + chargingTime;
    }
}

