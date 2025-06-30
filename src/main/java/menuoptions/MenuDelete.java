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
public class MenuDelete {

    public static void delete() {

        boolean running = true;
        // Loop until a valid account is deleted or operation is canceled
        while (running) {
            //for to track all accounts and print it to the user.
            for (BankAccount accountNum : BankAccount.getUserAccount()) {
                System.out.println("Account n: " + accountNum.getAccountNumber() + " - Name: " + accountNum.getAccountHolderName());
            }

            try {
                System.out.printf("which account would you like to delete? [0] Press zero to cancel: ");
                int accountOption = scanner.nextInt();
                scanner.nextLine(); //clean the buffer

                /*checking if the user wants to cancel the deposit without going
                all trhought the code. (they might typed it wrong)*/
                if (accountOption == 0) {
                    System.out.println("Delete cancelled.");
                    return;
                }

                BankAccount selectedAccount = null; //new object to store the account
                for (BankAccount deleteAccount : BankAccount.getUserAccount()) {
                    //if account is found I set it to the new object toDelete.
                    if (deleteAccount.getAccountNumber() == accountOption) {
                        selectedAccount = deleteAccount;
                        break;
                    }
                }
                //if the account hasnt been found, first if is validated.
                if (selectedAccount == null) {
                    System.out.println("This account wasn't found.");
                    continue;
                } else {
                    //if account exist, I will check if there is balance, if no balance, I can delete.
                    if (selectedAccount.getBalance() == 0) {
                        BankAccount.getUserAccount().remove(selectedAccount);
                        System.out.println("Your account has been deleted successfully.");
                        running = false;
                    } else { //otherwise, the user need to withdraw all balance first.
                        System.out.println("You need to withdraw all your balance!");
                        return;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid option.");
            }

        }

    }

}
