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

        boolean working = true;
        while (working) {

            for (BankAccount accountNum : BankAccount.getUserAccount()) {
                System.out.println("Account nº: " + accountNum.getAccountNumber() + " - Name: " + accountNum.getAccountHolderName());
            }

            System.out.printf("What account would you like to deposit: ");
            
                boolean accountFound = false;
            try {
                int checkAccount = scanner.nextInt();
                scanner.nextLine(); //clean buffer
                
                for (BankAccount newAccount : BankAccount.getUserAccount()) {
                    if(newAccount.getAccountNumber() == checkAccount){
                        System.out.printf("How much would you like to deposit: ");
                        double money = scanner.nextDouble();
                        scanner.nextLine(); //clean buffer
                        double newBalance = newAccount.getBalance() + money;
                        newAccount.setBalance(newBalance);
                        System.out.println("Deposit was made sucessfully! New Balance: €" + newBalance);
                        working = false;
                        accountFound = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Enter a valid number!");
            }
                    if (!accountFound) {
                    System.out.println("Account doesnt exist! try it again.");
                }

        }

        //ask user account number
        //check if the account exist
        //ask how much money he would like to deposit
        //print that was sucessfully and the balance
    }
    
}
