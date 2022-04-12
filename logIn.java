package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

import java.io.IOException;

public class logIn {

    @FXML
    private Button signIn;
    @FXML
    private Button signUn;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private TextField signupPassword;
    @FXML
    private TextField signupUsername;

    public void userlogin(ActionEvent event) throws IOException {
        Application m = new Application();
        Application.selIndex = 0;
        Application.curAccount = Application.saves[0];
        m.changeScene("busCaptcha.fxml");
        /*
        for (int i=0;i<10;i++) {
            if(Application.saves[i]!=null) {
                if (username.getText().equals(Application.saves[i].getUsername()) && password.getText().equals(Application.saves[i].getPassword())) {
                    Application.selIndex = i;
                    Application.curAccount = Application.saves[i];
                    System.out.println("Successfully Logged In");
                    m.changeScene("busCaptcha.fxml");
                    return;
                }
            }
        }
        System.out.println("Login Failed");
         */
    }
    public void userSignUp(ActionEvent event) throws IOException {
        Application.saveAccount(new saveData(signupUsername.getText(),signupPassword.getText()));
    }
}