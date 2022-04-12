package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class stopsignCaptcha implements Initializable {
    /*
    imageSource imgS1;
    imageSource imgS2;
    imageSource imgS3;
    imageSource imgS4;
     */
    private int[] scores = new int[8];
    @FXML
    private TilePane captcha;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private Button confirm;
    @FXML
    private Button calibrate;
    @FXML
    private Label welcome;

    public void imgSet() throws FileNotFoundException {
        try {
            //InputStream stream = new FileInputStream("src/main/resources/images/Ekaterinburg-city.jpg");
            InputStream stream = new FileInputStream(Application.stopsign[Application.selInts[0]].getPath());
            Image image = new Image(stream);
            img1.setImage(image);
            stream = new FileInputStream(Application.stopsign[Application.selInts[1]].getPath());
            image = new Image(stream);
            img2.setImage(image);
            stream = new FileInputStream(Application.stopsign[Application.selInts[2]].getPath());
            image = new Image(stream);
            img3.setImage(image);
            stream = new FileInputStream(Application.stopsign[Application.selInts[3]].getPath());
            image = new Image(stream);
            img4.setImage(image);
            stream.close();
            image.cancel();
        } catch(Exception e) {System.exit(1);}
    }
    public void imgProperties1() {
        if(Application.stopsign[Application.selInts[0]].getStatus()) {
            img1.setOpacity(1.0);
            Application.stopsign[Application.selInts[0]].select();
        } else {
            img1.setOpacity(.5);
            Application.stopsign[Application.selInts[0]].select();
        }
    }
    public void imgProperties2() {
        if(Application.stopsign[Application.selInts[1]].getStatus()) {
            img2.setOpacity(1.0);
            Application.stopsign[Application.selInts[1]].select();
        } else {
            img2.setOpacity(.5);
            Application.stopsign[Application.selInts[1]].select();
        }
    }
    public void imgProperties3() {
        if(Application.stopsign[Application.selInts[2]].getStatus()) {
            img3.setOpacity(1.0);
            Application.stopsign[Application.selInts[2]].select();
        } else {
            img3.setOpacity(.5);
            Application.stopsign[Application.selInts[2]].select();
        }
    }
    public void imgProperties4() {
        if(Application.stopsign[Application.selInts[3]].getStatus()) {
            img4.setOpacity(1.0);
            Application.stopsign[Application.selInts[3]].select();
        } else {
            img4.setOpacity(.5);
            Application.stopsign[Application.selInts[3]].select();
        }
    }
    public void reCalculate() throws IOException {
        Application.Calculate("stopsignkey.txt",Application.stopsign,"tableCaptcha.fxml");
    }
    public void reCalibrate() throws IOException{
        Application.calibrate("stopsignkey.txt",Application.stopsign);
        Application m = new Application();
        m.changeScene("tableCaptcha.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Application.stopsign[0] = new imageSource("src/main/resources/images/stopsigns/japan.jpg",0);
        Application.stopsign[1] = new imageSource("src/main/resources/images/stopsigns/OIP.jpg",1);
        Application.stopsign[2] = new imageSource("src/main/resources/images/stopsigns/stopsign.jpg",2);
        Application.stopsign[3] = new imageSource("src/main/resources/images/stopsigns/usa.jpg",3);
        Application.stopsign[4] = new imageSource("src/main/resources/images/stopsigns/440px-Blue_stop_sign_-_hawaii_-_oct_2015.png",4);
        Application.stopsign[5] = new imageSource("src/main/resources/images/stopsigns/u-turn-sign.png",5);
        Application.stopsign[6] = new imageSource("src/main/resources/images/stopsigns/street.jpg",6);
        Application.stopsign[7] = new imageSource("src/main/resources/images/stopsigns/street2.jpg",7);
        scores = Application.getScores("stopsignkey.txt");
        for(int i = 0;i<8;i++) {
            Application.stopsign[i].setStrength(scores[i]);
        }
        for(int i =0;i<4;i++){
            System.out.println(String.format("Displaying %d %d",Application.stopsign[Application.selInts[i]].getStrength(), Application.stopsign[Application.selInts[i]].index));
        }
        //System.out.println(Application.stopsign);
        try {
            imgSet();
        } catch (FileNotFoundException e) {}
    }
}
