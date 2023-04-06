package com.example.project;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Application extends javafx.application.Application {

    public static Integer[] selInts = new Integer[8];
    private static Stage stg;
    public static saveData curAccount;
    public static saveData[] saves = new saveData[10];
    public static imageSource[] buses = new imageSource[8];
    public static imageSource[] boats = new imageSource[8];
    public static imageSource[] stopsign = new imageSource[8];
    public static imageSource[] tables = new imageSource[8];

    public static int CAP = 1;
    public static int selIndex = 0;
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("signIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Bot Test");
        stage.setScene(scene);
        stage.show();
        saves[0] = new saveData("caflack","abc");
        for(int i=0;i<selInts.length;i++){
            selInts[i]=i;
        }
        Collections.shuffle(Arrays.asList(selInts));
    }
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static void saveAccount(saveData account) {
        saves[CAP] = account;
        CAP++;
    }
    public static int[] getScores(String path) {
        int[] scores = new int[8];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            for (int i = 0; i < 8; i++) {
                scores[i] = (Integer.parseInt(reader.readLine()));
            }
            reader.close();
        } catch(Exception e){}
        return scores;
    }
    public static void Calculate(String path, imageSource[] images, String nextPage) {
        try {
            int[] scores = new int[4];
            int total = 0;
            //BufferedReader reader = new BufferedReader(new FileReader(path));
            for (int i = 0; i < 4; i++) {
                scores[i] = images[selInts[i]].getStrength();
                total += scores[i];
            }
            for (int i = 0; i < 4; i++) {
                if(((total - scores[i]) / 3 <= scores[i])&&images[selInts[i]].getStatus()){ //If the picture has a bus and User Selected it
                    continue;
                } else if(((total - scores[i]) / 3 >= scores[i])&&!images[selInts[i]].getStatus()){ //If the picture does not have a bus and the user did not select it
                    continue;
                } else {
                    System.err.println("Authentication Failed");
                    return;
                }
            }
            Application m = new Application();
            m.changeScene(nextPage);
        } catch(Exception e){}
    }
    public static void calibrate(String path,imageSource[] images) {
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            StringBuffer inputBuffer = new StringBuffer();
            String keyline;
            int a,i=0;
            keyline = file.readLine();
            while(keyline!=null) {
                a = Integer.parseInt(keyline);
                if(images[i].getStatus()) {
                    a+=10;
                }
                inputBuffer.append(String.format("%d\n",a));
                keyline = file.readLine();
                i++;
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}