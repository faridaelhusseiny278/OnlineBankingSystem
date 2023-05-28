package com.Banking;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.Banking.Account;
public class Transaction {

    private String sender;
    private String recipient;
    private String transactionID;
    private Date date;
    private double amount;
    private String description;
    private boolean isCancelled;
    private String transactionType;

    // Constructor
    public Transaction(String transactionID, Date date, double amount, String description, String transactionType) {
        this.transactionID = transactionID;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.isCancelled = false;
        this.transactionType = transactionType;

    }

    // Getters
    public String getTransactionID() {
        return transactionID;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // Function to retrieve transaction details
    public void getTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date);
        System.out.println("Amount: " + amount);
        System.out.println("Description: " + description);
        System.out.println("Transaction Type: " + transactionType);
    }
    public String getTransferDetails() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = currentTime.format(formatter);

        return "Sender: " + sender + "\nRecipient: " + recipient + "\nAmount: " + amount +
                "\ncom.Banking.Transaction Type: " + transactionType + "\nTimestamp: " + formattedTimestamp;
    }

    public void deposit(double amount, Account account){
        double currentBalance = account.getBalance();
        double newBalance = currentBalance + amount;
        account.setBalance(newBalance);
        System.out.println(amount + " deposited successfully.");
    }

    public void withdraw(double amount, Account account) {
        double currentBalance = account.getBalance();
        if (amount <= currentBalance) {
            double newBalance = currentBalance - amount;
            account.setBalance(newBalance);
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    //Function to transfer money between accounts
    public void transfer(double amount, Account sender, Account recipient) {
        double SenderCurrentBalance = sender.getBalance();
        if (amount <= SenderCurrentBalance) {
            double newBalance = SenderCurrentBalance - amount;
            sender.setBalance(newBalance);
            recipient.setBalance(recipient.getBalance() + amount);
            System.out.println(amount + " transferred successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

}
