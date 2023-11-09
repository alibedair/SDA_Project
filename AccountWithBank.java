import java.util.Scanner;

public class AccountWithBank extends InstapayAccount{
    public AccountWithBank(String userName,String password) {
        this.userName = userName;
        this.password = password;
        balance =0;
    }
    @Override
    boolean signup(String mobile_no) {
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getDatabase();
        if(database.checkExistenceinBanks(mobile_no)){
            System.out.println("please set your Username :");
            setUserName(scanner.next());
            System.out.println("please set your password :");
            setPassword(scanner.next());
            database.addAccount(this);
            return true;
        }
        else {
            System.out.println("your entered a number does not exist in Bank list ");
            return false;
        }
    }

    public AccountWithBank() {
        balance =0;
    }


}
