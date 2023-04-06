package com.example.project;

import java.io.File;

public class imageSource {
    private String path;
    private boolean isSelected;
    private int strength = 0;
    public int index;
    public imageSource(String source, int index) {
        path = source;
        this.index = index;
        isSelected = false;
    }
    public String getPath() {
        return path;
    }
    public void select(){
        if(!isSelected) {
            isSelected = true;
        } else {isSelected = false;}
    }
    public boolean getStatus() {
        return isSelected;
    }

    public int setStrength(int a){
        this.strength = a;
        return strength;
    }
    public int getStrength(){
        return this.strength;
    }
}
