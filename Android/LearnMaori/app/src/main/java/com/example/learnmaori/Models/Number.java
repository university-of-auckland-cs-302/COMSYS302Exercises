package com.example.learnmaori.Models;

public class Number {

    int digit;
    String audioFilename, iconFileName, maoriTranslation;

    public int getDigit() {
        return digit;
    }

    public String getAudioFilename() {
        return audioFilename;
    }

    public String getIconFileName() {
        return iconFileName;
    }

    public String getMaoriTranslation() {
        return maoriTranslation;
    }

    public Number(int digit, String maoriTranslation, String iconFileName, String audioFilename) {
        this.audioFilename = audioFilename;
        this.digit = digit;
        this.iconFileName = iconFileName;
        this.maoriTranslation = maoriTranslation;
    }
}
