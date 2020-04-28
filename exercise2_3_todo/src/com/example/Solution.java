package com.example;

import java.util.*;

public class Solution {


    public static void main(String []args){
        //Book new_novel=new Book();       //Try this line you'll get prHMain.java:25: error: Book is abstract; cannot be instantiated
        Scanner sc=new Scanner(System.in);
        String title=sc.nextLine();

        MyBook new_novel=new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: "+new_novel.getTitle());
        sc.close();

    }



}
