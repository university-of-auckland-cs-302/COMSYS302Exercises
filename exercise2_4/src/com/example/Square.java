package com.example;

public class Square extends Rectangle {

    //attribute
    private double side;


    // Constructors (overloaded)
    public Square() {                   // 1st Constructor (default constructor)
        super.colour = "yellow";
    }

    public Square(double side) {           // 2nd Constructor
        super(side,side);
    }

    public Square(double side, String c) { // 3rd Constructor
        super(side,side,c);
    }

   //methods

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
    }


    @Override
    public String toString(){
        return  "A square with side of " + side + " and colour of " +  colour;
    }

}
