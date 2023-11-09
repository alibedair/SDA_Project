import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppController {

    private List<WalletAccount> WalletAccounts=new ArrayList<>();
    private List<BankAccount> BankAccounts=new ArrayList<>();
    private List<InstapayAccount> SavedAccounts=new ArrayList<>();

    public String sendingOTP(String mobileNum) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$";

        Random r = new Random();
        StringBuilder otpValue = new StringBuilder();
        for(int i=0; i<8; i++){
            int index=r.nextInt(characters.length());
            otpValue.append(characters.charAt(index));
        }
        System.err.println("Sending a one-time password to " + mobileNum + ": " + otpValue);
        return otpValue.toString();
    }
    
    public boolean isVerified(String enteredOTP, String expectedOTP){
        return enteredOTP.equals(expectedOTP);
    }

 public boolean checkAccountExistence(String UN) {
        if (SavedAccounts.isEmpty()) {
            return false;
        } else {
            for (InstapayAccount account : SavedAccounts) {
                if (account.getUserName().equals(UN)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkExistenceinProviders(String number) {
        if (WalletAccounts.isEmpty()) {
            return false;
        } else {
            for (WalletAccount walletAccount : WalletAccounts) {
                if (walletAccount.getMobileNum().equals(number)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkExistenceinBanks(String number) {
        if (BankAccounts.isEmpty()) {
            return false;
        } else {
            for (BankAccount bankAccount : BankAccounts) {
                if (bankAccount.getMobileNum().equals(number)) {
                    return true;
                }
            }
        }
        return false;
    }
}