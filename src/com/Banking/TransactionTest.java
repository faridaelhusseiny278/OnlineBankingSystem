package com.Banking;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TransactionTest {


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    @Test
    public void testGetTransactionID() {
        String transactionID = "T123";
        Date date = new Date();
        double amount = 100.0;
        String description = "Payment";
        String transactionType = "Credit";
        String sender = "null";
        String recipient = "null";
        Transaction Transaction1 = new Transaction("T123", date, amount, description, transactionType, sender, recipient);
        String actualTransactionID = Transaction1.getTransactionID();

        Assert.assertEquals(transactionID, actualTransactionID);
    }

    @Test
    public void testGetDate() {
        // Create a Date object for the expected date
        Date expectedDate = new Date();

        String transactionID = "T123";
        double amount = 100.0;
        String description = "Payment";
        String transactionType = "Credit";
        String sender = "null";
        String recipient = "null";
        Transaction transaction = new Transaction(transactionID, expectedDate, amount, description, transactionType, sender, recipient);

        Date actualDate = transaction.getDate();

        Assert.assertEquals(expectedDate, actualDate);
    }

    @Test
    public void testGetAmount() {
        double amount = 100.0;
        Date date = new Date();
        String description = "Payment";
        String transactionType = "Credit";
        String sender = "null";
        String recipient = "null";

        Transaction transaction = new Transaction("T123", date, amount, description, transactionType, sender, recipient);

        double actualAmount = transaction.getAmount();

        Assert.assertEquals(amount, actualAmount, 0.001); // Specify delta for double comparison
    }


    //Test getTransactionDetails
    @Test
    public void testGetTransactionDetails() {
        String transactionID = "T123";
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = currentTime.format(formatter);
        double amount = 100.0;
        String description = "Payment";
        String transactionType = "Credit";
        String sender = "null";
        Date date = new Date();
        String recipient = "null";
        Transaction Transaction1 = new Transaction("T123", date, amount, description, transactionType, sender, recipient);
        String actualTransactionDetails = Transaction1.getTransactionDetails();

        Assert.assertEquals("Transaction ID: T123\nTimestamp: " + formattedTimestamp + "\nAmount: 100.0\nTransaction Type: Credit", actualTransactionDetails);
    }

    //Test getTransferDetails
    @Test
    public void testGetTransferDetails() {
        String transactionID = "T123";
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = currentTime.format(formatter);
        Date date = new Date();
        double amount = 100.0;
        String description = "Payment";
        String transactionType = "Credit";
        String sender = "Ahmed";
        String recipient = "Ali";
        Transaction Transaction1 = new Transaction("T123", date, amount, description, transactionType, sender, recipient);
        String actualTransferDetails = Transaction1.getTransferDetails();

        Assert.assertEquals("Sender: Ahmed\nRecipient: Ali\nAmount: 100.0\ncom.Banking.Transaction Type: Credit\nTimestamp: " + formattedTimestamp, actualTransferDetails);
    }






}