package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
       Scanner reader = new Scanner(System.in);
       System.out.print("Enter your first name: ");
       String firstName = reader.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = reader.nextLine();

        System.out.println("Hello and welcome "+firstName+" "+lastName);
    }
}
