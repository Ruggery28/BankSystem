/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuoptions;

import com.mycompany.banksystem.BankAccount;
import static com.mycompany.banksystem.BankSystem.scanner;

/**
 *
 * @author Ruggery
 */
public class MenuDeposit {

    public static void deposit() {

        /*creating a boolean working to start my code, I need a while to run the 
        code and keep asking until the deposit is made.*/
        boolean working = true;
        while (working) {

            //for to track all accounts and print it to the user.
            for (BankAccount accountNum : BankAccount.getUserAccount()) {
                System.out.println("Account n: [" + accountNum.getAccountNumber() + "] - Name: " + accountNum.getAccountHolderName());
            }

            System.out.printf("What account would you like to deposit? [0] Press zero to cancel: ");

            try {
                int checkAccount = scanner.nextInt();
                scanner.nextLine(); //clean buffer
                /*checking if the user wants to cancel the deposit without going
                all trhought the code. (they might typed it wrong)*/
                if (checkAccount == 0) {
                    System.out.println("Deposit cancelled!");
                    return; //it will cancel the rest of the code and close the while
                }

                BankAccount matchAccount = null; //new obeject 
                //for to track all accounts and compare with the number the user entered.
                for (BankAccount newAccount : BankAccount.getUserAccount()) {
                    if (newAccount.getAccountNumber() == checkAccount) {
                        matchAccount = newAccount; //if value match I will save the account inside the objected I created outside the for
                        break;
                    }
                }

                //if account has not been found, it will go to else and print that it doesnt exist.
                if (matchAccount != null) {
                    //however, if we found, I'll ask for the money value and then compare if it's more than 0
                    double money = 0;
                    while (money <= 0) {
                        System.out.printf("How much would you like to deposit? [0] Press zero to cancel: ");
                        money = scanner.nextDouble();
                        scanner.nextLine(); //clean buffer
                        /*If user value is 0, cancel all operation.
                        If user value is negative, loop will ask to do it again
                        If user value is a positive number greater than 0, will deposite and close the loop.*/
                        if (money == 0) {
                            System.out.println("Deposit cancelled!");
                            return; //it will cancel the rest of the code and close the while
                        } else if(money < 0) {
                            System.out.println("Deposit amount must be greater than zero.");
                        } else {
                            double newBalance = matchAccount.getBalance() + money; //get the previous balance and add with the money.
                            matchAccount.setBalance(newBalance); //set the new value inside the object
                            System.out.printf("Deposit was made sucessfully! New Balance: $%.2f%n", newBalance);
                            working = false; //close the while
                        }
                    }
                } else {
                    System.out.println("Account doesn't exist! Try again.");
                }

            } catch (Exception e) {
                System.out.println("Enter a valid number!");
            }

        }

    }
}
