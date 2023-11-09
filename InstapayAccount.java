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
        System.out.println("Your currency is "+currency);
    }
    abstract boolean signup(String mobile_no);
      abstract boolean signin(String UserName,String Password);
    public void transfer(double amount) {
        if(amount>balance){
            System.out.println("You do not have enough funds");
            return;
        }
        System.out.println("please enter the userName that you want to transfer to :");
        Scanner scanner = new Scanner(System.in);
        String UN = scanner.next();
        Database database = Database.getDatabase();
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
