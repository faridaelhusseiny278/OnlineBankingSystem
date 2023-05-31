package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class ItemsBuy {



    @FXML
    private Button returnButton, buyItemButton;

    @FXML
    private TextField obtainId, accountSn;
    @FXML
    private Text price, itemsId, itemsName, warning;


    @FXML
    public void showItems()
    {
        itemsName.setText(Transaction.getItemsName());
        itemsId.setText(Transaction.getItemsId());
        price.setText(Transaction.getItemsPrice());
    }

    @FXML
    public void buyItems() throws IOException {
        if(obtainId.getText()!="" && accountSn.getText()!="") {
            String itemId = obtainId.getText().toString().toUpperCase();
            int accountID = Integer.parseInt(accountSn.getText());
            Transaction transaction = new Transaction();
            warning.setText(transaction.buyItem(itemId, accountID));
        }
        else {
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
