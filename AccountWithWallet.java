import java.util.Scanner;

public class AccountWithWallet extends InstapayAccount{
    public AccountWithWallet(String userName,String password) {
        this.userName = userName;
        this.password = password;
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

    public AccountWithWallet() {
        balance =0;
    }
}
