package com.example;
import java.util.*;

public class Solution {

    public static void main(String []args){


        Shape s1 = new Circle(5.5, "blue");  // Upcast Circle to Shape
        System.out.println();
        System.out.println(s1.toString());
        System.out.printf("The area is: %.2f%n", s1.getArea());
        System.out.printf("The perimeter is: %.2f%n", s1.getPerimeter());
        System.out.println("The colour is: " + s1.getColour());


        Circle c1 = (Circle)s1;                   // Downcast back to Circle
        System.out.println();
        System.out.println(c1.toString());
        System.out.printf("The area is %.2f%n", c1.getArea());
        System.out.printf("The perimeter is: %.2f%n", c1.getPerimeter());
        System.out.println("The colour is: "+ c1.getColour());
        System.out.printf("The radius is:  %.2f%n", c1.getRadius());


        // Shape s2 = new Shape();

        Shape s3 = new Rectangle(1.0, 2.0, "green");   // Upcast
        System.out.println();
        System.out.println(s3.toString());
        System.out.println("The area is: " + s3.getArea());
        System.out.println("The perimeter is: " + s3.getPerimeter());
        System.out.println("The colour is: " + s3.getColour());


        Shape s4 = new Square(6.6,"pink");     // Upcast
        System.out.println();
        System.out.println(s4.toString());
        System.out.printf("The area is: %.2f%n", s4.getArea());
        System.out.println("The perimeter is: " + s4.getPerimeter());
        System.out.println("The colour is: " + s4.getColour());



    }

}
