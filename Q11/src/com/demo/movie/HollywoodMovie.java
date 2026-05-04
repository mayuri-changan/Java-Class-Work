package com.demo.movie;

public class HollywoodMovie extends Movie {

    private String studioName;
    private double budget;

    public HollywoodMovie(int id, String name, double duration, double rating,
                          String status, String studioName, double budget) {
        super(id, name, duration, rating, status);
        this.studioName = studioName;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "[Hollywood] " + super.toString() +
               ", Studio=" + studioName +
               ", Budget=" + budget;
    }
}
