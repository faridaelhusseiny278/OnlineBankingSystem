package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class PayBills {


    @FXML
    private Button returnButton, payButton;

    @FXML
    private TextField accountSN, billsID;

    @FXML
    private Label warning;

    @FXML
    public void payBills() throws IOException {
        if(accountSN.getText()!="" && billsID.getText()!="") {
            int id = Integer.parseInt(accountSN.getText());
            String bills = billsID.getText().toString().toUpperCase();
            Account account = Account.validation(id);

            if (account!=null) {
                warning.setText(account.payBill(bills));
            }
            else {
                warning.setText("Account doesn't exist");
            }
        }
        else {
            warning.setText("Please enter valid data");
        }

    }


    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("ShowBillsFXML.fxml"));
        stage.setTitle("Show Bills Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }
}
