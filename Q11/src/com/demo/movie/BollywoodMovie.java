package com.demo.movie;

public class BollywoodMovie extends Movie {

    private String language;
    private String leadActor;

    public BollywoodMovie(int id, String name, double duration, double rating,
                          String status, String language, String actor) {
        super(id, name, duration, rating, status);
        this.language = language;
        this.leadActor = actor;
    }

    @Override
    public String toString() {
        return "[Bollywood] " + super.toString() +
               ", Language=" + language +
               ", LeadActor=" + leadActor;
    }
}
