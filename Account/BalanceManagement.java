package Account;
import DatabaseManagemnet.AppController;
import Strategy.Transference;
import DatabaseManagemnet.Database;

import java.util.Scanner;

public class BalanceManagement implements Transference {
    public BalanceManagement() {
    }
    @Override
    public void transfer(double amount, InstapayAccount instapayAccount) {
        if(amount>instapayAccount.InquireBalance()){
            System.out.println("You do not have enough funds");
            return;
        }
        double balancaDecrease = instapayAccount.InquireBalance();
        System.out.println("please enter the userName that you want to transfer to :");
        Scanner scanner = new Scanner(System.in);
        String UN = scanner.next();
        Database database = Database.getDatabase();
        AppController appController = new AppController(database);
        if(appController.checkAccountExistence(UN)){
            int pointer = database.getAccountIndex(UN);
            double newBalance = database.getSavedAccounts().get(pointer).InquireBalance();
            newBalance += amount;
            database.getSavedAccounts().get(pointer).setBalance(newBalance);
            balancaDecrease -=amount;
            instapayAccount.setBalance(balancaDecrease);
            System.out.println("Your transference is done Successfully");
        }
        else {
            System.out.println("You enter Invalid UserName");
        }
    }
    public void addtoBalance(InstapayAccount instapayAccount ,double amount){
        double newBalance =instapayAccount.InquireBalance();
               newBalance += amount;
               instapayAccount.setBalance(newBalance);
    }
}
