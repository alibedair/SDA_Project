package ThirdParty;

import Account.InstapayAccount;
import DatabaseManagemnet.AppController;
import Strategy.Transference;
import DatabaseManagemnet.Database;

import java.util.Scanner;
public class BankAPI implements Transference {
    private   String MobileNumber;
    private double balance;

    public BankAPI(String MobileNumber) {
        this.MobileNumber = MobileNumber;
        balance =0;
    }
    public BankAPI(String MobileNumber,double balance) {
        this.MobileNumber = MobileNumber;
        this.balance=balance;
    }
    public String getMobileNumber() {
        return MobileNumber;
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
        System.out.println("please enter the Mobile number of the Bank account that you want to transfer to :");
        Scanner scanner = new Scanner(System.in);
        String MN = scanner.next();
        Database database = Database.getDatabase();
        AppController appController=new AppController(database);
        if(appController.checkExistenceinBanks(MN)){
            int pointer = database.getBankAccountIndex(MN);
            double newBalance = database.getBankAccounts().get(pointer).getBalance();
            newBalance += amount;
            database.getBankAccounts().get(pointer).setBalance(newBalance);
            double decreaseBalance = instapayAccount.InquireBalance();
            decreaseBalance -=amount;
            instapayAccount.setBalance(decreaseBalance);
            System.out.println("Your transference is done Successfully");
        }
        else {
            System.out.println("You enter Invalid Mobile number of Bank account");}
    }
}
