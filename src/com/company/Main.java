package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner reader = new Scanner(System.in);
        int age;
        while (true) try {
            System.out.print("Enter your age: ");
            age = reader.nextInt();
            System.out.println(age);
            break;
        } catch (Exception ex) {
            System.out.println("You have entered an invalid age!");
            reader.nextLine();
        }

    }
}
