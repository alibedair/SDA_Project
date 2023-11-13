package Account;

import java.util.Scanner;
public abstract class InstapayAccount  {
    protected String userName;
    protected String password;
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
    public void loadProfile(){
        System.out.println("Signed in with UserName :"+getUserName());
        System.out.println("Your balance : " + InquireBalance());
    }
}
