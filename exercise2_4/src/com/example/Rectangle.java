package com.example;

public class Rectangle extends Shape {

    //attributes
    private double width;
    private double length;

    // Constructors (overloaded)
    public Rectangle() {                   // 1st Constructor (default constructor)
        this.width = 1.0;
        this.length = 1.0;
        super.colour = "yellow";

    }

    public Rectangle(double w, double l) {           // 2nd Constructor
        this.width = w;
        this.length = l;
        super.colour = "yellow";
    }

    public Rectangle(double w, double l, String c) { // 3rd Constructor
        this.width = w;
        this.length = l;
        super.colour = c;

    }

    // Public methods

    public double getWidth(){
        return width;
    }

    public void setWidth(double w){
        this.width = w;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double l) {
        this.length = length;
    }


    public double getArea(){
        return width * length;
    }


    public double getPerimeter(){
        return  (width+length)*2;
    }


    @Override
    public String toString(){
        return  "A Rectangle with width of " + width + " and length of " + length + ", and colour of " +  colour;
    }


}
