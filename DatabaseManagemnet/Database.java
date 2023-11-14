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
}
