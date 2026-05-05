package com.demo.gym;

public class RegularMember extends GymMember {

    private String trainerName;
    private int workoutHours;

    public RegularMember(int id, String name, String plan, double fees,
                         String status, String trainer, int hours) {
        super(id, name, plan, fees, status);
        this.trainerName = trainer;
        this.workoutHours = hours;
    }

    @Override
    public String toString() {
        return "[Regular] " + super.toString() +
               ", Trainer=" + trainerName +
               ", Hours=" + workoutHours;
    }
}
