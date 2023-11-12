package Account;

import DatabaseManagemnet.AppController;
import DatabaseManagemnet.Database;

import java.util.Scanner;

public class AccountManagement {
    InstapayAccount sign_n(String UserName, String Password){
        Database database = Database.getDatabase();
        for(int i =0;i<database.getSavedAccounts().size();i++){
            if(UserName.equals(database.getSavedAccounts().get(i).getUserName())&& Password.equals(database.getSavedAccounts().get(i).getPassword())){
                System.out.println("You have Signed in successfully");
                database.getSavedAccounts().get(i).loadProfile();
                return database.getSavedAccounts().get(i);
            }
        }
        System.out.println("Invalid userName or password");
        return null;
    };

    public AccountManagement() {
    }

    InstapayAccount Sign_up(String MobileNumber){
        Database database = Database.getDatabase();
        AppController appController = new AppController(database);
        Scanner scanner = new Scanner(System.in);
        if(appController.checkExistenceinProviders(MobileNumber)){
            System.out.print("please enter a unique UserName :");
            String UN=scanner.next();
            if(appController.checkUserNameAvailability(UN)) {
                System.out.println("please enter a Strong password");
                String PW = scanner.next();
                InstapayAccount instapayAccount = new AccountWithWallet(UN,PW);
                database.addAccount(instapayAccount);
                return instapayAccount;
            }
        }
        else if(appController.checkExistenceinBanks(MobileNumber)){
            System.out.print("please enter a unique UserName :");
            String UN=scanner.next();
            if(appController.checkUserNameAvailability(UN)) {
                System.out.println("please enter a Strong password");
                String PW = scanner.next();
                InstapayAccount instapayAccount = new AccountWithBank(UN,PW);
                database.addAccount(instapayAccount);
                return instapayAccount;
            }
        }
        System.out.println("Your number does not exist in Bank API or any StrategyPattern.WalletProviders");
        return null;
    }
}
