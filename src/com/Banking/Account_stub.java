package com.Banking;

public class Account {
private double balance;
private String accountNumber;
private String accountType;
private String accountHolderName;

// Constructor
public Account(double balance, String accountNumber, String accountType, String accountHolderName) {
    this.balance = balance;
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.accountHolderName = accountHolderName;
}
    //getters
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    //setters

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }



}
