/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuoptions;

import com.mycompany.banksystem.BankAccount;
import static com.mycompany.banksystem.BankSystem.scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Ruggery
 */
public class MenuTransfer {

    public static void transfer() {

        boolean running = true;

        while (running) {
            //for to track all accounts and print it to the user.
            for (BankAccount accountNum : BankAccount.getUserAccount()) {
                System.out.println(accountNum.accountData());
            }

            try {
                //creating two new objects to store and compare the accounts that exist.
                BankAccount newAccountTaken = null;
                BankAccount newAccountTransfer = null;

                //asking the user which accout he would like to take the money from.
                System.out.printf("Which account would you like to take money from? [0] Press zero to cancel: ");
                int accountTaken = scanner.nextInt();
                scanner.nextLine(); //clean buffer

                //checking if the account exist and storing it in the new object.
                for (BankAccount transferAccount : BankAccount.getUserAccount()) {
                    if (transferAccount.getAccountNumber() == accountTaken) {
                        newAccountTaken = transferAccount;
                    }
                }

                //if account doesnt exist, print the message and return to the beggining of the loop.
                if (newAccountTaken == null) {
                    System.out.println("Account taken has not been found! Try it again.");
                    continue; //this means that when you have a loop, it will stop here and comeback to the first thing inside the loop (while)
                }
                
                if (accountTaken == 0) {
                    System.out.println("Transfer cancelled."); //cancel and close the code if user wants to cancel.
                    return; //close the code
                }

                //asking the user which accout he would like to transfer the money to.
                System.out.printf("Which account would you like to transfer? [0] Press zero to cancel: ");
                int accountTransfer = scanner.nextInt();
                scanner.nextLine(); //clean buffer

                //checking if the account exist and storing it in the new object.
                for (BankAccount transferAccount : BankAccount.getUserAccount()) {
                    if (transferAccount.getAccountNumber() == accountTransfer) {
                        newAccountTransfer = transferAccount;
                    }
                }

                //if account doesnt exist, print the message and return to the beggining of the loop.
                if (newAccountTransfer == null) {
                    System.out.println("Account transfer has not been found! Try it again.");
                    continue; //this means that when you have a loop, it will stop here and comeback to the first thing inside the loop (while)
                }
                
                if (accountTransfer == 0) {
                    System.out.println("Transfer cancelled."); //cancel and close the code if user wants to cancel.
                    return;
                }

                //if user enter same account for both input it will give this error message and start the loop again
                if (newAccountTransfer == newAccountTaken) {
                    System.out.println("You can not transfer from the same account! Try it again.");
                    continue;
                }

                int loopValue = -1;
                while (loopValue < 0) {

                    System.out.printf("How much would you like to transfer? ");
                    double transferValue = scanner.nextDouble();
                    scanner.nextLine(); //clean buffer

                    //if user enter a negative number or zero, it will print the error and start the loop again.
                    if (transferValue <= 0) {
                        System.out.println("You can't enter a negative number or zero. Try again!");
                        continue;
                    }

                    //if the transfer value is less than the balance, it will cancel the transaction.
                    if (newAccountTaken.getBalance() < transferValue) {
                        System.out.println("You don't have enough funds to complete the transaction.");
                        return;
                    } else { //if not it will take out the money and give to the new account.
                        double newBalanceTaken = newAccountTaken.getBalance() - transferValue;  //store the new balance
                        newAccountTaken.setBalance(newBalanceTaken); //set the new balance to the taken account.
                        double newBalanceTransfer = newAccountTransfer.getBalance() + transferValue;  //store the new balance
                        newAccountTransfer.setBalance(newBalanceTransfer);  //set the new balance to the transfer account.
                        System.out.println("Your transfer has been done sucessfully!");
                        running = false; //close the first loop
                        loopValue = 0; //close the money loop
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number!");
                scanner.nextLine();
            }

        }

    }
}
