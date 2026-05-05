package com.demo.gym;

public class PremiumMember extends GymMember {

    private String dietPlan;
    private String personalTrainer;

    public PremiumMember(int id, String name, String plan, double fees,
                         String status, String diet, String trainer) {
        super(id, name, plan, fees, status);
        this.dietPlan = diet;
        this.personalTrainer = trainer;
    }

    @Override
    public String toString() {
        return "[Premium] " + super.toString() +
               ", DietPlan=" + dietPlan +
               ", PersonalTrainer=" + personalTrainer;
    }
}
