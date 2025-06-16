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

        while (running) {
            for (BankAccount accountNum : BankAccount.getUserAccount()) {
                System.out.println(accountNum.accountData());
            }

            try {
                System.out.printf("Which account would you like to withdraw?: ");
                int checkAccount = scanner.nextInt();
                scanner.nextLine();

                for (BankAccount withdrawAccount : BankAccount.getUserAccount()) {
                    if (withdrawAccount.getAccountNumber() == checkAccount) {
                        System.out.printf("How much would you like to withdraw?: ");
                        double withdrawValue = scanner.nextDouble();
                        scanner.nextLine(); //clean buffer
                        double newBalance = withdrawAccount.getBalance() - withdrawValue;
                        withdrawAccount.setBalance(newBalance);
                        System.out.println("Withdraw was made sucessfully! New Balance: €" + withdrawAccount.getBalance());
                    }
                }

            } catch (Exception e) {
                System.out.println("Enter a valid number.");
            }
            running = false;
        }

    }

    /*
    1 - show the users all accounts; ok 
    2 - give the user the option of the account; ok
    3- get the value the user wants to withdraw and subtract to the balance. ok
    4- check validations.
     */
}
