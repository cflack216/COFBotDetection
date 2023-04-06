package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

public class busCaptcha implements Initializable {
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
            InputStream stream = new FileInputStream(Application.buses[Application.selInts[0]].getPath());
            Image image = new Image(stream);
            img1.setImage(image);
            stream = new FileInputStream(Application.buses[Application.selInts[1]].getPath());
            image = new Image(stream);
            img2.setImage(image);
            stream = new FileInputStream(Application.buses[Application.selInts[2]].getPath());
            image = new Image(stream);
            img3.setImage(image);
            stream = new FileInputStream(Application.buses[Application.selInts[3]].getPath());
            image = new Image(stream);
            img4.setImage(image);
            stream.close();
            image.cancel();
        } catch(Exception e) {System.exit(1);}
    }
    public void imgProperties1() {
        if(Application.buses[Application.selInts[0]].getStatus()) {
            img1.setOpacity(1.0);
            Application.buses[Application.selInts[0]].select();
        } else {
            img1.setOpacity(.5);
            Application.buses[Application.selInts[0]].select();
        }
    }
    public void imgProperties2() {
        if(Application.buses[Application.selInts[1]].getStatus()) {
            img2.setOpacity(1.0);
            Application.buses[Application.selInts[1]].select();
        } else {
            img2.setOpacity(.5);
            Application.buses[Application.selInts[1]].select();
        }
    }
    public void imgProperties3() {
        if(Application.buses[Application.selInts[2]].getStatus()) {
            img3.setOpacity(1.0);
            Application.buses[Application.selInts[2]].select();
        } else {
            img3.setOpacity(.5);
            Application.buses[Application.selInts[2]].select();
        }
    }
    public void imgProperties4() {
        if(Application.buses[Application.selInts[3]].getStatus()) {
            img4.setOpacity(1.0);
            Application.buses[Application.selInts[3]].select();
        } else {
            img4.setOpacity(.5);
            Application.buses[Application.selInts[3]].select();
        }
    }
    public void reCalculate() throws IOException {
        Application.Calculate("buskey.txt",Application.buses,"boatCaptcha.fxml");
    }
    public void reCalibrate() throws IOException{
        Application.calibrate("buskey.txt",Application.buses);
        Application m = new Application();
        m.changeScene("boatCaptcha.fxml");
    }
    /*
    public int getScore(int index, String path) {
        return scores[index];
    }
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Application.buses[0] = new imageSource("src/main/resources/images/buses/bus.jpg", 0);
        Application.buses[1] = new imageSource("src/main/resources/images/buses/healthline.jpg", 1);
        Application.buses[2] = new imageSource("src/main/resources/images/buses/The-Playhouse-Square-Chandelier-Cleveland.png", 2);
        Application.buses[3] = new imageSource("src/main/resources/images/buses/road-street-asphalt-buildings-city-11569859224wlzoj4mvgf.jpg", 3);
        Application.buses[4] = new imageSource("src/main/resources/images/buses/images (2).jpg", 4);
        Application.buses[5] = new imageSource("src/main/resources/images/buses/download.jpg", 5);
        Application.buses[6] = new imageSource("src/main/resources/images/buses/yes.jpg", 6);
        Application.buses[7] = new imageSource("src/main/resources/images/buses/yup.jpg", 7);
        scores = Application.getScores("buskey.txt");
        for(int i = 0;i<8;i++) {
            Application.buses[i].setStrength(scores[i]);
        }
        for(int i =0;i<4;i++){
            System.out.println(String.format("Displaying %d %d",Application.buses[Application.selInts[i]].getStrength(),Application.buses[Application.selInts[i]].index));
        }
        //System.out.println(Application.buses);
        try {
            imgSet();
        } catch (FileNotFoundException e) {}
    }
}
