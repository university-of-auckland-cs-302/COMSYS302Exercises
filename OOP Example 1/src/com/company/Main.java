package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Student student1  = new Student("Software Eng", 1234567);
        student1.printStudentInformation();

        System.out.println("---------------------------------");

        Student studetn2 = new Student("Compy Sys", 123576, 98765);
        studetn2.printStudentInformation();

        System.out.println("---------------------------------");


        Student student3 = new Student("Reza","Shahamiri", 40, 345567, "Software Eng", 565246);
        student3.printStudentInformation();
    }
}
