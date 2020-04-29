package com.example;

public class Circle extends Shape{
    // Private instance variables
    private double radius;


    // Constructors (overloaded)
    public Circle() {                   // 1st Constructor (default constructor)
        this.radius = 1.0;
        super.colour = "red";

    }

    public Circle(double r) {           // 2nd Constructor
        this.radius = r;
        super.colour = "red";
    }

    public Circle(double r, String c) { // 3rd Constructor
        this.radius = r;
        super.colour = c;

    }

    // Public methods
    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
        radius = r;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter(){
        return  radius * Math.PI * 2;
    }

    @Override
    public String toString(){
        return  "A circle with radius of " + radius + " and colour of " +  colour;
    }

}