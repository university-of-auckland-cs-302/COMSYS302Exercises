package com.example.learnmaori.Models;

public abstract class Items implements IItems {
    protected String audioFilename, maoriTranslation;


    public String getAudioFilename() {
        return audioFilename;
    }

    public String getMaoriTranslation() {
        return maoriTranslation;
    }

    public int getDigit() {
        throw new RuntimeException(this.getClass().getSimpleName() + " doesn't have this method");
    }

    public String getIconFilename() {
        throw new RuntimeException(this.getClass().getSimpleName() + " doesn't have this method");
    }

    public String getBackgroundColor() {
        throw new RuntimeException(this.getClass().getSimpleName() + " doesn't have this method");
    }

    public String getEnglishColor() {
        throw new RuntimeException(this.getClass().getSimpleName() + " doesn't have this method");
    }

}
