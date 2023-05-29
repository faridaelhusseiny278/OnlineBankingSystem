package com.example.demo;

import java.util.ArrayList;

public class User {

private String name;
private String Email;
private String Password;

private int balance;

    static ArrayList<User> userList = new ArrayList<>();


    public User(String name, String email, String password, int balance) {
        this.name = name;
        this.Email = email;
        this.Password = password;
        this.balance = balance;
    }

    public static void register(String name, String email, String password, int balance) {
        User user = new User(name, email, password, balance);
        userList.add(user);
        System.out.println("User registered successfully.");
    }

    public static boolean login(String email, String password) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return true;
            }
        }
        System.out.println("Invalid email or password.");
        return false;
    }

    public static boolean updateProfile(String oldEmail, String oldPassword, String newEmail, String newPassword)
    {
       for (User user : userList) {
        if (login(oldEmail,oldPassword)) {
            user.setEmail(newEmail);
            user.setPassword(newPassword);
            System.out.println("Updated successfully.");

            return true;
        }
    }
        System.out.println("Invalid email or password.");
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public int getBalance() {
        return balance;
    }



}
