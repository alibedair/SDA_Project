
abstract public class ExternalAccount implements Transference{
    protected double balanceof;
    protected String MobileNum;

    public String getMobileNum() {
        return MobileNum;
    }

    public void setMobileNum(String mobileNum) {
        MobileNum = mobileNum;
    }

    public double getBalanceof() {
        return balanceof;
    }

    public void setBalanceof(double balanceof) {
        this.balanceof = balanceof;
    }

    @Override
    abstract public void transfer(double amount,InstapayAccount instapayAccount);
}
