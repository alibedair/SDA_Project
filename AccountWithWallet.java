import java.util.Scanner;

public class AccountWithWallet extends InstapayAccount{
    public AccountWithWallet(String userName,String password) {
        this.userName = userName;
        this.password = password;
        type = "Wallet account";
        balance =0;
    }

    @Override
    boolean signup(String mobile_no) {
        Database database = Database.getDatabase();
        Scanner scanner = new Scanner(System.in);
        if(database.checkExistenceinProviders(mobile_no)){
           System.out.println("please set your Username :");
           setUserName(scanner.next());
           System.out.println("please set your password :");
           setPassword(scanner.next());
           database.addAccount(this);
           return true;
        }
        else {
            System.out.println("your entered a number does not exist in Wallet list ");
            return false;
        }
    }

    @Override
    boolean signin(String UserName, String Password) {
        InstapayAccount instapayAccount = new AccountWithWallet(UserName,Password);
        Database database = Database.getDatabase();
        for(int i =0;i<database.getSavedAccounts().size();i++){
            if(instapayAccount.getUserName().equals(database.getSavedAccounts().get(i).getUserName())&& instapayAccount.getPassword().equals(database.getSavedAccounts().get(i).getPassword())){
                System.out.println("You have Signed in successfully");
                database.getSavedAccounts().get(i).loadProfile();
                return true;
            }
        }
        System.out.println("Invalid userName or password");
        return false;
    }

    public AccountWithWallet() {
        type = "Wallet account";
        balance =0;
    }
}
