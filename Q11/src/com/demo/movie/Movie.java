package com.demo.movie;

public class Movie {
    protected int movieId;
    protected String movieName;
    protected double duration;
    protected double rating;
    protected String status; // available / unavailable

    public Movie(int movieId, String movieName, double duration, double rating, String status) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        this.rating = rating;
        this.status = status;
    }

    public int getMovieId() { return movieId; }
    public String getMovieName() { return movieName; }
    public double getDuration() { return duration; }
    public double getRating() { return rating; }
    public String getStatus() { return status; }

    public void setRating(double rating) { this.rating = rating; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "ID=" + movieId + ", Name=" + movieName +
               ", Duration=" + duration + ", Rating=" + rating +
               ", Status=" + status;
    }
}
