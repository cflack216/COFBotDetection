package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class account implements Initializable {

    @FXML
    private Button logout;
    @FXML
    public Label welcome;
    @FXML
    public Text info;
    public void logOut(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("signIn.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcome.setText("Welcome " + Application.curAccount.getUsername() + "!");
        info.setText(Application.curAccount.toString());
    }
}
