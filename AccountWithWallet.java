import java.util.Scanner;

public class AccountWithWallet extends InstapayAccount{
    public AccountWithWallet(String userName,String password) {
        this.userName = userName;
        this.password = password;
        balance =0;
    }

    @Override
    boolean signup(String mobile_no) {
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getDatabase();
        AppController appController = new AppController();
        
        boolean flag = false;
        if(appController.checkExistenceinProviders(mobile_no)) {
            flag = true;
            //Scanner scanner = new Scanner(System.in);
            System.out.println("please set your Username :");
            String intialUserName = scanner.next();
            if (appController.checkUserNameAvailability(intialUserName)) {
                setUserName(intialUserName);
                System.out.println("please set your password :");
                setPassword(scanner.next());
                database.addAccount(this);
                return true;
            }
        }
        if(!flag) {
            System.out.println("your entered a number does not exist in Wallet list ");
        }
            return false;
        }

    @Override
    boolean signin(String UserName, String Password, String mobile_no) {
        Scanner scanner = new Scanner(System.in);
        InstapayAccount instapayAccount = new AccountWithWallet(UserName,Password);
        Database database = Database.getDatabase();
        AppController appController=new AppController();
        String otp = appController.sendingOTP(mobile_no);
        String enteredOTP = scanner.next();

        if (appController.isVerified(enteredOTP, otp)) {
            System.out.println("You're verified!");
        } else {
            System.out.println("The entered otp is wrong!");
            return false;
        }
        
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
        balance =0;
    }
}
