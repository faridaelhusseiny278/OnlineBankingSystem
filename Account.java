package com.example.demo;

import java.util.ArrayList;

public class Account
{
   private String Name;
    private int SecurityNumber;
    private double balance;

    static ArrayList<Bill_Payment> bills = new ArrayList<>();

    static ArrayList<Account> accountsList = new ArrayList<>();

    public Account(String Name)
    {
        this.Name = Name;
    }
    public Account(String Name, int SecurityNumber)
    {
        this.Name = Name;
        this.SecurityNumber = SecurityNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String Name, int SecurityNumber, double amount)
    {
        this(Name, SecurityNumber);
        this.balance = amount;
        System.out.println("Account successfully created");
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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


    public void addBill(String type,double amount){
        if(findBill(type)==-1) {
            bills.add(new Bill_Payment(type, amount, this));
        }
    }

    public void buyItem(Items x){
        double itemPrice=x.getPrice();
        if(balance>itemPrice){
            balance-=itemPrice;
            System.out.println("item bought");
            x.buy();
        }
        else{
            System.out.println("Item not bought");
        }
    }

    public void payBill(String type){
        int index=findBill(type);
        if(index!=-1){
            boolean status=bills.get(index).payBill();
            if(status) {
                balance -= bills.get(index).amount;
                System.out.println("Bill paid successfully");
                bills.remove(index);
            }
        }

    }

    int findBill(String type){


            for (int i = 0; i < bills.size(); i++) {
                if (bills.get(i).getType().equals(type)) {
                    return i;
                }
            }
            return -1;

    }
    String getBillsId(){
        String out="";
        for(int i=0;i<bills.size();i++){
            out+=bills.get(i).getType();
            out+="\n";
        }
        return out;
    }

    String getBillsAmount(){
        String out="";
        for(int i=0;i<bills.size();i++){
            out+=Double.toString(bills.get(i).getAmount());
            out+="\n";
        }
        return out;
    }



}