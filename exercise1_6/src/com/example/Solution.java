package com.example;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();  //lines


        //save numbers in an array list

        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();

        for(int i=0; i<n ; i++){

            int d = scan.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for(int j =0; j<d; j++){
                row.add(scan.nextInt());
            }
            rows.add(row);
        }

        //answer the queries
        int q = scan.nextInt();

        for (int i=0; i<q; i++){
              int x = scan.nextInt();
              int y = scan.nextInt();

               try {
                   System.out.println(rows.get(x - 1).get(y - 1));
               } catch(Exception ex){
                   System.out.println("ERROR!");
               }
        }



    }
}