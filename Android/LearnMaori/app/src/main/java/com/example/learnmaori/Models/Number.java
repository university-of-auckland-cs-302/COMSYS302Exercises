package com.example.learnmaori.Models;


public class Number extends Items {

    int digit;
    String iconFileName;

    @Override
    public String getIconFilename() {
        return iconFileName;
    }

    @Override
    public int getDigit() {
        return digit;
    }

    public Number(int digit, String maoriTranslation, String iconFileName, String audioFilename) {
        this.audioFilename = audioFilename;
        this.digit = digit;
        this.iconFileName = iconFileName;
        this.maoriTranslation = maoriTranslation;
    }

    // Add a non-argument constructor to enable auto conversion of the Firebase documents to Number objects
    public Number() {
    }
}
