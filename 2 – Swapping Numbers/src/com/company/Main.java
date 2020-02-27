package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int a = Integer.valueOf(reader.nextLine());

        System.out.print("Enter the second number: ");
        int b = Integer.valueOf(reader.nextLine());

        int t = a;
        a=b;
        b=t;

        System.out.println("After swap the first number is "+a+", and the second number is "+b);
    }
}
