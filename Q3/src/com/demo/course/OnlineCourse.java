package com.demo.course;

public class OnlineCourse extends Course {
    private String platformName;
    private String instructorName;

    public OnlineCourse(int id, String name, int duration, double fees, boolean status,
                        String platformName, String instructorName) {
        super(id, name, duration, fees, status);
        this.platformName = platformName;
        this.instructorName = instructorName;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Platform: " + platformName + ", Instructor: " + instructorName);
    }
}
