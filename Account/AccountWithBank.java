package Account;

import java.util.Scanner;

public class AccountWithBank extends InstapayAccount {
    public AccountWithBank(String userName,String password) {
        this.userName = userName;
        this.password = password;
        balance =0;
        type ="Bank account";
    }

    public AccountWithBank() {
        balance =0;
    }


}
