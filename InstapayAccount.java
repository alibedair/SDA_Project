public abstract class InstapayAccount implements Transference {
    private String userName;
    private String password;
    private String currency;
    private double balance;
    private boolean Status;

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void loadProfile(){
        System.out.println("Signed in with UserName :"+getUserName());
        if (getStatus()) {
            System.out.println("Your Status is active");
            System.out.println("Your balance : "+InquireBalance()+" "+getCurrency());
        }
        else {
            System.out.println("Your Status is inactive ");
        }
    }
    abstract void signup(String mobile_no);
    abstract void signin(String userName,String password);

    @Override
   abstract public void transfer(String Mobile_no,int amount);
}
