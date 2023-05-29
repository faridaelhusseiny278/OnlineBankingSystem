package com.example.demo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUserScreen {
@FXML

private Button logoutbutton, editDataButton;

    @FXML
    public void editData() throws IOException {
        Stage stage = (Stage) editDataButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("editData_FXML.fxml"));
        stage.setTitle("Poster HomeScreen");
        stage.setScene(new Scene(root));
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }
    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) logoutbutton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Hello-view.fxml"));
        stage.setTitle("Poster HomeScreen");
        stage.setScene(new Scene(root));
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }



}
