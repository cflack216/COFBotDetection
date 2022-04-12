package com.example.project;

import java.util.Random;

public class saveData {
    private String username;
    private String password;
    private int SSN;
    public saveData() {
        this.username = "SENTINEL";
        this.password = "SENTINEL";
        this.SSN = new Random().nextInt(99);
    }
    public saveData(String username,String password) {
        this.username = username;
        this.password = password;
        System.out.printf("Successfully Created Account\nUsername: %s\nPassword: %s\nSSN: %d\n",this.username,this.password,this.SSN);
    }
    public void setUsername(String username) {
        this.username=username;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String toString() {
        return String.format("Username: %s\nPassword: %s\nSSN: %d\n",this.username,this.password,this.SSN);
    }
}
