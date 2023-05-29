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

public class Register {

    @FXML
    private Button button, returnButton;

    @FXML
    private Label warning;

    @FXML
    private TextField username, Email;

    @FXML
            private PasswordField Password;

    ArrayList<User> userList = new ArrayList<>();


    private void userRegister() throws IOException {
        checkLogin();
    }


    @FXML
    private void checkLogin() throws IOException


    {

        HelloApplication h = new HelloApplication();
        User.register(username.getText().toString(),Email.getText().toString(),Password.getText().toString(),1500);
        warning.setText("User registered successfully");


    }

    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Hello-view.fxml"));
        stage.setTitle("Poster HomeScreen");
        stage.setScene(new Scene(root));
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }



}
