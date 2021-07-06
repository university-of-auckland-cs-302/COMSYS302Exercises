package com.example.learnmaori.Models;


import com.google.firebase.firestore.Exclude;

public class Number extends Items {

    // Ensure attribute names and property names are the same
    // Firestore considers public properties and attributes to create the fields from model objects
    // For example, public property getIconFilename will be converted to iconFilename in Firestore

    int digit;
    String iconFilename;

    @Override
    public String getIconFilename() {
        return iconFilename;
    }

    @Override
    public int getDigit() {
        return digit;
    }

    public Number(int digit, String maoriTranslation, String iconFileName, String audioFilename) {
        this.audioFilename = audioFilename;
        this.digit = digit;
        this.iconFilename = iconFileName;
        this.maoriTranslation = maoriTranslation;
    }

    // Add a non-argument constructor to enable auto conversion of the Firebase documents to Number objects
    public Number() {
    }
}
