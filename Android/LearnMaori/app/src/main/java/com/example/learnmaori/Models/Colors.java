package com.example.learnmaori.Models;

public class Colors extends Items{
    private String backgroundColor, englishColor;

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public String getEnglishColor() {
        return englishColor;
    }

    public Colors(String englishColor, String maoriTranslation, String backgroundColor, String audioFilename)
    {
        this.englishColor=englishColor;
        this.maoriTranslation=maoriTranslation;
        this.backgroundColor=backgroundColor;
        this.audioFilename=audioFilename;
    }

    // Add a non-argument constructor to enable auto conversion of the Firebase documents to Number objects
    public Colors() {
    }
}
