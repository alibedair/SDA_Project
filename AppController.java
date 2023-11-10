import java.util.Random;

public class AppController {

    private Database database = Database.getDatabase();

    public String sendingOTP(String mobileNum) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$";

        Random r = new Random();
        StringBuilder otpValue = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = r.nextInt(characters.length());
            otpValue.append(characters.charAt(index));
        }
        System.err.println("Sending a one-time password to " + mobileNum + ": " + otpValue);
        return otpValue.toString();
    }

    public boolean isVerified(String enteredOTP, String expectedOTP) {
        return enteredOTP.equals(expectedOTP);
    }

    
    public boolean checkExistenceinProviders(String number) {
        if (database.getWalletAccounts().isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < database.getWalletAccounts().size(); i++) {
                if (database.getWalletAccounts().get(i).getMobileNum().equals(number))
                    return true;
            }
        }
        return false;
    }

    
    public boolean checkExistenceinBanks(String number) {
        if (database.getBankAccounts().isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < database.getBankAccounts().size(); i++) {
                if (database.getBankAccounts().get(i).getMobileNum().equals(number))
                    return true;
            }
        }
        return false;
    }

    
    public boolean checkAccountExistence(String UN) {
        if (database.getSavedAccounts().isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < database.getSavedAccounts().size(); i++) {
                if (database.getSavedAccounts().get(i).getUserName().equals(UN)) {
                    return true;
                }
            }
        }
        return false;
    }

}
