package com.demo.flight;

public class InternationalFlight extends Flight {

    private String countryName;
    private boolean passportRequired;

    public InternationalFlight(int id, String name, int capacity, double fare,
                               String status, String country, boolean passport) {
        super(id, name, capacity, fare, status);
        this.countryName = country;
        this.passportRequired = passport;
    }

    @Override
    public String toString() {
        return "[International] " + super.toString() +
               ", Country=" + countryName +
               ", PassportRequired=" + passportRequired;
    }
}
