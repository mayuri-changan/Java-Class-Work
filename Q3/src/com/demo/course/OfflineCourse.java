package com.demo.course;

public class OfflineCourse extends Course {
    private int classroomNumber;
    private String location;

    public OfflineCourse(int id, String name, int duration, double fees, boolean status,
                         int classroomNumber, String location) {
        super(id, name, duration, fees, status);
        this.classroomNumber = classroomNumber;
        this.location = location;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Classroom: " + classroomNumber + ", Location: " + location);
    }
}
