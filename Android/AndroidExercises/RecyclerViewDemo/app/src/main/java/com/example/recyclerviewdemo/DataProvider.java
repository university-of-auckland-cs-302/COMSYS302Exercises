package com.example.recyclerviewdemo;

import android.content.Context;
import android.util.Log;

import com.example.recyclerviewdemo.models.Contact;

import java.util.ArrayList;
import java.util.Random;

public class DataProvider {

    static String[] names = {"Emma", "Olivia", "Ava", "Isabella", "Sophia", "Charlotte", "Mia", "Amelia",
            "Harper", "Evelyn", "Abigail", "Emily", "Elizabeth", "Mila", "Ella", "Avery",
            "Sofia", "Camila", "Aria", "Scarlett", "Victoria", "Madison", "Luna", "Grace", "Chloe",
            "Penelope", "Layla", "Riley"};

    public static ArrayList<Contact> generateData() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        Random random = new Random();
        for (String name : names) {
            int rnd = random.nextInt(2);
            Boolean isOnline;
            if (rnd == 0)
                isOnline = true;
            else
                isOnline = false;

            Contact aContact = new Contact(name, isOnline);
            contacts.add(aContact);
        }
        return contacts;
    }

}
