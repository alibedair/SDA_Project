package DatabaseManagemnet;

import Account.InstapayAccount;
import ThirdParty.BankAPI;
import WalletFactory.WalletProviders;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static  Database database ;
    private List<InstapayAccount> SavedAccounts;

    public List<InstapayAccount> getSavedAccounts() {
        return SavedAccounts;
    }
    private List<WalletProviders> WalletAccounts;
    private List<BankAPI> BankAccounts;

    public List<BankAPI> getBankAccounts() {
        return BankAccounts;
    }
    private Database() {
        WalletAccounts = new ArrayList<>();
        BankAccounts = new ArrayList<>();
        SavedAccounts = new ArrayList<>();
    }

    public static Database getDatabase() {
        if(database==null)
            database = new Database();
        return database;
    }

    public List<WalletProviders> getWalletAccounts() {
        return WalletAccounts;
    }

    //to check the account in Inatpayaccounts
    /*
    public boolean checkAccountExistence(String UN){
        if(SavedAccounts.isEmpty()){
            return false;
        }
        else {
            for (int i =0;i<SavedAccounts.size();i++){
                if(SavedAccounts.get(i).getUserName().equals(UN)){
                    return true;
                }
            }
        }
        return false;
    }*/
    public int getAccountIndex(String UN){
        int index = -1;
        for (int i =0;i<SavedAccounts.size();i++){
            if (SavedAccounts.get(i).getUserName().equals(UN))
                index = i;
        }
        return index;
    }
    //Wallet account list getter
    public int getWalletAccountIndex(String MN){
        int index = -1;
        for (int i =0;i<getWalletAccounts().size();i++){
            if (WalletAccounts.get(i).getMobileNumber().equals(MN))
                index = i;
        }
        return index;
    }
    //Bank account list getter
    public int getBankAccountIndex(String MN){
        int index = -1;
        for (int i =0;i<BankAccounts.size();i++){
            if (BankAccounts.get(i).getMobileNumber().equals(MN))
                index = i;
        }
        return index;
    }
    public void addAccount(InstapayAccount instapayAccount){
        SavedAccounts.add(instapayAccount);
   }
    public void addBankAccount(BankAPI bankAccount){
        BankAccounts.add(bankAccount);
    }
    public void addWalletAccount(WalletProviders walletAccount){WalletAccounts.add(walletAccount);
    }
    public void printSavedAccounts(){
        for (int i=0;i<SavedAccounts.size();i++){
            System.out.println("User name:"+SavedAccounts.get(i).getUserName());
            System.out.println("Balance:"+SavedAccounts.get(i).InquireBalance());

        }
    }
    public void printBankAccounts(){
        for (int i=0;i<BankAccounts.size();i++){
            System.out.println("Mobile number:"+BankAccounts.get(i).getMobileNumber());
            System.out.println("Balance:"+BankAccounts.get(i).getBalance());

        }
    }
    public void printWalletAccounts(){
        for (int i=0;i<WalletAccounts.size();i++){
            System.out.println("Mobile number:"+WalletAccounts.get(i).getMobileNumber());
            System.out.println("Balance:"+WalletAccounts.get(i).getBalance());

        }
    }
}
