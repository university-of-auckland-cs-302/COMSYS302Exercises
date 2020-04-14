package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // example code here
    static String timeInWords(int h, int m) {


        return ;
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        System.out.println(result);

        scanner.close();
    }
}
