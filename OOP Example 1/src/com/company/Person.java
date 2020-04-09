package com.company;

public abstract class Person {

    // Attributes
    protected int age, idNumber;
    protected String firstName, lastName;

    // Methods
    public Person()
    {
        age=-1;
        firstName="Not provided";
        lastName = "Not provided";
        idNumber=-1;
    }

    public Person(int idNumber, int age, String firstName, String lastName)
    {
        this.idNumber = idNumber;
        this.age = age;
        this.lastName=lastName;
        this.firstName =firstName;
    }

    public Person(int idNumber)
    {
        age=-1;
        firstName="Not provided";
        lastName = "Not provided";
        this.idNumber= idNumber;
    }

}
