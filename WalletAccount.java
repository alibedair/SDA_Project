import java.util.Scanner;

public class WalletAccount extends ExternalAccount{
    public WalletAccount(String MobileNum) {
        this.MobileNum = MobileNum;
    }

    public WalletAccount() {
    }

    @Override
    public void transfer(double amount,InstapayAccount instapayAccount) {
        if(amount>instapayAccount.InquireBalance()){
            System.out.println("You do not have enough funds");
            return;
        }
        System.out.println("please enter the Mobile number of the Wallet account that you want to transfer to :");
        Scanner scanner = new Scanner(System.in);
        String MN = scanner.next();
        Database database = Database.getDatabase();
        AppController appController=new AppController();
        if(appController.checkExistenceinProviders(MN)){
            int pointer = database.getWalletAccountIndex(MN);
            double newBalance = database.getWalletAccounts().get(pointer).getBalanceof();
            newBalance += amount;
            database.getWalletAccounts().get(pointer).setBalanceof(newBalance);
            double decreaseBalance = instapayAccount.InquireBalance();
            decreaseBalance -=amount;
            instapayAccount.setBalance(decreaseBalance);
            System.out.println("Your transference is done Successfully");
        }
        else {
            System.out.println("You enter Invalid Mobile number of wallet account");
        }
    }
    }
