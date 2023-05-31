package com.Banking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class Transaction {

    private String sender;
    private String recipient;
    private String transactionID;
    private Date date;
    private double amount;

    private String transactionType;

    // Constructor
    public Transaction(String transactionID, Date date, double amount, String transactionType, String sender, String recipient) {
        this.transactionID = transactionID;
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
        this.sender= sender;
        this.recipient= recipient;

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
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTimestamp = currentTime.format(formatter);
    // Function to retrieve transaction details
    public String deposit(double amount, Account account) {
        if (amount > 0) {
            double currentBalance = account.getBalance();
            double newBalance = currentBalance + amount;
            account.setBalance(newBalance);
            return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                    "\nTransaction Type: deposit" );
        }
        else {
            return("invalid amount for Deposit");

        }
    }
//TO DO : make functions return strings instead of printing
    public String withdraw(double amount, Account account) {
        double currentBalance = account.getBalance();
        if (amount <= 0) {
            return("invalid amount for Withdraw");
        }else if (amount <= currentBalance) {
            double newBalance = currentBalance - amount;
            account.setBalance(newBalance);
           return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                   "\nTransaction Type: withdraw");
        }
        else
        {  return("insufficient balance");
        }
    }

    //Function to transfer money between accounts
    public String transfer(double amount, Account sender, Account recipient) {
        double SenderCurrentBalance = sender.getBalance();
        if (amount <=0){
           return("invalid amount for Transfer");
        }
        else if (amount <= SenderCurrentBalance) {
            double newBalance = SenderCurrentBalance - amount;
            sender.setBalance(newBalance);
            recipient.setBalance(recipient.getBalance() + amount);
            return("Transaction ID: " + transactionID + "\nTimestamp: " + formattedTimestamp + "\nAmount: " + amount +
                    "\nTransaction Type: transfer" + "\nSender: " + sender.getAccountHolderName() + "\nRecipient: " + recipient.getAccountHolderName());
        } else {
            return("insufficient balance for transfer");
        }
    }

}
