package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class LoginFXML {




    @FXML
    private Button Loginbutton, returnButton;

    @FXML
    private Label warning;

    @FXML
    private TextField  Email;

    @FXML
            private PasswordField Password;


    @FXML
    private void loginFunction() throws IOException
    {
        if(Email.getText()!="" && Password.getText()!="") {
            if (User.login(Email.getText().toString(), Password.getText().toString())) {
                warning.setVisible(true);
                warning.setText("Login is successful");
                lol();
            } else {
                warning.setText("unsuccessful login, Invalid email or password");
            }
        }
        else {
            warning.setText("Please enter valid data");
        }
    }
    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Hello-view.fxml"));
        stage.setTitle("Home Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }
    @FXML
    public void lol() throws IOException {
        Stage stage = (Stage) Loginbutton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainUserScreen_FXML.fxml"));
        stage.setTitle("Main user Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }
}
