package Strategy;

import Account.InstapayAccount;

public interface Transference {
    public void transfer(double amount, InstapayAccount instapayAccount);
}
