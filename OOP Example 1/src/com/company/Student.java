package com.company;

public class Student extends Person {

    // Attributes
    private String major;
    private int studentId;

    // Methods
    public Student(String major, int studentId) {
        super();
        this.major = major;
        this.studentId = studentId;
    }

    public Student(String major, int studentId, int idNumber) {
        super(idNumber);
        this.major = major;
        this.studentId = studentId;
    }

    public Student(String firstName, String lastName, int age, int idNumber, String major, int studentId) {

        super(idNumber, age, firstName, lastName);
        this.major = major;
        this.studentId = studentId;

    }

    public void printStudentInformation() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("ID Number: " + idNumber);
        System.out.println("Major: " + major);
        System.out.println("Student ID: " + studentId);
    }
}
