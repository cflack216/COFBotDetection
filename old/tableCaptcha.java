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

public class tableCaptcha implements Initializable {
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
            InputStream stream = new FileInputStream(Application.tables[Application.selInts[0]].getPath());
            Image image = new Image(stream);
            img1.setImage(image);
            stream = new FileInputStream(Application.tables[Application.selInts[1]].getPath());
            image = new Image(stream);
            img2.setImage(image);
            stream = new FileInputStream(Application.tables[Application.selInts[2]].getPath());
            image = new Image(stream);
            img3.setImage(image);
            stream = new FileInputStream(Application.tables[Application.selInts[3]].getPath());
            image = new Image(stream);
            img4.setImage(image);
            stream.close();
            image.cancel();
        } catch(Exception e) {System.exit(1);}
    }
    public void imgProperties1() {
        if(Application.tables[Application.selInts[0]].getStatus()) {
            img1.setOpacity(1.0);
            Application.tables[Application.selInts[0]].select();
        } else {
            img1.setOpacity(.5);
            Application.tables[Application.selInts[0]].select();
        }
    }
    public void imgProperties2() {
        if(Application.tables[Application.selInts[1]].getStatus()) {
            img2.setOpacity(1.0);
            Application.tables[Application.selInts[1]].select();
        } else {
            img2.setOpacity(.5);
            Application.tables[Application.selInts[1]].select();
        }
    }
    public void imgProperties3() {
        if(Application.tables[Application.selInts[2]].getStatus()) {
            img3.setOpacity(1.0);
            Application.tables[Application.selInts[2]].select();
        } else {
            img3.setOpacity(.5);
            Application.tables[Application.selInts[2]].select();
        }
    }
    public void imgProperties4() {
        if(Application.tables[Application.selInts[3]].getStatus()) {
            img4.setOpacity(1.0);
            Application.tables[Application.selInts[3]].select();
        } else {
            img4.setOpacity(.5);
            Application.tables[Application.selInts[3]].select();
        }
    }
    public void reCalculate() throws IOException {
        Application.Calculate("tablekey.txt",Application.tables,"account.fxml");
    }
    public void reCalibrate() throws IOException{
        Application.calibrate("tablekey.txt",Application.tables);
        Application m = new Application();
        m.changeScene("account.fxml");
        System.out.println("Thank you for your Help!!");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Application.tables[0] = new imageSource("src/main/resources/images/tables/R.jpg",0);
        Application.tables[1] = new imageSource("src/main/resources/images/tables/A-full-view-of-a-home-office-with-toys-on-the-desk.png",1);
        Application.tables[2] = new imageSource("src/main/resources/images/tables/unknown (1).jpeg",2);
        Application.tables[3] = new imageSource("src/main/resources/images/tables/91c86ea3244d742583d0bed593a91ad0--kitchen-units-kitchen-ideas.jpg",3);
        Application.tables[4] = new imageSource("src/main/resources/images/tables/sdlakd.jpeg",4);
        Application.tables[5] = new imageSource("src/main/resources/images/tables/OIP.jpg",5);
        Application.tables[6] = new imageSource("src/main/resources/images/tables/g3enera.jpg",6);
        Application.tables[7] = new imageSource("src/main/resources/images/tables/BedRoom.JPG",7);
        scores = Application.getScores("tablekey.txt");
        for(int i = 0;i<8;i++) {
            Application.tables[i].setStrength(scores[i]);
        }
        for(int i =0;i<4;i++){
            System.out.println(String.format("Displaying %d %d",Application.tables[Application.selInts[i]].getStrength(),Application.tables[Application.selInts[i]].index));
        }
        //System.out.println(Application.tables);
        try {
            imgSet();
        } catch (FileNotFoundException e) {}
    }
}
