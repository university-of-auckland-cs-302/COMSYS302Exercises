package com.example;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {

        int max = 0;
        int count = 0;

        for(int i = 0; i< ar.length; i++){

            if (ar[i] == max) count ++;

            else if(ar[i]> max) {
                max = ar[i];
                count = 1;
            }
        }

        return count;
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }


        int result = birthdayCakeCandles(ar);

        System.out.println(result);

        scanner.close();

    }
}
