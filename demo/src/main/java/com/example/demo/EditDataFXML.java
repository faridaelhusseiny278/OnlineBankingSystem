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

public class EditDataFXML {


    @FXML
    private Button button, returnButton;

    @FXML
    private Label warning;

    @FXML
    private TextField Email,OldMailTextBox;

    @FXML
    private PasswordField Password, OldPasswordTextBox;



    private void userRegister() throws IOException {
        checkLogin();
    }


    @FXML
    private void checkLogin() throws IOException


    {

        HelloApplication h = new HelloApplication();
        if(User.updateProfile(OldMailTextBox.getText().toString(),OldPasswordTextBox.getText().toString(), Email.getText().toString(),Password.getText().toString()))
        {

            warning.setText("User updated successfully");
        }
        else
        {
            warning.setText("incorrect data, user didn't update");

        }

    }
    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainUserScreen_FXML.fxml"));
        stage.setTitle("Poster HomeScreen");
        stage.setScene(new Scene(root));
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }

}
