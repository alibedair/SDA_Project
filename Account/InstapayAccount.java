package Account;


public abstract class InstapayAccount  {
    protected String userName;
    protected String password;
    protected double balance;
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
    public void loadProfile(){
        System.out.println("Signed in with UserName :"+getUserName());
        System.out.println("Your balance : " + InquireBalance());
    }
    public void getFeatures(){
        System.out.println("press 1 if you want to transfer to another Instapay account");
        System.out.println("press 2 if you want to transfer to a Bank account");
        System.out.println("press 3 if you want to transfer to a Wallet  account");
        System.out.println("press 4 if you want to view your balance");
        System.out.println("press 5 if you want to increase your balance");
        System.out.println("press 6 if you want to pay a bill");
        System.out.println("press 0 if you want to Sign out");
    }
}
