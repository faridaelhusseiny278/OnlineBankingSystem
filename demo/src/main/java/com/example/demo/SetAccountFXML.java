package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.Account.accountsList;

public class SetAccountFXML {

    @FXML
    private Label warning;

    @FXML
    private TextField username, securitynumber, balance;
@FXML
private Button returnButton,transactionsButton;



    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("MainUserScreen_FXML.fxml"));
        stage.setTitle("Main User Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();

    }

    @FXML
    private void createAccount() throws IOException
    {

        if(username.getText()!= "" && securitynumber.getText() != "" && balance.getText() != "null") {
            boolean flag = false;
            for (Account account : accountsList) {
                if (account.getSecurityNumber() == Integer.parseInt(securitynumber.getText())) {
                    flag = true;

                    warning.setText("Account already exist.");
                }
            }
            if (!flag) {
                Account account = new Account(username.getText().toString(), Integer.parseInt(securitynumber.getText()), Double.parseDouble(balance.getText()));
                accountsList.add(account);
                warning.setText("Account registered successfully.");
                account.addBill("WATER BILL", 1000);
                account.addBill("ELECTRICITY BILL", 500);
                Transaction.items.add(new Items("Pen", "IT1", 100, 10));
                Transaction.items.add(new Items("Checkbook", "IT2", 1000, 15));
            }
        }
        else {
            warning.setText("Please enter valid data");
        }
    }

    @FXML
    public void transactions() throws IOException {
        Stage stage = (Stage) transactionsButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Transctions_FXML.fxml"));
        stage.setTitle("Transactions Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }


}
