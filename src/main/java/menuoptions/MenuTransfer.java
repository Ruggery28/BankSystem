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
public class MenuTransfer {

    public static void transfer() {

        boolean running = true;

        while (running) {
            for (BankAccount accountNum : BankAccount.getUserAccount()) {
                System.out.println(accountNum.accountData());
            }

            System.out.printf("Which account would you like to take money from? ");
            try {
                int accountTaken = scanner.nextInt();
                scanner.nextLine(); //clean buffer

                System.out.printf("Which account would you like to transfer? ");
                int accountTransfer = scanner.nextInt();
                scanner.nextLine(); //clean buffer

                System.out.printf("How much would you like to transfer? ");
                double value = scanner.nextDouble();
                scanner.nextLine(); //clean buffer

                BankAccount newAccountTaken = null;
                BankAccount newAccountTransfer = null;

                for (BankAccount transferAccount : BankAccount.getUserAccount()) {
                    if (transferAccount.getAccountNumber() == accountTaken) {
                        newAccountTaken = transferAccount;
                    }
                    if (transferAccount.getAccountNumber() == accountTransfer) {
                        newAccountTransfer = transferAccount;
                    }
                }
                if (newAccountTaken == null) {
                    System.out.println("Account taken has not been found! Try it again.");
                } else if (newAccountTransfer == null) {
                    System.out.println("Account transfer has not been found! Try it again.");
                } else {
                    if (newAccountTaken.getBalance() < value) {
                        System.out.println("You don't have enough funds to complete the transaction.");
                        break;
                    } else {
                        double newBalanceTaken;
                        newBalanceTaken = newAccountTaken.getBalance() - value;
                        newAccountTaken.setBalance(newBalanceTaken);
                        double newBalanceTransfer;
                        newBalanceTransfer = newAccountTransfer.getBalance() + value;
                        newAccountTransfer.setBalance(newBalanceTransfer);
                        System.out.println("Your transfer was done sucessfully!");
                        running = false;
                    }
                }

            } catch (Exception e) {
                System.out.println("Enter a valid number!");
            }

        }

    }
}
