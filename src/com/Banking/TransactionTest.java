package com.Banking;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TransactionTest {
    String transactionID = "T123";
    Date date = new Date();
    double amount = 100.0;
    String transactionType = "Credit";
    String sender = "null";
    String recipient = "null";
    Transaction Transaction1 = new Transaction("T123", date, amount, transactionType, sender, recipient);
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTimestamp = currentTime.format(formatter);
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    @Test
    public void testGetTransactionID() {

        String actualTransactionID = Transaction1.getTransactionID();

        Assert.assertEquals(transactionID, actualTransactionID);
    }

    @Test
    public void testGetDate() {

        Date actualDate = Transaction1.getDate();

        Assert.assertEquals(date, actualDate);
    }

    @Test
    public void testGetAmount() {

        double actualAmount = Transaction1.getAmount();

        Assert.assertEquals(amount, actualAmount, 0.001);
    }


    //Test getTransactionDetails
    @Test
    public void testGetTransactionDetails() {


        String actualTransactionDetails = Transaction1.getTransactionDetails();

        Assert.assertEquals("Transaction ID: T123\nTimestamp: " + formattedTimestamp + "\nAmount: 100.0\nTransaction Type: Credit", actualTransactionDetails);
    }

    //Test getTransferDetails
    @Test
    public void testGetTransferDetails() {

        String sender = "Ahmed";
        String recipient = "Ali";
        Transaction transaction = new Transaction("T123", date, amount, transactionType, sender, recipient);
        String actualTransferDetails = transaction.getTransferDetails();

        Assert.assertEquals("Sender: Ahmed\nRecipient: Ali\nAmount: 100.0\ncom.Banking.Transaction Type: Credit\nTimestamp: " + formattedTimestamp, actualTransferDetails);
    }






}