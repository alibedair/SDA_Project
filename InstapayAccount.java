import java.util.List;
import java.util.Scanner;

public abstract class InstapayAccount  {
    protected String userName;
    protected String password;
    protected String currency;
    protected double balance;

    public double InquireBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void loadProfile(){
        System.out.println("Signed in with UserName :"+getUserName());
        System.out.println("Your balance : "+InquireBalance()+" "+getCurrency());

    }
    abstract boolean signup(String mobile_no);
      boolean signin(String userName,String password){
          System.out.println("please enter your UserName :  ");
          Scanner scanner = new Scanner(System.in);
          String Uname = scanner.next();
          System.out.println("please enter your Password :  ");
          String pass = scanner.next();
          Database database = Database.getDatabase();
          for(int i =0;i<database.getSavedAccounts().size();i++){
              if(this.equals(database.getSavedAccounts().get(i))){
                  System.out.println("You have Signed in successfully");
                  loadProfile();
                  return true;
              }
          }
          System.out.println("Invalid userName or password");
          return false;
      };
    public void transfer(double amount) {
        if(amount>balance){
            System.out.println("You do not have enough funds");
            return;
        }
        System.out.println("please enter the userName that you want to transfer to :");
        Scanner scanner = new Scanner(System.in);
        String UN = scanner.next();
        Database database = Database.getDatabase();;
        if(database.checkAccountExistence(UN)){
            int pointer = database.getAccountIndex(UN);
            double newBalance = database.getSavedAccounts().get(pointer).InquireBalance();
            newBalance += amount;
            database.getSavedAccounts().get(pointer).setBalance(newBalance);
            balance -=amount;
            System.out.println("Your transference is done Successfully");
        }
        else {
            System.out.println("You enter Invalid UserName");
        }
    }

    public void addtoBalance(double amount){
        balance += amount;
    }
}
