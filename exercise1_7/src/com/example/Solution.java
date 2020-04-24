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

        String result = "";

        String[] byOne = {"0", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty" };

        String[] byQua = {" o' clock", "quarter past ", "half past ","quarter to "};


        int hour = 0;

        if (m<=30) hour = h;
        else hour = h+1;



        if (m==0) result = byOne[h] + byQua[m];

        else if (m%15 == 0) result = byQua[m/15] + byOne[hour];

        else if(m<=20) result = byOne[m] + ((m==1)?" minute":" minutes") + " past "+ byOne[hour];

        else if(m<30 && m >20) result = byOne[20]+ " "+ byOne[m-20] + " minutes" + " past "+ byOne[hour];

        else if(m>30 && m <40) result = byOne[20]+ " "+ byOne[40-m] + " minutes"+ " to "+ byOne[hour];

        else result =  byOne[60-m] + ((m==59)?" minute":" minutes") + " to "+ byOne[hour];


        return  result;

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
