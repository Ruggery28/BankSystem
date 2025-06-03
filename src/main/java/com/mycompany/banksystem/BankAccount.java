/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banksystem;

import static com.mycompany.banksystem.BankSystem.scanner;
import java.util.ArrayList;

/**
 *
 * @author Ruggery
 */
public class BankAccount {

    private static int nextAccountNumber = 1;
    private static ArrayList<BankAccount> userAccount = new ArrayList<>();

    private int AccountNumber;
    private String AccountHolderName;
    private double balance;


    public BankAccount(String AccountHolderName) {
        this.AccountHolderName = AccountHolderName;
        this.balance = 0.0;
        //auto-generator number
        this.AccountNumber = nextAccountNumber++;
        userAccount.add(this);
    }

    public static ArrayList<BankAccount> getUserAccount() {
        return userAccount;
    }

    public static void setUserAccount(ArrayList<BankAccount> userAccount) {
        BankAccount.userAccount = userAccount;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(String AccountHolderName) {
        this.AccountHolderName = AccountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String accountData() {
        return "Account Number: " + AccountNumber + " - Account Name: " + AccountHolderName + " Balance: €" + balance;
    }



}
