package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        //example code here

        String ans = "";

        if(N%2 == 1){
            ans = "Weird";}
        else{
            if(N>=2 && N<= 10){
                ans = "Not Weird";}

            else if(N>=11 && N<= 30) {
                ans = "Weird";}

            else ans = "Not Weird";
        }

        System.out.println(ans);

    }
}