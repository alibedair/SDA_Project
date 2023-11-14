package WalletFactory;

import Account.InstapayAccount;
import DatabaseManagemnet.AppController;
import Strategy.Transference;
import DatabaseManagemnet.Database;

import java.util.Scanner;
public abstract class WalletProviders implements Transference {
    protected    String MobileNumber;
    protected double balance;
   protected String company;
    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void transfer(double amount, InstapayAccount instapayAccount) {
        if(amount>instapayAccount.InquireBalance()){
            System.out.println("You do not have enough funds");
            return;
        }
        System.out.println("please enter the Mobile number of the Wallet account that you want to transfer to :");
        Scanner scanner = new Scanner(System.in);
        String MN = scanner.next();
        Database database = Database.getDatabase();
        AppController appController=new AppController(database);
        if(appController.checkExistenceinProviders(MN)){
            int pointer = database.getWalletAccountIndex(MN);
            double newBalance = database.getWalletAccounts().get(pointer).getBalance();
            newBalance += amount;
            database.getWalletAccounts().get(pointer).setBalance(newBalance);
            double decreaseBalance = instapayAccount.InquireBalance();
            decreaseBalance -=amount;
            instapayAccount.setBalance(decreaseBalance);
            System.out.println("Your transference is done Successfully with "+company);
        }
        else {
            System.out.println("You enter Invalid Mobile number of wallet account");
}
    }
}
