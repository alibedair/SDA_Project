package Strategy;

import Account.InstapayAccount;

public class Context {
    private Transference transference;

    public Context(Transference transference) {
        this.transference = transference;
    }
    public void ChooseTransference(double amount, InstapayAccount instapayAccount){
        transference.transfer(amount,instapayAccount);
    }
}
