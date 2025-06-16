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
public class MenuDelete {

    public static void delete() {

        boolean running = true;

        while (running) {

            for (BankAccount accountNum : BankAccount.getUserAccount()) {
                System.out.println("Account n: " + accountNum.getAccountNumber() + " - Name: " + accountNum.getAccountHolderName());
            }

            System.out.printf("which account would you like to delete? ");

            
            //I need to include the option inside a new object and exclude it by the new object
            try {
                int accountOption = scanner.nextInt();
                scanner.nextLine(); //clean the buffer
                BankAccount toDelete = null;
                for(BankAccount deleteAccount : BankAccount.getUserAccount()){
                    if(deleteAccount.getAccountNumber() == accountOption){
                        toDelete = deleteAccount; 
                        break;
                    }
                }
                if(toDelete == null){
                    System.out.println("This account wasnt found, try again!");
                } else{
                    BankAccount.getUserAccount().remove(toDelete);
                    System.out.println("Your account was deleted sucessfully!");
                    running = false;
                }
            } catch (Exception e) {

            }

        }

    }

}
