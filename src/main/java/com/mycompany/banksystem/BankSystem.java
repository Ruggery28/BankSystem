/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.banksystem;

import java.util.ArrayList;
import java.util.Scanner;
import menuoptions.MenuDelete;
import menuoptions.MenuDeposit;
import menuoptions.MenuTransfer;
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
            System.out.println("----------------------------------------");

            switch (option) {
                case "0":
                    System.out.println("Thank you for using BankSystem. Goodbye!");
                    System.out.println("----------------------------------------");
                    running = false;
                    break;
                case "1":
                    System.out.printf("Enter your name: ");
                    String name = scanner.nextLine();
                    BankAccount account = new BankAccount(name);
                    System.out.println("Welcome, " + account.getAccountHolderName());
                    System.out.println("----------------------------------------");
                    break;
                case "2":
                    //initialise the method noAccount, if it's true it goes to break and close the case.
                    if (thereIsNoAccount()){
                        break;
                    }
                    //it goes inside the Array and it will print all accounts.
                    for (BankAccount bankAccount : BankAccount.getUserAccount()) {
                        System.out.println(bankAccount.accountData());
                    }
                    System.out.println("----------------------------------------");
                    break;
                case "3":
                    /*same method, but I displayed it different, when there is only one line 
                    inside the if I can write it after the ')' and then the CODE and ';'*/
                    if (thereIsNoAccount())break;
                    MenuDeposit.deposit();
                    System.out.println("----------------------------------------");
                    break;
                case "4":
                    if (thereIsNoAccount())break;
                    MenuWithdraw.withdraw();
                    System.out.println("----------------------------------------");
                    break;
                case "5":
                    if (thereIsNoAccount())break;
                    MenuTransfer.transfer();
                    System.out.println("----------------------------------------");
                    break;
                case "6":
                    if (thereIsNoAccount())break;
                    MenuDelete.delete();
                    System.out.println("----------------------------------------");
                    break;
                default:
                    System.out.println("Invalid option, try it again.");
                    System.out.println("----------------------------------------");
                    break;
            }

        }
    }

    /*private method cause I will only use here in this class and static because 
    I don't need to create any object is just a simple method*/
    private static boolean thereIsNoAccount() {
        if (BankAccount.getUserAccount().isEmpty()) {
            System.out.println("No account has been created.");
            System.out.println("----------------------------------------");
            return true; //if the Array is empty it will return true and close the method,
        }
        return false; //otherwise it will return false, so in the main I can continue the code.
    }
}
