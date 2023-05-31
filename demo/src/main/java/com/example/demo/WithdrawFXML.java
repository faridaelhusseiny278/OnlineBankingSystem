package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class WithdrawFXML {

    @FXML
    private Button returnButton;

    @FXML
    private Label warning;

    @FXML
    private TextField Amount, accountSN;

    @FXML
    private void withdrawFunction() throws IOException
    {




        if(Amount.getText()!="" && accountSN.getText()!="") {
            double amountWithdraw = Double.parseDouble(Amount.getText());
            int sn = Integer.parseInt(accountSN.getText());


            Account account = Account.validation(sn);

            Random randomNum = new Random();
            int showMe = randomNum.nextInt(1000);
            String randomnumber = String.valueOf(showMe);

            Transaction transaction = new Transaction(randomnumber, new Date(), amountWithdraw, "Withdraw", null, null);

            if (account != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Transaction details");
                alert.setHeaderText(null);
                alert.setContentText(transaction.withdraw(amountWithdraw, account));
                alert.showAndWait();

            } else {
                warning.setText("Account not available");
            }

        } else {
        warning.setText("Please enter valid data");
    }
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
