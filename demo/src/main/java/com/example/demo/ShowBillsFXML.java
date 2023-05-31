package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowBillsFXML {

@FXML
private Button returnButton, payBillsButton;
@FXML
private TextField accountId;
@FXML
private Text billsId, amountBills, payBills;

@FXML
private Label warning;

    @FXML
public void showBills()
{

    if(accountId.getText()!="") {
        int id = Integer.parseInt(accountId.getText());
        Account account = Account.validation(id);
        if(account!=null) {
            billsId.setText(account.getBillsId());
            amountBills.setText(account.getBillsAmount());
        }
        else {
            warning.setText("Account not available");
        }
    }
    else {
        warning.setText("Please enter a valid account SN");
    }

}

    @FXML
    public void payBills() throws IOException {
        Stage stage = (Stage) payBillsButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("PayBillsFXML.fxml"));
        stage.setTitle("Pay Bills Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }

    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Transctions_FXML.fxml"));
        stage.setTitle("Transactions Screen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }
}
