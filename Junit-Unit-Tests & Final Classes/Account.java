package com.Banking;



import java.util.ArrayList;

    public class Account
    {
        private int SecurityNumber;
        private double balance;
        private String accountNumber;
        private String accountType;
        private String accountHolderName;
        static ArrayList<Bill_Payment> bills = new ArrayList<>();

        static ArrayList<Account> accountsList = new ArrayList<>();

        public double getBalance()
        {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
        public ArrayList<Bill_Payment> getBills(){
            return bills;
        }

        public Account( double balance, String accountNumber, String accountType, String Name)
        {
            this.accountHolderName = Name;
            this.SecurityNumber = SecurityNumber;
            this.balance = balance;
            this.accountNumber = accountNumber;
            this.accountType = accountType;
            System.out.println("Account successfully created");
        }
        public String getAccountHolderName() {
            return accountHolderName;
        }

        public void setName(String name) {
            accountHolderName = name;
        }

        public int getSecurityNumber() {
            return SecurityNumber;
        }

        public void setSecurityNumber(int securityNumber) {
            SecurityNumber = securityNumber;
        }

        public static Account validation(int securityNumber)
        {

            for (Account account : accountsList) {
                if (account.SecurityNumber == securityNumber) {
                    return account;
                }
            }


            return null;
        }




    }