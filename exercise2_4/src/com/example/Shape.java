package com.example;

public abstract class Shape {

    //attribute
    protected String colour;

    // Constructors (overloaded)
    public Shape(){
        this.colour = "Undefined";

    }

    public Shape(String colour){

        this.colour = colour;


    }

    //methods
    public String getColour(){
            return colour;
    }

    public void setColour(String c){
            colour = c;
    }


    abstract double getArea();

    abstract double getPerimeter();


    public String toString(){
        return  "A Shape with colour of " +  colour;
    }

}
