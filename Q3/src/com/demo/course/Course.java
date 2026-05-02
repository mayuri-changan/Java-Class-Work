package com.demo.course;

public class Course {
    protected int courseId;
    protected String courseName;
    protected int duration;
    protected double fees;
    protected boolean status; // true = active, false = inactive

    public Course(int courseId, String courseName, int duration, double fees, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.fees = fees;
        this.status = status;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void display() {
        System.out.println(courseId + " " + courseName + " " + duration + " " + fees + " " + (status ? "Active" : "Inactive"));
    }
}
