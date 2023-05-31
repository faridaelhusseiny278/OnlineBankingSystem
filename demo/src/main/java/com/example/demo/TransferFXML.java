package com.example.demo;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.lang.Math;
import java.util.Random;

public class TransferFXML {

    @FXML
    private Button returnButton, transferButton, transferdetails;

    @FXML
    private Label warning;

    @FXML
    private TextField Amount, senderAccount, recieverAccount;

    @FXML
    private void transferFunction() throws IOException {


        if(Amount.getText()!="" && senderAccount.getText()!= "" && recieverAccount.getText()!="") {
            double amountTransfer = Double.parseDouble(Amount.getText());
            int Sendersn = Integer.parseInt(senderAccount.getText());
            int Recieversn = Integer.parseInt(recieverAccount.getText());
            Account accountSender = Account.validation(Sendersn);
            Account accountReciever = Account.validation(Recieversn);
            Random randomNum = new Random();
            int showMe = randomNum.nextInt(1000);
            String randomnumber = String.valueOf(showMe);

            if (Sendersn == Recieversn) {
                warning.setText("Can't transfer to same account");
            } else {
                if (accountSender != null && accountReciever != null) {
                    Transaction transaction = new Transaction(randomnumber, new Date(), amountTransfer, "transfer", accountSender.getName(), accountReciever.getName());
                    warning.setText(transaction.transfer(amountTransfer, accountSender, accountReciever));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Transaction details");
                    alert.setHeaderText(null);
                    alert.setContentText(transaction.getTransferDetails());
                    alert.showAndWait();
                } else {
                    warning.setText("Account not available");
                }
            }

        }
        else {

            warning.setText("Please enter valid data");
        }
    }


    @FXML
    public void returnHome() throws IOException {
        Stage stage = (Stage) returnButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Transctions_FXML.fxml"));
        stage.setTitle("Poster HomeScreen");
        stage.setScene(new Scene(root));
        stage.setWidth(750);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }


}
