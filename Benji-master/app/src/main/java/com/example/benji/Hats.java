package com.example.benji;

public class Hats {

    private String currentHat;
    public Hats() {
        this.currentHat = "NONE";
    }

    public String getCurrentHat() {
        return this.currentHat;
    }

    public void setCurrentHat(String s) {
        this.currentHat = s;
    }

    public void resetHat() {
        this.currentHat = "NONE";
    }
}
