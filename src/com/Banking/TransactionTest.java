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
    Account account = new Account(1000, "A125", "saving", "Ahmed");

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
@Test
    public void testDepositSufficientBalance() {
        String Deposit;
        Deposit= Transaction1.deposit(amount, account);
        double actualBalance = account.getBalance();
        Assert.assertEquals(1100.0, actualBalance, 0.001);
        Assert.assertEquals(Deposit , amount + " deposited successfully.");
    }
    @Test
    public void testDepositNegative() {
       String Deposit= Transaction1.deposit(-amount, account);
        Assert.assertEquals(Deposit, "Invalid amount.");
    }
    @Test
    public void TestDepositZero(){
        String Deposit= Transaction1.deposit(0, account);
        Assert.assertEquals(Deposit, "Invalid amount.");
    }

    @Test
    public void TestWithdrawSufficient(){
        String Withdraw= Transaction1.withdraw(amount, account);
        double actualBalance = account.getBalance();
        Assert.assertEquals(900.0, actualBalance, 0.001);
        Assert.assertEquals(Withdraw, amount + " withdrawn successfully.");
    }

    @Test
    public void TestWithdrawNegative(){
        String Withdraw= Transaction1.withdraw(-amount, account);
        Assert.assertEquals(Withdraw, "Invalid amount.");
    }

    @Test
    public void TestWithdrawZero(){
        String Withdraw= Transaction1.withdraw(0, account);
        Assert.assertEquals(Withdraw, "Invalid amount.");
    }

    @Test
    public void TestWithdrawInsufficient(){
        String Withdraw= Transaction1.withdraw(2000, account);
        Assert.assertEquals(Withdraw, "Insufficient balance.");
    }
    @Test
    public void TestTransfer(){
        Account account1 = new Account(2000, "B126", "saving", "omar");
        Account account2 = new Account(1000, "A123", "saving", "Aly");
        String Transfer= Transaction1.transfer(amount, account1, account2);
        double actualBalance = account1.getBalance();
        double actualBalance2 = account2.getBalance();
        Assert.assertEquals(1900.0, actualBalance, 0.001);
        Assert.assertEquals(1100.0, actualBalance2, 0.001);
        Assert.assertEquals(Transfer, amount + " transferred successfully.");
    }
    @Test
    public void TestTransferNegative(){
        Account account1 = new Account(2000, "B126", "saving", "omar");
        Account account2 = new Account(1000, "A123", "saving", "Aly");
        String Transfer = Transaction1.transfer(-amount, account1, account2);
        double actualBalance = account1.getBalance();
        double actualBalance2 = account2.getBalance();
        Assert.assertEquals(Transfer, "Invalid amount.");
        Assert.assertEquals(2000.0, actualBalance, 0.001);
        Assert.assertEquals(1000.0, actualBalance2, 0.001);
    }
    @Test
    public void TestTransferZero(){
        Account account1 = new Account(2000, "B126", "saving", "omar");
        Account account2 = new Account(1000, "A123", "saving", "Aly");
        String Transfer = Transaction1.transfer(0, account1, account2);
        double actualBalance = account1.getBalance();
        double actualBalance2 = account2.getBalance();
        Assert.assertEquals(Transfer, "Invalid amount.");
        Assert.assertEquals(2000.0, actualBalance, 0.001);
        Assert.assertEquals(1000.0, actualBalance2, 0.001);

    }

    @Test
    public void TestTransferInsufficientBalance(){
        Account account1 = new Account(2000, "B126", "saving", "omar");
        Account account2 = new Account(1000, "A123", "saving", "Aly");
        String Transfer = Transaction1.transfer(3000, account1, account2);
        double actualBalance = account1.getBalance();
        double actualBalance2 = account2.getBalance();
        Assert.assertEquals(Transfer, "Insufficient balance.");
        Assert.assertEquals(2000.0, actualBalance, 0.001);
        Assert.assertEquals(1000.0, actualBalance2, 0.001);
    }


    //TO DO:  TestTransferDetails and TestTransactionDetails according to the Transaction Type



}