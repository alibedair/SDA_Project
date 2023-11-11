import java.util.Scanner;

public class AccountWithBank extends InstapayAccount{
    public AccountWithBank(String userName,String password) {
        this.userName = userName;
        this.password = password;
        currency = "Dollars";
        balance =0;
    }
    @Override
    boolean signup(String mobile_no) {
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getDatabase();
        AppController appController=new AppController();
        boolean flag = false;
        if(appController.checkExistenceinBanks(mobile_no)){
            //Scanner scanner = new Scanner(System.in);
            System.out.println("please set your Username :");
            String intialUserName = scanner.next();
            flag = true;
            if(appController.checkUserNameAvailability(intialUserName)) {
                setUserName(intialUserName);
                System.out.println("please set your password :");
                setPassword(scanner.next());
                database.addAccount(this);
                return true;
            }
        }
        if(!flag) {
            System.out.println("your entered a number does not exist in Bank list ");
        }
            return false;
    }

    @Override
    boolean signin(String UserName, String Password, String mobile_no) {
        Scanner scanner = new Scanner(System.in);
        InstapayAccount instapayAccount = new AccountWithBank(UserName, Password);
        Database database = Database.getDatabase();
        AppController appController = new AppController();
        System.out.println("please enter your mobile num :  ");
        String mobileNum = scanner.next();
        String otp = appController.sendingOTP(mobile_no);
        String enteredOTP = scanner.next();

        if (appController.isVerified(enteredOTP, otp)) {
            System.out.println("You're verified!");
        } else {
            System.out.println("The entered otp is wrong!");
            return false;
        }
        for (int i = 0; i < database.getSavedAccounts().size(); i++) {
            if (instapayAccount.getUserName().equals(database.getSavedAccounts().get(i).getUserName()) && instapayAccount.getPassword().equals(database.getSavedAccounts().get(i).getPassword())) {
                appController.sendingOTP(mobileNum);
                System.out.println("You have Signed in successfully");
                database.getSavedAccounts().get(i).loadProfile();
                return true;
            }
        }
        System.out.println("Invalid userName or password");
        return false;
    }


    public AccountWithBank() {
        balance =0;
        currency = "Dollars";
    }


}
