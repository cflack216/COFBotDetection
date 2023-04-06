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
import java.util.ResourceBundle;

public class boatCaptcha implements Initializable {
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
            InputStream stream = new FileInputStream(Application.boats[Application.selInts[0]].getPath());
            Image image = new Image(stream);
            img1.setImage(image);
            stream = new FileInputStream(Application.boats[Application.selInts[1]].getPath());
            image = new Image(stream);
            img2.setImage(image);
            stream = new FileInputStream(Application.boats[Application.selInts[2]].getPath());
            image = new Image(stream);
            img3.setImage(image);
            stream = new FileInputStream(Application.boats[Application.selInts[3]].getPath());
            image = new Image(stream);
            img4.setImage(image);
            stream.close();
            image.cancel();
        } catch(Exception e) {System.exit(1);}
    }
    public void imgProperties1() {
        if(Application.boats[Application.selInts[0]].getStatus()) {
            img1.setOpacity(1.0);
            Application.boats[Application.selInts[0]].select();
        } else {
            img1.setOpacity(.5);
            Application.boats[Application.selInts[0]].select();
        }
    }
    public void imgProperties2() {
        if(Application.boats[Application.selInts[1]].getStatus()) {
            img2.setOpacity(1.0);
            Application.boats[Application.selInts[1]].select();
        } else {
            img2.setOpacity(.5);
            Application.boats[Application.selInts[1]].select();
        }
    }
    public void imgProperties3() {
        if(Application.boats[Application.selInts[2]].getStatus()) {
            img3.setOpacity(1.0);
            Application.boats[Application.selInts[2]].select();
        } else {
            img3.setOpacity(.5);
            Application.boats[Application.selInts[2]].select();
        }
    }
    public void imgProperties4() {
        if(Application.boats[Application.selInts[3]].getStatus()) {
            img4.setOpacity(1.0);
            Application.boats[Application.selInts[3]].select();
        } else {
            img4.setOpacity(.5);
            Application.boats[Application.selInts[3]].select();
        }
    }
    public void reCalculate() throws IOException {
        Application.Calculate("boatkey.txt",Application.boats,"stopsignCaptcha.fxml");
    }
    public void reCalibrate() throws IOException{
        Application.calibrate("boatkey.txt",Application.boats);
        Application m = new Application();
        m.changeScene("stopsignCaptcha.fxml");
        /*
        Application.calibrate("boatkey.txt",Application.boats);
        Application m = new Application();
        m.changeScene("stopsignCaptcha.fxml");
         */
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Application.boats[0] = new imageSource("src/main/resources/images/boats/069_03_Activities_2011_08_11_0044.jpg",0);
        Application.boats[1] = new imageSource("src/main/resources/images/boats/200-1d9141facbe5329af76942155ef408bd.jpg",1);
        Application.boats[2] = new imageSource("src/main/resources/images/boats/Lake-Erie2-Oct-2-2015-200x150.jpg",2);
        Application.boats[3] = new imageSource("src/main/resources/images/boats/sunset_kayak_slideshow_pic.jpg",3);
        Application.boats[4] = new imageSource("src/main/resources/images/boats/download.jpg",4);
        Application.boats[5] = new imageSource("src/main/resources/images/boats/images.jpg",5);
        Application.boats[6] = new imageSource("src/main/resources/images/boats/empty-ferry-wharf-dock-circular-1990735.jpg",6);
        Application.boats[7] = new imageSource("src/main/resources/images/boats/boat.jpg",7);
        scores = Application.getScores("boatkey.txt");
        for(int i = 0;i<8;i++) {
            Application.boats[i].setStrength(scores[i]);
        }
        for(int i =0;i<4;i++){
            System.out.println(String.format("Displaying %d %d",Application.boats[Application.selInts[i]].getStrength(),Application.boats[Application.selInts[i]].index));
        }
        try {
            imgSet();
        } catch (FileNotFoundException e) {}
    }
}
