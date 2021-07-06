package com.example.learnmaori.Models;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.NoAllocation;
import com.google.firebase.firestore.Exclude;

public abstract class Items implements IItems {
    protected String audioFilename, maoriTranslation;


    public String getAudioFilename() {
        return audioFilename;
    }

    public String getMaoriTranslation() {
        return maoriTranslation;
    }

    // IMPORTANT NOTE: Exclude annotations must be used for Firebase.
    // Otherwise, setting and adding documents will render these method as properties and
    // call them, which results in throwing an exception.
    @Exclude
    public int getDigit() {
        throw new RuntimeException(this.getClass().getSimpleName() + " doesn't have this method");
    }

    @Exclude
    public String getIconFilename() {
        throw new RuntimeException(this.getClass().getSimpleName() + " doesn't have this method");
    }

    @Exclude
    public String getBackgroundColor() {
        throw new RuntimeException(this.getClass().getSimpleName() + " doesn't have this method");
    }

    @Exclude
    public String getEnglishColor() {
        throw new RuntimeException(this.getClass().getSimpleName() + " doesn't have this method");
    }
}
