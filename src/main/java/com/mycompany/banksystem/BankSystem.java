/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.banksystem;

import java.util.ArrayList;
import java.util.Scanner;
import menuoptions.MenuDeposit;
import menuoptions.MenuWithdraw;

/**
 *
 * @author Ruggery
 */
public class BankSystem {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //This will be the Scope of the program, a menu where everything will works on it. 
        boolean running = true;

        while (running) {
            System.out.println("===== Bank Menu =====");
            System.out.println("[1] - Create an account");
            System.out.println("[2] - View All Accounts");
            System.out.println("[3] - Deposit");
            System.out.println("[4] - Withdraw");
            System.out.println("[5] - Transfer");
            System.out.println("[6] - Delete account");
            System.out.println("[0] - Exit");

            System.out.printf("Enter your option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    running = false;
                    break;
                case "1":
                    System.out.printf("Enter your name: ");
                    String name = scanner.nextLine();
                    BankAccount account = new BankAccount(name);    
                    System.out.println("Welcome, " + account.getAccountHolderName());
                    account.accountData(); //need to delete it later
                    break;
                case "2":
                    for(BankAccount bankAccount : BankAccount.getUserAccount()){
                        System.out.println(bankAccount.accountData());
                    }    
                    break;
                case "3":
                    MenuDeposit.deposit();
                    break;
                case "4":
                    MenuWithdraw.withdraw();
                    break;
                case "5":
                    break;
                case "6":
                    break;
            }

        }
    }
}
