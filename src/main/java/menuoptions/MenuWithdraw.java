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
public class MenuWithdraw {

    public static void withdraw() {

        boolean running = true;

        //while running is true I'll keep asking for an account to withdraw, getting all I want I change it to false.
        while (running) {
            //for to track all accounts and print it to the user.
            for (BankAccount accountNum : BankAccount.getUserAccount()) {
                System.out.println(accountNum.accountData());
            }

            try {
                System.out.printf("Which account would you like to withdraw? [0] Press zero to cancel:");
                int checkAccount = scanner.nextInt();
                scanner.nextLine();

                /*checking if the user wants to cancel the deposit without going
                all trhought the code. (they might typed it wrong)*/
                if (checkAccount == 0) {
                    System.out.println("Withdraw cancelled.");
                    return;
                }

                BankAccount matchAccount = null; //new obeject 
                //Going through all the accounts that exist and comparing with the array.
                for (BankAccount withdrawAccount : BankAccount.getUserAccount()) {
                    //If account match, I will set it to the new object to save it.
                    if (withdrawAccount.getAccountNumber() == checkAccount) {
                        matchAccount = withdrawAccount;
                        break;
                    }
                }
                //if the user entered an exist account, machAccount wont be null and it will pass to this IF.
                if (matchAccount != null) {
                    boolean withdraw = true; //loop boolean
                    while (withdraw) {
                        System.out.printf("How much would you like to withdraw? [0] Press zero to cancel: ");
                        double withdrawValue = scanner.nextDouble(); //storing the value
                        scanner.nextLine(); //clean buffer
                        /*If user value is 0, cancel all operation.
                        If user value is negative, loop will ask to do it again
                        If user value is a positive number and there is balance,it will withdraw and close the loop.*/
                        if (withdrawValue == 0) {
                            System.out.println("Withdraw cancelled.");
                            return;
                        } else if (withdrawValue < 0) {
                            System.out.println("Deposit amount must be greater than zero.");
                        } else {
                            if (matchAccount.getBalance() < withdrawValue) {
                                System.out.println("You do not have enough balance. Try it again!");
                            } else {
                                double newBalance = matchAccount.getBalance() - withdrawValue; //subtracting the value of the account
                                matchAccount.setBalance(newBalance); //setting new balance
                                System.out.println("Withdraw was made sucessfully! New Balance: $" + matchAccount.getBalance());
                                withdraw = false;
                                running = false;
                            }
                        }
                    }
                } else {
                    System.out.println("Account doesn't exist! Try again.");
                }

            } catch (Exception e) {
                System.out.println("Enter a valid number.");
            }

        }

    }

}


/*
1- when user select the account{
FIRST - need to check if account exist;
SECOND - need to check if account balance is greater than zero.}
1.2- if user select an account that doesnt exist, will give a message error and ask again
1.3- if user select an exist account but has no money, will give a message error and ask again

2-when user select the amount{
FIRST - need to check if the amount is greater than zero, if not ask to enter a valid number;
SECOND - need to check if the account has balance to withdraw, if not give a message and close the code
1.2 - if 0 close the withdraw, if negative number give the message to enter a valid and greater than 0 is ok.
 */
