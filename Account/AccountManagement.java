package Account;

import DatabaseManagemnet.AppController;
import DatabaseManagemnet.Database;

import java.util.Scanner;

public class AccountManagement {
    public InstapayAccount sign_in(String UserName, String Password){
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

    public InstapayAccount Sign_up(String option){
        Database database = Database.getDatabase();
        AppController appController = new AppController(database);
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        boolean retry = true;
        if(option.equals("2")){
            System.out.println("please enter your Mobile number associated with any Wallet providers :");
            String MobileNumber = scanner.next();
            String OTP=appController.sendingOTP(MobileNumber);
            System.out.println("OTP = "+OTP);
            System.out.print("please enter the OTP :");
            String enteredOTP = scanner.next();
            if(!appController.isVerified(enteredOTP,OTP)){
                System.out.println("OTP is wrong ");
                return null;
            }
            if(appController.checkExistenceinProviders(MobileNumber)) {
                while (retry) {
                    System.out.print("please enter a unique UserName :");
                    String UN = scanner.next();
                    if (appController.checkUserNameAvailability(UN)) {
                        flag = true;
                        retry = false;
                        System.out.println("please enter a Strong password :");
                        String PW = scanner.next();
                        InstapayAccount instapayAccount = new AccountWithWallet(UN, PW);
                        database.addAccount(instapayAccount);
                        return instapayAccount;
                    }
                }
            }
        }
        else if(option.equals("1")) {
            System.out.println("please enter your Mobile number associated with any Bank :");
            String MobileNumber = scanner.next();
            String OTP=appController.sendingOTP(MobileNumber);
            System.out.print("please enter the OTP :");
            String enteredOTP = scanner.next();
            appController.isVerified(enteredOTP,OTP);
            if(!appController.isVerified(enteredOTP,OTP)){
                System.out.println("OTP is wrong ");
                return null;
            }
            if (appController.checkExistenceinBanks(MobileNumber)) {
                while (retry){
                System.out.print("please enter a unique UserName :");
                String UN = scanner.next();
                if (appController.checkUserNameAvailability(UN)) {
                    flag = true;
                    retry = false;
                    System.out.println("please enter a Strong password :");
                    String PW = scanner.next();
                    InstapayAccount instapayAccount = new AccountWithBank(UN, PW);
                    database.addAccount(instapayAccount);
                    return instapayAccount;
                }
                }
            }
        }
        if(!flag)
        System.out.println("Your number does not exist in Bank API or any WalletProviders");
        return null;
    }
}
