package Account;

import java.util.Scanner;

public class AccountWithWallet extends InstapayAccount {
    public AccountWithWallet(String userName,String password) {
        this.userName = userName;
        this.password = password;
        balance =0;
        type = "Wallet account";
    }



    public AccountWithWallet() {
        balance =0;
    }
}
