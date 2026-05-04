package com.demo.flight;

public class DomesticFlight extends Flight {

    private String stateName;
    private int terminalNumber;

    public DomesticFlight(int id, String name, int capacity, double fare,
                          String status, String stateName, int terminal) {
        super(id, name, capacity, fare, status);
        this.stateName = stateName;
        this.terminalNumber = terminal;
    }

    @Override
    public String toString() {
        return "[Domestic] " + super.toString() +
               ", State=" + stateName +
               ", Terminal=" + terminalNumber;
    }
}
